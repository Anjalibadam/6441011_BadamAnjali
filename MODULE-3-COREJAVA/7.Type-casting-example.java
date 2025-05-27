public class TypeCastingExample {
    public static void main(String[] args) {
        // Declare a double variable
        double myDouble = 9.78;
        
        // Cast double to int (explicit casting)
        int myInt = (int) myDouble;
        
        // Display the result of casting double to int
        System.out.println("Original double value: " + myDouble);
        System.out.println("After casting to int: " + myInt);
        
        // Declare an int variable
        int anotherInt = 15;
        
        // Cast int to double (implicit casting)
        double anotherDouble = anotherInt;
        
        // Display the result of casting int to double
        System.out.println("Original int value: " + anotherInt);
        System.out.println("After casting to double: " + anotherDouble);
    }
}