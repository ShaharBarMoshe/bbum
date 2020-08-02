package bbum.connections.initializer;

import bbum.connections.channelHandler.CalculatorTCPChannelHandler;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * class for initialize calculator server TCP channel

 * @author shaharb
 *
 */
public class CalculatorTCPChannelInitializer extends TCPChannelInitializer {

	protected SimpleChannelInboundHandler<String> getTCPChannelHandler() {
		return new CalculatorTCPChannelHandler();
	}
}
