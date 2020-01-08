package loginaction.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import loginaction.protocol.response.MessageResponsePacket;

public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket responsePacket) throws Exception {
        System.out.println("message response from server: " + responsePacket.message);
    }
}
