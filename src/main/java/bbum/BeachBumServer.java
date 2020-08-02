package bbum;

import bbum.connections.bootstrap.NettyServerBootstrap;

/**
 * 
 * Server application for Calculator server 
 * listening on port 8080
 * Upon start, the server opens a listening socket and waits for clients to connect and send a
 * calculation (e.g 4+5). If the calculation is valid, a response is sent (e.g 9). The server can
 * support multiple clients that use it simultaneously.
 * 
 * @author shaharb
 *
 */
public class BeachBumServer {
	public static void main(String[] args)  {
		try {
			NettyServerBootstrap server = new NettyServerBootstrap();
			server.start(8080);
		} catch (Exception e) {
			System.err.println("server failed");
		}
	}
}