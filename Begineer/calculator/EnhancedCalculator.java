import java.util.Scanner;

public class EnhancedCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Enhanced Console Calculator ====");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: basicArithmetic(); break;
                case 2: scientificCalc(); break;
                case 3: unitConversions(); break;
                case 0: System.out.println("Exiting Calculator. Goodbye!"); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
    }

    // 1. Basic Arithmetic
    public static void basicArithmetic() {
        System.out.println("\n--- Basic Arithmetic ---");
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        System.out.println("Choose operation: + - * /");
        char op = scanner.next().charAt(0);

        double result = 0;
        switch (op) {
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/':
                if (b != 0) result = a / b;
                else {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                break;
            default: System.out.println("Invalid operator."); return;
        }
        System.out.println("Result: " + result);
    }

    // 2. Scientific Calculations
    public static void scientificCalc() {
        System.out.println("\n--- Scientific Calculations ---");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation (a^b)");
        System.out.print("Enter your choice: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Enter a number: ");
                double num = scanner.nextDouble();
                if (num < 0) {
                    System.out.println("Error: Cannot calculate square root of negative number.");
                } else {
                    System.out.println("Square Root: " + Math.sqrt(num));
                }
                break;
            case 2:
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = scanner.nextDouble();
                System.out.println("Result: " + Math.pow(base, exp));
                break;
            default:
                System.out.println("Invalid scientific option.");
        }
    }

    // 3. Unit Conversions
    public static void unitConversions() {
        System.out.println("\n--- Unit Conversions ---");
        System.out.println("1. Temperature (C ↔ F)");
        System.out.println("2. Currency (INR ↔ USD)");
        System.out.print("Enter your choice: ");
        int opt = scanner.nextInt();

        switch (opt) {
            case 1:
                temperatureConversion();
                break;
            case 2:
                currencyConversion();
                break;
            default:
                System.out.println("Invalid conversion option.");
        }
    }

    // Temperature Conversion
    public static void temperatureConversion() {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose option: ");
        int ch = scanner.nextInt();
        if (ch == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double c = scanner.nextDouble();
            double f = (c * 9/5) + 32;
            System.out.println("Fahrenheit: " + f);
        } else if (ch == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = scanner.nextDouble();
            double c = (f - 32) * 5/9;
            System.out.println("Celsius: " + c);
        } else {
            System.out.println("Invalid temperature option.");
        }
    }

    // Currency Conversion (Fixed Rate)
    public static void currencyConversion() {
        final double USD_RATE = 83.0; // Example rate: 1 USD = 83 INR
        System.out.println("1. INR to USD");
        System.out.println("2. USD to INR");
        System.out.print("Choose option: ");
        int ch = scanner.nextInt();
        if (ch == 1) {
            System.out.print("Enter amount in INR: ");
            double inr = scanner.nextDouble();
            System.out.println("USD: " + (inr / USD_RATE));
        } else if (ch == 2) {
            System.out.print("Enter amount in USD: ");
            double usd = scanner.nextDouble();
            System.out.println("INR: " + (usd * USD_RATE));
        } else {
            System.out.println("Invalid currency option.");
        }
    }
}
