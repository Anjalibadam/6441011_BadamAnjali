/ Define the interface
interface Playable {
    void play();
}

// Implement Playable in Guitar class
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the guitar");
    }
}

// Implement Playable in Piano class
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing the piano");
    }
}

public class Main {
    public static void main(String[] args) {
        // Instantiate Guitar and Piano objects
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        // Call the play method
        guitar.play();  // Output: Playing the guitar
        piano.play();   // Output: Playing the piano
    }
}
