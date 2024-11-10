package Server;

import java.nio.charset.StandardCharsets;

public class Marshaller {
    public static byte[] marshal(String data) {
        return data.getBytes(StandardCharsets.UTF_8);
    }

    public static String unmarshal(byte[] data) {
        return new String(data, StandardCharsets.UTF_8);
    }
}
