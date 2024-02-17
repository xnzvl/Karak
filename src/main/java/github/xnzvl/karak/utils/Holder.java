package github.xnzvl.karak.utils;

public final class Holder<T> {
    private T instance;

    public void setInstance (
            T instance
    ) {
        this.instance = instance;
    }

    public T getInstance() {
        return this.instance;
    }
}
