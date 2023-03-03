import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
    }
}

class Server {
    public static void main(String[] args) {
        final int server_port = 34522;
        System.out.println("Сервер запущен!");
        try (ServerSocket server = new ServerSocket(server_port)) {
            while (true) {
                try (
                        Socket socket = server.accept(); // accept a new client
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String msg = input.readUTF(); // read a message from the client
                    System.out.println("К нам пришёл " + msg);
                    output.writeUTF(msg); // resend it to the client
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client {
    public static void main(String[] args) {
        final String server_address = "127.0.0.1";
        final int server_port = 34522;
        try (
                Socket socket = new Socket(server_address, server_port);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Who are you?");
            String msg = scanner.nextLine();

            output.writeUTF(msg); // send a message to the server
            String receivedMsg = input.readUTF(); // read the reply from the server

            System.out.println("Ответ от сервера: Hello, " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
