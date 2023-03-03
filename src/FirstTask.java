import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello, " + args[0]);
        } else
            System.out.println("There is no arguments!");
    }
}


class Server {
    public static void main(String[] args) {
        String[] a = new String[]{"Вася"};
        FirstTask.main(a);

        final int server_port = 34522;
        System.out.println("Сервер запущен!");

        try (ServerSocket server = new ServerSocket(server_port)) {
            while (true) {
                try (
                        Socket socket = server.accept(); // accept a new client
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    double x = Double.parseDouble(input.readUTF()); // read a message from the client
                    double y = Double.parseDouble(input.readUTF());

                    double x1 = 3 * Math.pow((Math.cos(x - (Math.PI / 6.0))), 2);
                    double y1 = 0.5 + Math.sin(y * y);
                    double res = x1 / y1;

                    output.writeUTF(String.valueOf(res)); // resend it to the client
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
            Scanner read = new Scanner(System.in);
            System.out.print("Введите x: "); String x = read.nextLine();
            System.out.print("Введите y: "); String y = read.nextLine();

            output.writeUTF(x); // send a message to the server
            output.writeUTF(y);

            String receivedMsg = input.readUTF(); // read the reply from the server

            System.out.println("Ответ от сервера: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
