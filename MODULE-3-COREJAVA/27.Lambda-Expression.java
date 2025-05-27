import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        // Adding sample strings
        names.add("Alice");
        names.add("John");
        names.add("Bob");
        names.add("Diana");

        // Sorting using lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        // Displaying sorted list
        System.out.println("Sorted List:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
