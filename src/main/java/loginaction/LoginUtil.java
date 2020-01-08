package loginaction;


import io.netty.channel.Channel;
import loginaction.attribute.Attributes;

public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Boolean flag = channel.attr(Attributes.LOGIN).get();
        return flag != null && flag;
    }

    public static void main(String[] args) {
        Boolean a = null;
        boolean b = a;
        System.out.println(b + ": " + (b == true));
    }
}
