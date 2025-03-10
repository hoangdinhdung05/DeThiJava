class Msg {
    public Msg() {
        System.out.println("Hello");
    }
    public void sayGoodbye() {
        System.out.println("Goodbye");
    }
}
class TestMsg extends Msg {
    public TestMsg() {
        super(); 
        System.out.println("Hello Java");
    }
    public void sayGoodbye() {
        System.out.println("Goodbye Java");
    }
}


public class Test {
    public static void main(String[] args) {
        
        Msg m1 = new Msg(); //khởi tạo in ra hello
        Msg m2 = new TestMsg(); //kết thừa lại hello và in ra hello cùng với hello java
        m1.sayGoodbye();
        m2.sayGoodbye();

    }

}