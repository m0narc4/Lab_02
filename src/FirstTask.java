import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello, " + args[0]);
            String variant = (new Scanner(System.in)).next();
            System.out.println(variant);
            System.out.println("Args: ");
            switch (variant) {
                case "V1":
                    double a = (new Scanner(System.in)).nextDouble();
                    double b = (new Scanner(System.in)).nextDouble();
                    double c = (new Scanner(System.in)).nextDouble();
                    double n = (new Scanner(System.in)).nextDouble();
                    double x = (new Scanner(System.in)).nextDouble();
                    System.out.println((5 * Math.pow(a, n * x)) / (b + c) - Math.sqrt(Math.abs(Math.cos(x * x * x))));
                    break;
                case "V2":
                    a = (new Scanner(System.in)).nextDouble();
                    b = (new Scanner(System.in)).nextDouble();
                    x = (new Scanner(System.in)).nextDouble();
                    double y = (new Scanner(System.in)).nextDouble();
                    System.out.println((Math.abs(x - y)) / (Math.pow(1 + 2 * x, a)) - Math.pow(Math.E, Math.sqrt(1 + b)));
                    break;
                case "V3":
                    a = (new Scanner(System.in)).nextDouble();
                    b = (new Scanner(System.in)).nextDouble();
                    c = (new Scanner(System.in)).nextDouble();
                    x = (new Scanner(System.in)).nextDouble();
                    System.out.println(Math.sqrt(a + b * x + c * Math.pow(Math.abs(Math.sin(x)), 1.0 / 3.0)));
                    break;
                case "V4":
                    a = (new Scanner(System.in)).nextDouble();
                    x = (new Scanner(System.in)).nextDouble();
                    System.out.println(Math.log1p(Math.abs(Math.pow(a,7))) + Math.atan(x * x) + (Math.PI / Math.sqrt(Math.abs(a + x))));
                    break;
                case "V5":
                    a = (new Scanner(System.in)).nextDouble();
                    b = (new Scanner(System.in)).nextDouble();
                    c = (new Scanner(System.in)).nextDouble();
                    double d = (new Scanner(System.in)).nextDouble();
                    x = (new Scanner(System.in)).nextDouble();
                    System.out.println(Math.pow((Math.pow(a + b, 2) / (c + d) + Math.pow(Math.E, Math.sqrt(x + 1))), 1.0 / 5.0));
                    break;
                case "V6":
                    x = (new Scanner(System.in)).nextDouble();
                    System.out.println(Math.pow(Math.E, (2 * Math.sin(4 * x) + Math.pow(Math.cos(x * x), 2) / 3 * x)));
                    break;
                case "V7":
                    x = (new Scanner(System.in)).nextDouble();
                    System.out.println((1.0 / 4.0) * (((1 + x * x) / (1 - x)) + 0.5 * Math.tan(x)));
                    break;
            }
        } else
            System.out.println("There is no arguments!");
    }
}
