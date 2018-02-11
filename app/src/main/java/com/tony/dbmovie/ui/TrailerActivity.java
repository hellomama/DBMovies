package com.tony.dbmovie.ui;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Movie;
import com.tony.dbmovie.data.Trailer;
import com.tony.dbmovie.widget.IjkPlayerView;
import com.tony.dbmovie.widget.VideoPlayListener;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by dev on 2/11/18.
 */

public class TrailerActivity extends AppCompatActivity {

    private final static String EXTRA_DATA = "data";

    private IjkPlayerView playerView;
    private ImageView play;
    private Trailer trailer;

    public static void startActivity(Context context, Trailer trailer)
    {
        Intent starter = new Intent(context, TrailerActivity.class);
        starter.putExtra(EXTRA_DATA,trailer);
        context.startActivity(starter);
    }

    private void init()
    {
        Intent intent = getIntent();
        if (intent != null)
        {
            trailer = (Trailer) intent.getSerializableExtra(EXTRA_DATA);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trailer_detail_header);
        playerView = findViewById(R.id.player);
        play = findViewById(R.id.img_play);

        init();
        try {
            IjkMediaPlayer.loadLibrariesOnce(null);
            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        } catch (Exception e) {
            this.finish();
        }
        playerView.setListener(new VideoPlayListener() {
            @Override
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {

            }

            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {

            }

            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                return false;
            }

            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                return false;
            }

            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                iMediaPlayer.start();
            }

            @Override
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {

            }

            @Override
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {

            }
        });
        playerView.setVideoPath(trailer.getResourceUrl());


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        IjkMediaPlayer.native_profileEnd();
    }



    @Override
    protected void onPause() {
        playerView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
