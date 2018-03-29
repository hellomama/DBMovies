package com.tony.dbmovie.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.data.Trailer;
import com.tony.dbmovie.widget.IjkPlayerView;
import com.tony.dbmovie.widget.VideoPlayListener;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by dev on 2/11/18.
 */

public class TrailerActivity extends BaseActivity {

    private final static String EXTRA_DATA = "data";

    private IjkPlayerView playerView;
    private ImageView play;
    private Trailer trailer;
    private boolean isPlaying = false;

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
        Toolbar toolbar = findViewById(R.id.toolbar);
        initToolbarNav(toolbar);
        init();
        toolbar.setTitle(trailer.getTitle());
        try {
            IjkMediaPlayer.loadLibrariesOnce(null);
            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        } catch (Exception e) {
            this.finish();
        }
        playerView.setListener(new VideoPlayListener() {
            @Override
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                Log.d("onBufferingUpdate","update" + i);
            }

            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {

            }

            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                Log.d("onError","update" + i);
                return false;
            }

            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                Log.d("onInfo","update i - " + i+" i1 - "+i1);
                return false;
            }

            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                playerView.updateUI();
                startPlay();
            }

            @Override
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {

            }

            @Override
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {

            }
        });
        playerView.setVideoPath(trailer.getResourceUrl());
//        playerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isPlaying) {
//                    stopPlay();
//                }else {
//                    startPlay();
//                }
//            }
//        });
    }

    private void startPlay()
    {
        isPlaying = true;
        playerView.start();
        play.setVisibility(View.GONE);
    }

    private void stopPlay()
    {
        isPlaying = false;
        playerView.pause();
        play.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        IjkMediaPlayer.native_profileEnd();
        isPlaying = false;
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
