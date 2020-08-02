package bbum.connections.initializer;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
/**
 * abstract class for initialize TCP channel
 * @author shaharb
 *
 */
public abstract class TCPChannelInitializer extends ChannelInitializer<SocketChannel> {

	/**
	 * 
	 * @return channel handler to add to the socket channel pipeline
	 */
	protected abstract ChannelHandler getTCPChannelHandler();

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		socketChannel.pipeline().addLast(new StringEncoder());
		socketChannel.pipeline().addLast(new StringDecoder());
		socketChannel.pipeline().addLast(getTCPChannelHandler());
	}

}
