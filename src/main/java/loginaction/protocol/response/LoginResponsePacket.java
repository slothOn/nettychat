package loginaction.protocol.response;

import loginaction.protocol.Command;
import loginaction.protocol.Packet;

public class LoginResponsePacket extends Packet {

    public boolean success;
    public String reason;

    @Override
    public Command getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
