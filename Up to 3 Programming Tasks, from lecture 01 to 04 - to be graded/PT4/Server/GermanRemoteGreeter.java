package Server;

import Interfaces.IRemoteGreeter;

public class GermanRemoteGreeter implements IRemoteGreeter {
    @Override
    public String hello(String name) {
        return "Hallo, " + name;
    }

    @Override
    public String goodbye(String name) {
        return "Auf Wiedersehen, " + name;
    }
}
