import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello, " + args[0]);
            double x = (new Scanner(System.in)).nextDouble();
            double y = (new Scanner(System.in)).nextDouble();
            double x1 = 3 * Math.pow((Math.cos(x - (Math.PI / 6.0))), 2);
            double y1 = 0.5 * Math.sin(y * y);
            System.out.println(x1 / y1);
        } else
            System.out.println("There is no arguments!");
    }
}
