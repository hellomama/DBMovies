package com.tony.dbmovie.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.tony.dbmovie.R;

import java.io.IOException;
import java.util.Locale;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by dev on 2/11/18.
 */

public class IjkPlayerView extends FrameLayout {

    private static String FORMAT_TIME = "%02d:%02d";

    private Context context;
    private String mPath;
    private SurfaceView surfaceView;
    private IMediaPlayer mediaPlayer;
    private VideoPlayListener listener;
    private View timeLine;
    private boolean showing = true;
    private TextView endTime,currentTime;
    private SeekBar seekBar;
    private Handler handler = new Handler();

    private Runnable progressRunnable = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress((int)mediaPlayer.getCurrentPosition());
            currentTime.setText(getVideoTime(mediaPlayer.getCurrentPosition()));
            handler.postDelayed(this,1000);
        }
    };

    public IjkPlayerView(Context context) {
        super(context);
        initLayout(context);
    }

    public IjkPlayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public IjkPlayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context context)
    {
        this.context = context;
    }

    private class ijkSurfaceCallback implements SurfaceHolder.Callback
    {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            load();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }

    public void setListener(VideoPlayListener listener) {
        this.listener = listener;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(listener);
        }
    }

    public void setVideoPath(String path)
    {
        if (TextUtils.isEmpty(mPath))
        {
            mPath = path;
            createSurfaceView();
        }else {
            mPath = path;
            load();
        }
    }

    private void createSurfaceView()
    {
        surfaceView = new SurfaceView(context);
        surfaceView.getHolder().addCallback(new ijkSurfaceCallback());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        surfaceView.setLayoutParams(layoutParams);
        addView(surfaceView);

        timeLine = LayoutInflater.from(context).inflate(R.layout.view_time_line,this,false);
        seekBar = timeLine.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                {
                    seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        endTime = timeLine.findViewById(R.id.end_time);
        currentTime = timeLine.findViewById(R.id.current_time);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSeekBar();
            }
        });
        FrameLayout.LayoutParams layoutParam = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);
        timeLine.setLayoutParams(layoutParam);
        addView(timeLine);
    }

    private void updateSeekBar()
    {
        timeLine.setVisibility(showing?GONE:VISIBLE);
        showing = !showing;
    }

    public void updateUI()
    {
        endTime.setText(getVideoTime(getDuration()));
        seekBar.setMax((int)getDuration());
    }

    private void createPlayer()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.setDisplay(null);
            mediaPlayer.release();
        }

        IjkMediaPlayer player = new IjkMediaPlayer();
        player.setLogEnabled(true);

        mediaPlayer = player;

        if (listener != null)
        {
            mediaPlayer.setOnBufferingUpdateListener(listener);
            mediaPlayer.setOnCompletionListener(listener);
            mediaPlayer.setOnErrorListener(listener);
            mediaPlayer.setOnInfoListener(listener);
            mediaPlayer.setOnPreparedListener(listener);
            mediaPlayer.setOnSeekCompleteListener(listener);
            mediaPlayer.setOnVideoSizeChangedListener(listener);
        }
    }

    private void load()
    {
        createPlayer();
        try {
            mediaPlayer.setDataSource(mPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //给mediaPlayer设置视图
        mediaPlayer.setDisplay(surfaceView.getHolder());

        mediaPlayer.prepareAsync();
    }

    public void start()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.start();
            handler.post(progressRunnable);
        }
    }

    public void stop()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.stop();
        }
    }

    public void pause()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.pause();
        }
    }

    public long getDuration()
    {
        if (mediaPlayer != null)
        {
            Log.d("Duration",""+mediaPlayer.getDuration());
            return mediaPlayer.getDuration();
        }

        return 0;
    }

    private String getVideoTime(long time)
    {
        int sec = 0,min = 0;
        if (time >= 0)
        {
            min = (int)Math.ceil(time/(60*1000));
            sec = (int)Math.ceil(time - min * 60 *1000)/1000;
        }
        return String.format(Locale.getDefault(),FORMAT_TIME,min,sec);
    }

    public void seekTo(long l)
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.seekTo(l);
        }
    }



}
