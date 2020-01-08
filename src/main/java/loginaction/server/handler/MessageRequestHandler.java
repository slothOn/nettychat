package loginaction.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import loginaction.protocol.request.MessageRequestPacket;
import loginaction.protocol.response.MessageResponsePacket;

import java.util.Date;

public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        System.out.println(new Date() + " received client sent message: " + messageRequestPacket.message);
        messageResponsePacket.message = "server is sending【" + messageRequestPacket.message + "】";
        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
