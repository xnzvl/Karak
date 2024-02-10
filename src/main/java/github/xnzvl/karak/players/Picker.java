package github.xnzvl.karak.players;

public abstract class Picker {
    public enum Type {

    }

    public abstract <T> T pick(Picker.Type type, T... options);
}
