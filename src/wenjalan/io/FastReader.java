package wenjalan.io;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class FastReader implements Closeable {

    // the default buffer size
    private static final int DEFAULT_BUFFER_SIZE = 1024;

    // the channel to read
    private Channel channel;

    // the bytebuffer to read into
    private ByteBuffer buffer;

    // the array of bytes read from the channel
    private byte[] data;

    // the next index to return
    private int nextIndex;

    // whether this FastReader is closed
    private boolean isClosed;

    // main constructor
    public FastReader(Channel channel, int bufferSize) {
        this.channel = channel;
        this.buffer = ByteBuffer.allocate(bufferSize);
        this.nextIndex = 0;
        this.isClosed = false;
        read();
    }

    public FastReader(Channel channel) {
        this(channel, DEFAULT_BUFFER_SIZE);
    }

    // reads the data from the channel
    private void read() {
        // find out what kind of channel we have
        if (channel instanceof FileChannel) {
            data = readFromFileChannel((FileChannel) channel);
        }
        else {
            throw new UnsupportedOperationException("Unsupported channel type " + channel.getClass());
        }
    }

    // reads the data from a FileChannel
    private byte[] readFromFileChannel(FileChannel channel) {
        // ArrayList to store the bytes
        ArrayList<Byte> bytes = new ArrayList<>();
        // read into the array
        try {
            // read the bytes
            while (channel.read(buffer) != -1) {
                buffer.flip();
                byte[] array = buffer.array();
                for (byte b : array) {
                    bytes.add(b);
                }
                buffer.clear();
            }
            // close the channel
            channel.close();
            // return byte array
            byte[] ret = new byte[bytes.size()];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = bytes.get(i);
            }
            return ret;
        } catch (IOException e) {
            // if an error is encountered
            System.err.println("Error while reading from data source!");
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    // returns the next byte of the data
    public byte next() throws IOException {
        if (this.isClosed) {
            throw new IllegalStateException("FastWriter is closed");
        }
        if (data == null) {
            throw new IllegalStateException("Data hasn't been read in");
        }
        if (nextIndex >= data.length) {
            throw new IOException("Reached end of data");
        }
        // return the next byte of data
        byte b = data[nextIndex];
        nextIndex++;
        return b;
    }

    // returns whether we've reached the end of the data
    public boolean hasNext() {
        if (this.isClosed) {
            throw new IllegalStateException("FastWriter is closed");
        }
        return nextIndex < data.length;
    }

    @Override
    public void close() throws IOException {
        channel.close();
        this.isClosed = true;
    }
}
