package bbum.connections.channelHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientTCPChannelHandler extends SimpleChannelInboundHandler<String> {

	/**
	 * print the result of the calculation that came back from the server
	 */
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println("answer: " + msg);
	}

}

