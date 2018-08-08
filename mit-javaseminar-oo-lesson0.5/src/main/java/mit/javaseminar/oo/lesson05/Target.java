package mit.javaseminar.oo.lesson05;

public class Target {
    public int add(int a, int b) {
        return a + b;
    }
    public void throwException() {
        throw new RuntimeException("例外が発生しました");
    }
}