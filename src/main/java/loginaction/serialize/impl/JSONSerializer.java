package loginaction.serialize.impl;

import com.alibaba.fastjson.JSON;
import loginaction.serialize.Serializer;
import loginaction.serialize.SerializerAlgorithm;

public class JSONSerializer implements Serializer {


    @Override
    public SerializerAlgorithm getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object obj) {
        return JSON.toJSONBytes(obj);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
