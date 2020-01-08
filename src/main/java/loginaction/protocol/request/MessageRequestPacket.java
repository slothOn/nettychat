package loginaction.protocol.request;

import loginaction.protocol.Command;
import loginaction.protocol.Packet;

public class MessageRequestPacket extends Packet {
    public String message;

    @Override
    public Command getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
