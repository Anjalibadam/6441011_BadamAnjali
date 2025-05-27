public class PatternMatchingSwitchExample {

    public static void main(String[] args) {
        testType(42);
        testType("Hello");
        testType(3.14);
        testType(true);
        testType(null);
    }

    static void testType(Object obj) {
        String result = switch (obj) {
            case Integer i -> "It's an Integer: " + i;
            case String s -> "It's a String: " + s;
            case Double d -> "It's a Double: " + d;
            case Boolean b -> "It's a Boolean: " + b;
            case null      -> "It's null!";
            default        -> "Unknown type: " + obj;
        };

        System.out.println(result);
    }
}