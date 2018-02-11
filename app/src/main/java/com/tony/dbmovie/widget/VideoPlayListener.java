package com.tony.dbmovie.widget;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * Created by dev on 2/11/18.
 */

public abstract class VideoPlayListener implements IMediaPlayer.OnBufferingUpdateListener,
        IMediaPlayer.OnCompletionListener,IMediaPlayer.OnPreparedListener,IMediaPlayer.OnInfoListener,
        IMediaPlayer.OnVideoSizeChangedListener,IMediaPlayer.OnErrorListener,IMediaPlayer.OnSeekCompleteListener {
}
