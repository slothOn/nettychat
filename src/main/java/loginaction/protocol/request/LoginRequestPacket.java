package loginaction.protocol.request;

import loginaction.protocol.Command;
import loginaction.protocol.Packet;

public class LoginRequestPacket extends Packet {
    public String userId;
    public String username;
    public String password;

    @Override
    public Command getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
