package loginaction.serialize;

import loginaction.serialize.impl.JSONSerializer;

public interface Serializer {
    Serializer DEFAULT = new JSONSerializer();

    SerializerAlgorithm getSerializerAlgorithm(

    );

    byte[] serialize(Object obj);

    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
