package wenjalan.io;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;

// writes input using the Java NIO API
public class FastWriter {

    // the default buffer size
    private static final int DEFAULT_BUFFER_SIZE = 1024;

    // the channel to read into
    private Channel channel;

    // the buffer to read into
    private ByteBuffer byteBuffer;

}
