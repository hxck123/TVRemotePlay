package tv.danmaku.ijk.media.player;

import android.graphics.Rect;

public class IjkTimedText {
    private Rect mTextBounds;
    private String mTextChars;

    public IjkTimedText(Rect bounds, String text) {
        mTextBounds = bounds;
        mTextChars = text;
    }

    public Rect getBounds() {
        return mTextBounds;
    }

    public String getText() {
        return mTextChars;
    }
}
