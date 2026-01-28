package tv.danmaku.ijk.media.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public class TextureMediaPlayer implements IMediaPlayer {
    private IMediaPlayer mInternalMediaPlayer;
    private SurfaceTexture mSurfaceTexture;
    private Surface mSurface;

    public TextureMediaPlayer(IMediaPlayer internalMediaPlayer) {
        mInternalMediaPlayer = internalMediaPlayer;
    }

    public IMediaPlayer getInternalMediaPlayer() {
        return mInternalMediaPlayer;
    }

    @Override
    public void setDisplay(android.view.SurfaceHolder sh) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setDisplay(sh);
    }

    @Override
    public void setDataSource(String path) throws Exception {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setDataSource(path);
    }

    @Override
    public String getDataSource() {
        if (mInternalMediaPlayer != null) return mInternalMediaPlayer.getDataSource();
        return null;
    }

    @Override
    public void prepareAsync() throws IllegalStateException {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.prepareAsync();
    }

    @Override
    public void start() throws IllegalStateException {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.start();
    }

    @Override
    public void stop() throws IllegalStateException {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.stop();
    }

    @Override
    public void pause() throws IllegalStateException {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.pause();
    }

    @Override
    public void setScreenOnWhilePlaying(boolean screenOn) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setScreenOnWhilePlaying(screenOn);
    }

    @Override
    public int getVideoWidth() {
        if (mInternalMediaPlayer != null) return mInternalMediaPlayer.getVideoWidth();
        return 0;
    }

    @Override
    public int getVideoHeight() {
        if (mInternalMediaPlayer != null) return mInternalMediaPlayer.getVideoHeight();
        return 0;
    }

    @Override
    public boolean isPlaying() {
        if (mInternalMediaPlayer != null) return mInternalMediaPlayer.isPlaying();
        return false;
    }

    @Override
    public void seekTo(long msec) throws IllegalStateException {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.seekTo(msec);
    }

    @Override
    public long getCurrentPosition() {
        if (mInternalMediaPlayer != null) return mInternalMediaPlayer.getCurrentPosition();
        return 0;
    }

    @Override
    public long getDuration() {
        if (mInternalMediaPlayer != null) return mInternalMediaPlayer.getDuration();
        return 0;
    }

    @Override
    public void release() {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.release();
        if (mSurface != null) {
            mSurface.release();
            mSurface = null;
        }
    }

    @Override
    public void reset() {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.reset();
    }

    @Override
    public void setVolume(float leftVolume, float rightVolume) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setVolume(leftVolume, rightVolume);
    }

    @Override
    public int getAudioSessionId() {
        if (mInternalMediaPlayer != null) return mInternalMediaPlayer.getAudioSessionId();
        return 0;
    }

    @Override
    public void setAudioStreamType(int streamtype) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setAudioStreamType(streamtype);
    }

    @Override
    public void setLooping(boolean looping) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setLooping(looping);
    }

    @Override
    public boolean isLooping() {
        if (mInternalMediaPlayer != null) return mInternalMediaPlayer.isLooping();
        return false;
    }

    @Override
    public void setOnPreparedListener(OnPreparedListener listener) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setOnPreparedListener(listener);
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setOnCompletionListener(listener);
    }

    @Override
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setOnBufferingUpdateListener(listener);
    }

    @Override
    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setOnSeekCompleteListener(listener);
    }

    @Override
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setOnVideoSizeChangedListener(listener);
    }

    @Override
    public void setOnErrorListener(OnErrorListener listener) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setOnErrorListener(listener);
    }

    @Override
    public void setOnInfoListener(OnInfoListener listener) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setOnInfoListener(listener);
    }

    @Override
    public void setOnTimedTextListener(OnTimedTextListener listener) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setOnTimedTextListener(listener);
    }

    @Override
    public void setSurface(Surface surface) {
        if (mInternalMediaPlayer != null) mInternalMediaPlayer.setSurface(surface);
    }
}
