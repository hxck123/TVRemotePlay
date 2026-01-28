package player.widget.media;

import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileMediaDataSource implements IMediaDataSource {
    private FileInputStream mFileInputStream;
    private File mFile;

    public FileMediaDataSource(File file) throws IOException {
        mFile = file;
        mFileInputStream = new FileInputStream(file);
    }

    @Override
    public int readAt(long position, byte[] buffer, int offset, int size) throws IOException {
        if (position >= mFile.length()) {
            return -1;
        }
        
        mFileInputStream.getChannel().position(position);
        return mFileInputStream.read(buffer, offset, size);
    }

    @Override
    public long getSize() throws IOException {
        return mFile.length();
    }

    @Override
    public void close() throws IOException {
        if (mFileInputStream != null) {
            mFileInputStream.close();
            mFileInputStream = null;
        }
    }
}
