package tv.danmaku.ijk.media.exo;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;

public class IjkExoMediaPlayer implements IMediaPlayer {
    private Context mContext;
    private android.media.MediaPlayer mMediaPlayer; // 使用系统MediaPlayer作为后备实现
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    
    private IMediaPlayer.OnPreparedListener onPreparedListener;
    private IMediaPlayer.OnCompletionListener onCompletionListener;
    private IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener;
    private IMediaPlayer.OnErrorListener onErrorListener;
    private IMediaPlayer.OnInfoListener onInfoListener;
    private IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
    private IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener;
    private IMediaPlayer.OnTimedTextListener onTimedTextListener;

    public IjkExoMediaPlayer(Context context) {
        mContext = context;
        mMediaPlayer = new android.media.MediaPlayer();
        setupListeners();
    }

    private void setupListeners() {
        mMediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(android.media.MediaPlayer mp) {
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(IjkExoMediaPlayer.this);
                }
            }
        });

        mMediaPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(android.media.MediaPlayer mp) {
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(IjkExoMediaPlayer.this);
                }
            }
        });

        mMediaPlayer.setOnBufferingUpdateListener(new android.media.MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(android.media.MediaPlayer mp, int percent) {
                if (onBufferingUpdateListener != null) {
                    onBufferingUpdateListener.onBufferingUpdate(IjkExoMediaPlayer.this, percent);
                }
            }
        });

        mMediaPlayer.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(android.media.MediaPlayer mp, int what, int extra) {
                if (onErrorListener != null) {
                    return onErrorListener.onError(IjkExoMediaPlayer.this, what, extra);
                }
                return false;
            }
        });

        mMediaPlayer.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(android.media.MediaPlayer mp, int what, int extra) {
                if (onInfoListener != null) {
                    return onInfoListener.onInfo(IjkExoMediaPlayer.this, what, extra);
                }
                return false;
            }
        });

        mMediaPlayer.setOnSeekCompleteListener(new android.media.MediaPlayer.OnSeekCompleteListener() {
            @Override
            public void onSeekComplete(android.media.MediaPlayer mp) {
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete(IjkExoMediaPlayer.this);
                }
            }
        });

        mMediaPlayer.setOnVideoSizeChangedListener(new android.media.MediaPlayer.OnVideoSizeChangedListener() {
            @Override
            public void onVideoSizeChanged(android.media.MediaPlayer mp, int width, int height) {
                mVideoWidth = width;
                mVideoHeight = height;
                if (onVideoSizeChangedListener != null) {
                    onVideoSizeChangedListener.onVideoSizeChanged(IjkExoMediaPlayer.this, width, height, 1, 1);
                }
            }
        });
    }

    @Override
    public void setDisplay(SurfaceHolder sh) {
        mMediaPlayer.setDisplay(sh);
    }

    @Override
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        mMediaPlayer.setDataSource(path);
    }

    @Override
    public String getDataSource() {
        return mMediaPlayer.toString();
    }

    @Override
    public void prepareAsync() throws IllegalStateException {
        mMediaPlayer.prepareAsync();
    }

    @Override
    public void start() throws IllegalStateException {
        mMediaPlayer.start();
    }

    @Override
    public void stop() throws IllegalStateException {
        mMediaPlayer.stop();
    }

    @Override
    public void pause() throws IllegalStateException {
        mMediaPlayer.pause();
    }

    @Override
    public void setScreenOnWhilePlaying(boolean screenOn) {
        mMediaPlayer.setScreenOnWhilePlaying(screenOn);
    }

    @Override
    public int getVideoWidth() {
        return mVideoWidth;
    }

    @Override
    public int getVideoHeight() {
        return mVideoHeight;
    }

    @Override
    public boolean isPlaying() {
        return mMediaPlayer.isPlaying();
    }

    @Override
    public void seekTo(long msec) throws IllegalStateException {
        mMediaPlayer.seekTo((int) msec);
    }

    @Override
    public long getCurrentPosition() {
        return mMediaPlayer.getCurrentPosition();
    }

    @Override
    public long getDuration() {
        return mMediaPlayer.getDuration();
    }

    @Override
    public void release() {
        mMediaPlayer.release();
    }

    @Override
    public void reset() {
        mMediaPlayer.reset();
    }

    @Override
    public void setVolume(float leftVolume, float rightVolume) {
        mMediaPlayer.setVolume(leftVolume, rightVolume);
    }

    @Override
    public int getAudioSessionId() {
        return mMediaPlayer.getAudioSessionId();
    }

    @Override
    public void setAudioStreamType(int streamtype) {
        mMediaPlayer.setAudioStreamType(streamtype);
    }

    @Override
    public void setLooping(boolean looping) {
        mMediaPlayer.setLooping(looping);
    }

    @Override
    public boolean isLooping() {
        return mMediaPlayer.isLooping();
    }

    @Override
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener listener) {
        this.onPreparedListener = listener;
    }

    @Override
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener listener) {
        this.onCompletionListener = listener;
    }

    @Override
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener listener) {
        this.onBufferingUpdateListener = listener;
    }

    @Override
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener listener) {
        this.onSeekCompleteListener = listener;
    }

    @Override
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener listener) {
        this.onVideoSizeChangedListener = listener;
    }

    @Override
    public void setOnErrorListener(IMediaPlayer.OnErrorListener listener) {
        this.onErrorListener = listener;
    }

    @Override
    public void setOnInfoListener(IMediaPlayer.OnInfoListener listener) {
        this.onInfoListener = listener;
    }

    @Override
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener listener) {
        this.onTimedTextListener = listener;
    }

    @Override
    public void setSurface(Surface surface) {
        mMediaPlayer.setSurface(surface);
    }
}
