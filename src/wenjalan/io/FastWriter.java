package wenjalan.io;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

// writes input using the Java NIO API
public class FastWriter implements Closeable {

    // the default buffer size
    private static final int DEFAULT_BUFFER_SIZE = 1024;

    // the channel to read into
    private Channel channel;

    // the buffer to read into
    private ByteBuffer byteBuffer;

    // the amount of bytes written
    private int bytesWritten;

    // if this writer is closed
    private boolean isClosed;

    // constructor
    public FastWriter(Channel channel, int bufferSize) {
        this.channel = channel;
        this.byteBuffer = ByteBuffer.allocate(bufferSize);
        this.bytesWritten = 0;
        this.isClosed = false;
    }

    public FastWriter(Channel channel) {
        this(channel, DEFAULT_BUFFER_SIZE);
    }

    // writes a character
    public void write(char c) throws IOException {
        if (this.isClosed) {
            throw new IllegalStateException("FastWriter is closed");
        }
        if (bytesWritten == byteBuffer.limit()) {
            flush();
        }
        byteBuffer.put((byte) c);
        bytesWritten++;
    }

    // writes a String
    public void write(String s) throws IOException {
        for (char c : s.toCharArray()) {
            write(c);
        }
    }

    // flushes the buffer into the channel
    public void flush() throws IOException {
        if (this.isClosed) {
            throw new IllegalStateException("FastWriter is closed");
        }
        byteBuffer.flip();
        // FileChannel
        if (channel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) channel;
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }
        }
        else {
            throw new UnsupportedOperationException("Unsupported channel type: " + channel.getClass());
        }
        byteBuffer.clear();
        bytesWritten = 0;
    }

    // returns if this writer is closed
    public boolean isClosed() {
        return this.isClosed;
    }

    // closes the writer
    @Override
    public void close() throws IOException {
        flush();
        channel.close();
        this.isClosed = true;
    }
}
