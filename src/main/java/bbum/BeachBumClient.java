package bbum;

import bbum.connections.bootstrap.NettyClientBootstrap;

/**
 * Client application for calculator
 * Open socket on port localhost:8080
 * Users can write the calculation which is sent to the server when hitting enter
 *  Upon getting the response, prints the calculation response.
 * 
 * @author shaharb
 *
 */
public class BeachBumClient {
	public static void main(String[] args)  {
		try {
	    	NettyClientBootstrap client = new NettyClientBootstrap();
				client.start("localhost", 8080);
			} catch (Exception e) {
				System.err.println("client failed");
			}
	}
}