package tv.danmaku.ijk.media.player;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.os.Bundle;

import java.io.IOException;
import java.util.Map;

/**
 * 本地实现的 IjkMediaPlayer 类，用于替代原始的 IJKMedia 库
 */
public class IjkMediaPlayer implements IMediaPlayer {

    // 日志级别常量
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_WARN = 5;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_SILENT = 8;

    // 选项类别常量
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int OPT_CATEGORY_PLAYER = 4;

    // 内部使用原生Android MediaPlayer
    private android.media.MediaPlayer mMediaPlayer;
    private int mState = MEDIA_INFO_UNKNOWN;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private OnPreparedListener onPreparedListener;
    private OnCompletionListener onCompletionListener;
    private OnBufferingUpdateListener onBufferingUpdateListener;
    private OnErrorListener onErrorListener;
    private OnInfoListener onInfoListener;
    private OnSeekCompleteListener onSeekCompleteListener;
    private OnVideoSizeChangedListener onVideoSizeChangedListener;
    private OnTimedTextListener onTimedTextListener;

    public IjkMediaPlayer() {
        mMediaPlayer = new android.media.MediaPlayer();
        setupListeners();
    }

    private void setupListeners() {
        mMediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(android.media.MediaPlayer mp) {
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(IjkMediaPlayer.this);
                }
            }
        });

        mMediaPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(android.media.MediaPlayer mp) {
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(IjkMediaPlayer.this);
                }
            }
        });

        mMediaPlayer.setOnBufferingUpdateListener(new android.media.MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(android.media.MediaPlayer mp, int percent) {
                if (onBufferingUpdateListener != null) {
                    onBufferingUpdateListener.onBufferingUpdate(IjkMediaPlayer.this, percent);
                }
            }
        });

        mMediaPlayer.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(android.media.MediaPlayer mp, int what, int extra) {
                if (onErrorListener != null) {
                    return onErrorListener.onError(IjkMediaPlayer.this, what, extra);
                }
                return false;
            }
        });

        mMediaPlayer.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(android.media.MediaPlayer mp, int what, int extra) {
                if (onInfoListener != null) {
                    return onInfoListener.onInfo(IjkMediaPlayer.this, what, extra);
                }
                return false;
            }
        });

        mMediaPlayer.setOnSeekCompleteListener(new android.media.MediaPlayer.OnSeekCompleteListener() {
            @Override
            public void onSeekComplete(android.media.MediaPlayer mp) {
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete(IjkMediaPlayer.this);
                }
            }
        });

        mMediaPlayer.setOnVideoSizeChangedListener(new android.media.MediaPlayer.OnVideoSizeChangedListener() {
            @Override
            public void onVideoSizeChanged(android.media.MediaPlayer mp, int width, int height) {
                mVideoWidth = width;
                mVideoHeight = height;
                if (onVideoSizeChangedListener != null) {
                    onVideoSizeChangedListener.onVideoSizeChanged(IjkMediaPlayer.this, width, height, 1, 1);
                }
            }
        });
    }

    public static void native_setLogLevel(int level) {
        // 模拟设置日志级别
    }

    public void setOption(int category, String name, String value) {
        // 模拟设置选项
    }

    public void setOption(int category, String name, long value) {
        // 模拟设置选项
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
        return mMediaPlayer.toString(); // 简单返回MediaPlayer字符串表示
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
    public void setOnPreparedListener(OnPreparedListener listener) {
        this.onPreparedListener = listener;
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        this.onCompletionListener = listener;
    }

    @Override
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {
        this.onBufferingUpdateListener = listener;
    }

    @Override
    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {
        this.onSeekCompleteListener = listener;
    }

    @Override
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        this.onVideoSizeChangedListener = listener;
    }

    @Override
    public void setOnErrorListener(OnErrorListener listener) {
        this.onErrorListener = listener;
    }

    @Override
    public void setOnInfoListener(OnInfoListener listener) {
        this.onInfoListener = listener;
    }

    @Override
    public void setOnTimedTextListener(OnTimedTextListener listener) {
        this.onTimedTextListener = listener;
    }

    @Override
    public void setSurface(Surface surface) {
        mMediaPlayer.setSurface(surface);
    }
}
