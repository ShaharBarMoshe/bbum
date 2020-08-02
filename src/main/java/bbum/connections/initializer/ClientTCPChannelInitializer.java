package bbum.connections.initializer;

import bbum.connections.channelHandler.ClientTCPChannelHandler;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * class for initialize calculator client TCP channel

 * @author shaharb
 *
 */
public class ClientTCPChannelInitializer extends TCPChannelInitializer {

	protected SimpleChannelInboundHandler<String> getTCPChannelHandler() {
		return new ClientTCPChannelHandler();
	}
}
