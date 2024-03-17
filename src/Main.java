import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");
        System.out.println("Enter the amount you want to convert:");
        double amount = scanner.nextDouble();

        System.out.println("Choose your base currency (USD, EUR, GBP):");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.println("Choose the target currency (USD, EUR, GBP):");
        String targetCurrency = scanner.next().toUpperCase();

        double result = convertCurrency(amount, baseCurrency, targetCurrency);
        if (result != -1) {
            System.out.println(amount + " " + baseCurrency + " is equal to " + result + " " + targetCurrency);
        } else {
            System.out.println("Invalid currency input.");
        }

        scanner.close();
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // Exchange rates (example rates)
        double usdToEurRate = 0.85;
        double usdToGbpRate = 0.73;
        double eurToUsdRate = 1.18;
        double eurToGbpRate = 0.86;
        double gbpToUsdRate = 1.38;
        double gbpToEurRate = 1.16;

        double result = -1; // Default value for invalid conversion

        // Convert to base currency (USD)
        switch (fromCurrency) {
            case "USD":
                result = amount;
                break;
            case "EUR":
                result = amount * eurToUsdRate;
                break;
            case "GBP":
                result = amount * gbpToUsdRate;
                break;
        }

        // Convert to target currency
        switch (toCurrency) {
            case "USD":
                break;
            case "EUR":
                result /= usdToEurRate;
                break;
            case "GBP":
                result /= usdToGbpRate;
                break;
        }

        return result;
    }
}
