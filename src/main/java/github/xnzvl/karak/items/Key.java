package github.xnzvl.karak.items;

public class Key implements Item {
    public Key() {
        // that's all
    }

    @Override
    public String getTitle() {
        return "Key";
    }

    @Override
    public String getDetails() {
        return "It's used to open locked chests";
    }
}
