package com.tony.dbmovie.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by dev on 2/11/18.
 */

public class IjkPlayerView extends FrameLayout {

    private Context context;
    private String mPath;
    private SurfaceView surfaceView;
    private IMediaPlayer mediaPlayer;
    private VideoPlayListener listener;

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

    public void setVideoPlayListener(VideoPlayListener listener)
    {
        this.listener = listener;
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
            return mediaPlayer.getDuration();
        }

        return 0;
    }

    public void seekTo(long l)
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.seekTo(l);
        }
    }

}
