package bbum.connections.bootstrap;

import java.net.InetSocketAddress;
import java.util.Scanner;

import bbum.connections.initializer.ClientTCPChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Bootstrap for Calculator  client 
 * @author shaharb
 *
 */
public class NettyClientBootstrap {

	public void start(String host, int port) throws InterruptedException {
		System.out.println("Starting client at: " + host + ":" + port);
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap clientBootstrap = new Bootstrap();

			clientBootstrap.group(group);
			clientBootstrap.channel(NioSocketChannel.class);
			clientBootstrap.remoteAddress(new InetSocketAddress(host, port));
			clientBootstrap.handler(new ClientTCPChannelInitializer());
			ChannelFuture channelFuture = clientBootstrap.connect().sync();
			if (channelFuture.isSuccess()) {
				System.out.println("Client started successfully");
			}
			handleUserInteraction(channelFuture);
			channelFuture.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}

	/**
	 * handle the interaction with the user 
	 * getting the user input and send it to the server
	 * 
	 * @param channelFuture - the channel to the server
	 */
	@SuppressWarnings("resource")
	private void handleUserInteraction(ChannelFuture channelFuture) {
		System.out.println("enter expression or type xxx  for exit ");
		Scanner input = new Scanner(System.in);
		String exp = "";
		while (true) {
			exp = input.nextLine();
			if (exp.equals("xxx")) {
				break;
			}
			channelFuture.channel().writeAndFlush(exp);
		}
		System.out.println("client stop");
	}
}
