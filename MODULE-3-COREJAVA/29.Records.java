import java.util.List;
import java.util.stream.Collectors;

// Define the record
record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {
        // Create a list of Person records
        List<Person> people = List.of(
            new Person("Alice", 22),
            new Person("Bob", 17),
            new Person("Charlie", 25),
            new Person("Diana", 16)
        );

        // Print all people
        System.out.println("All People:");
        people.forEach(System.out::println);

        // Filter people aged 18 and above
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());

        // Print filtered list
        System.out.println("\nPeople aged 18 and above:");
        adults.forEach(System.out::println);
    }
}