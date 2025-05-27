public class Example {
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        Example ex = new Example();
        ex.greet("World");
    }
}
