package tv.danmaku.ijk.media.player;

import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.Map;

public interface IMediaPlayer {
    // 状态常量
    int MEDIA_INFO_UNKNOWN = 1;
    int MEDIA_INFO_STARTED_AS_NEXT = 2;
    int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    int MEDIA_INFO_BUFFERING_START = 701;
    int MEDIA_INFO_BUFFERING_END = 702;
    int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    int MEDIA_INFO_BAD_INTERLEAVING = 800;
    int MEDIA_INFO_NOT_SEEKABLE = 801;
    int MEDIA_INFO_METADATA_UPDATE = 802;
    int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;

    int MEDIA_ERROR_UNKNOWN = 1;
    int MEDIA_ERROR_SERVER_DIED = 100;
    int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    int MEDIA_ERROR_IO = -1004;
    int MEDIA_ERROR_MALFORMED = -1007;
    int MEDIA_ERROR_UNSUPPORTED = -1010;
    int MEDIA_ERROR_TIMED_OUT = -110;

    // 接口方法
    void setDisplay(SurfaceHolder sh);
    void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;
    String getDataSource();
    void prepareAsync() throws IllegalStateException;
    void start() throws IllegalStateException;
    void stop() throws IllegalStateException;
    void pause() throws IllegalStateException;
    void setScreenOnWhilePlaying(boolean screenOn);
    int getVideoWidth();
    int getVideoHeight();
    boolean isPlaying();
    void seekTo(long msec) throws IllegalStateException;
    long getCurrentPosition();
    long getDuration();
    void release();
    void reset();
    void setVolume(float leftVolume, float rightVolume);
    int getAudioSessionId();
    void setAudioStreamType(int streamtype);
    void setLooping(boolean looping);
    boolean isLooping();
    
    // 监听器接口
    interface OnPreparedListener {
        void onPrepared(IMediaPlayer mp);
    }
    
    interface OnCompletionListener {
        void onCompletion(IMediaPlayer mp);
    }
    
    interface OnBufferingUpdateListener {
        void onBufferingUpdate(IMediaPlayer mp, int percent);
    }
    
    interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayer mp);
    }
    
    interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sar_num, int sar_den);
    }
    
    interface OnErrorListener {
        boolean onError(IMediaPlayer mp, int what, int extra);
    }
    
    interface OnInfoListener {
        boolean onInfo(IMediaPlayer mp, int what, int extra);
    }
    
    interface OnTimedTextListener {
        void onTimedText(IMediaPlayer mp, IjkTimedText text);
    }
    
    void setOnPreparedListener(OnPreparedListener listener);
    void setOnCompletionListener(OnCompletionListener listener);
    void setOnBufferingUpdateListener(OnBufferingUpdateListener listener);
    void setOnSeekCompleteListener(OnSeekCompleteListener listener);
    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener);
    void setOnErrorListener(OnErrorListener listener);
    void setOnInfoListener(OnInfoListener listener);
    void setOnTimedTextListener(OnTimedTextListener listener);
    void setSurface(Surface surface);
}
