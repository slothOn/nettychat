package loginaction.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import loginaction.protocol.request.LoginRequestPacket;
import loginaction.protocol.response.LoginResponsePacket;

import java.util.Date;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        System.out.println(new Date() + ": Client starts to login in.");

        LoginResponsePacket responsePacket = new LoginResponsePacket();
        responsePacket.version = loginRequestPacket.version;
        if (valid(loginRequestPacket)) {
            responsePacket.success = true;
            System.out.println("Client has logged in.");
        } else {
            System.out.println("Client failed to log in");
            responsePacket.reason = "Unknown";
        }

        ctx.channel().writeAndFlush(responsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
