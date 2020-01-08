package loginaction.protocol;

public abstract class Packet {
    public Byte version = 1;

    public abstract Command getCommand();
}
