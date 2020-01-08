package loginaction.protocol.response;

import loginaction.protocol.Command;
import loginaction.protocol.Packet;

public class MessageResponsePacket extends Packet {

    public String message;

    @Override
    public Command getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
