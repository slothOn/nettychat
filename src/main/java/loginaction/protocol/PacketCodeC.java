package loginaction.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import loginaction.protocol.request.LoginRequestPacket;
import loginaction.protocol.request.MessageRequestPacket;
import loginaction.protocol.response.LoginResponsePacket;
import loginaction.protocol.response.MessageResponsePacket;
import loginaction.serialize.Serializer;
import loginaction.serialize.SerializerAlgorithm;
import loginaction.serialize.impl.JSONSerializer;

import java.util.*;

public class PacketCodeC {
    public static final int MAGIC_NUMBER = 0x12345678;
    public static final PacketCodeC INSTANCE = new PacketCodeC();

    private final Map<Command, Class<? extends Packet>> packetTypeMap;
    private final Map<SerializerAlgorithm, Serializer> serializerMap;

    private PacketCodeC() {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(Command.MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(Command.MESSAGE_RESPONSE, MessageResponsePacket.class);

        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }

    public void encode(ByteBuf byteBuf, Packet packet) {
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.version);
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm().getIndex());
        byteBuf.writeByte(packet.getCommand().getIndex());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    public Packet decode(ByteBuf byteBuf) {
        // skip the MAGIC_NUMBER
        byteBuf.skipBytes(4);
        // skip the version number
        byteBuf.skipBytes(1);

        SerializerAlgorithm serializerAlgorithm = SerializerAlgorithm.fromIndex(byteBuf.readByte());

        Command cmd = Command.fromIndex(byteBuf.readByte());

        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(cmd);
        Serializer serializer = getSerializer(serializerAlgorithm);

        return serializer.deserialize(requestType, bytes);
    }

    private Serializer getSerializer(SerializerAlgorithm algorithm) {
        return serializerMap.get(algorithm);
    }

    private Class<? extends Packet> getRequestType(Command command) {
        return packetTypeMap.get(command);
    }
}
