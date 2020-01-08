package loginaction.protocol;

public enum Command {
    LOGIN_REQUEST ((byte)0),
    LOGIN_RESPONSE ((byte)1),
    MESSAGE_REQUEST ((byte)2),
    MESSAGE_RESPONSE ((byte)3);

    private byte index;

    Command(byte index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static Command fromIndex(byte idx) {
        if (idx == 0) {
            return LOGIN_REQUEST;
        } else if (idx == 1) {
            return LOGIN_RESPONSE;
        } else if (idx == 2) {
            return MESSAGE_REQUEST;
        } else if (idx == 3) {
            return MESSAGE_RESPONSE;
        } else {
            return null;
        }
    }
}

