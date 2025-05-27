ChatServer.java

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 12345;  // server port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // For reading server console input
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Thread to read messages from client
            Thread clientReader = new Thread(() -> {
                try {
                    String fromClient;
                    while ((fromClient = in.readLine()) != null) {
                        System.out.println("Client: " + fromClient);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed by client.");
                }
            });
            clientReader.start();

            // Main thread: read from console and send to client
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
ChatClient.java

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Thread to read messages from server
            Thread serverReader = new Thread(() -> {
                try {
                    String fromServer;
                    while ((fromServer = in.readLine()) != null) {
                        System.out.println("Server: " + fromServer);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed by server.");
                }
            });
            serverReader.start();

            // Main thread: read from console and send to server
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
