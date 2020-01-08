package loginaction.serialize;

public enum SerializerAlgorithm {
    JSON((byte)0);

    private byte index;

    SerializerAlgorithm(byte index) {
        this.index = index;
    }

    public byte getIndex() {
        return index;
    }

    public static SerializerAlgorithm fromIndex(byte idx) {
        if (idx == 0) return SerializerAlgorithm.JSON;
        return null;
    }
}
