class Msg {
    public Msg() {
    }
    public Msg(String str) {
        System.out.println("Hello" + str);
    }
    public void sayGoodbye() {
        System.out.println("Goodbye");
    }
}
class TestMsg extends Msg {
    public TestMsg(String str) {
        System.out.println("Hello" + str);
    }
    public void sayGoodbye() {
        System.out.println("Goodbye Java");
    }
}
public class Test {
    public static void main(String args[]) {
        Msg m1 = new Msg("Mark");
        Msg m2 = new TestMsg("Java");
        m1.sayGoodbye();
        m2.sayGoodbye();
    }
}
