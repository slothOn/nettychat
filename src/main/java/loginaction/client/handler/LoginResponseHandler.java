package loginaction.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import loginaction.LoginUtil;
import loginaction.protocol.request.LoginRequestPacket;
import loginaction.protocol.response.LoginResponsePacket;

import java.util.Date;
import java.util.UUID;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + ": Client starts to login.");

        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.userId = UUID.randomUUID().toString();
        loginRequestPacket.username = "flash";
        loginRequestPacket.password = "pwd";

        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket response) throws Exception {
        if (response.success) {
            System.out.println(new Date() + ": Client now logged in.");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            System.err.println(new Date() + ": Login failed because " + response.reason);
        }
    }
}
