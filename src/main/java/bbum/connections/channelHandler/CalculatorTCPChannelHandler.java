package bbum.connections.channelHandler;

import bbum.services.calculator.Calculator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * TCP Channel handler for Server calculator
 * 
 * @author shaharb
 *
 */
public class CalculatorTCPChannelHandler extends SimpleChannelInboundHandler<String> {

	/**
	 * apply the calculator service on the new message, and send the result back in
	 * the channel
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		try {
			System.out.println(ctx.channel().remoteAddress() + " , " + msg);
			Calculator calc = new Calculator(msg);
			ctx.channel().writeAndFlush(calc.apply().toString() + "\n");
		} catch (Exception e) {
			ctx.channel().writeAndFlush(e.getMessage() + "\n");

		}
	}
}
