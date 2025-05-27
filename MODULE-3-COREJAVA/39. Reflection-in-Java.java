import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        // Dynamically load the class by name
        Class<?> clazz = Class.forName("SampleClass");

        // Print all declared methods and their parameters
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods in " + clazz.getName() + ":");
        for (Method method : methods) {
            System.out.print(" - " + method.getName() + "(");
            Parameter[] params = method.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getType().getSimpleName() + " " + params[i].getName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        // Create an instance of SampleClass
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // Find the method named "sayHello" that takes a String parameter
        Method sayHelloMethod = clazz.getDeclaredMethod("sayHello", String.class);

        // Invoke the method dynamically
        sayHelloMethod.invoke(instance, "Reflection");
    }
}
public class SampleClass {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public int add(int a, int b) {
        return a + b;
    }
}
