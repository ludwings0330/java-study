package innerclass;

public class Outer {
    class InstanceInner {}
    static class StaticInner {}

    void MyMethod() {
        class LocalInner {}
    }
}
