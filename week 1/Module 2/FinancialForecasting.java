import java.util.Scanner;
import java.text.DecimalFormat;

public class FinancialForecasting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("===== Financial Forecasting =====");
        System.out.print("Enter Initial Revenue (in ₹): ");
        double initialRevenue = scanner.nextDouble();

        System.out.print("Enter Annual Growth Rate (in %, e.g., 10): ");
        double growthRate = scanner.nextDouble() / 100.0;

        System.out.print("Enter Profit Margin (in %, e.g., 20): ");
        double profitMargin = scanner.nextDouble() / 100.0;

        System.out.print("Enter Forecast Duration (in years): ");
        int years = scanner.nextInt();

        System.out.println("\nYear\tProjected Revenue (₹)\tProjected Profit (₹)");

        double totalRevenue = 0, totalProfit = 0;

        for (int i = 1; i <= years; i++) {
            double revenue = initialRevenue * Math.pow((1 + growthRate), i);
            double profit = revenue * profitMargin;

            totalRevenue += revenue;
            totalProfit += profit;

            System.out.println(i + "\t" + df.format(revenue) + "\t\t" + df.format(profit));
        }

        System.out.println("\n===== Forecast Summary =====");
        System.out.println("Total Projected Revenue over " + years + " years: ₹" + df.format(totalRevenue));
        System.out.println("Total Projected Profit over " + years + " years: ₹" + df.format(totalProfit));
        System.out.println("Average Annual Profit: ₹" + df.format(totalProfit / years));

        scanner.close();
    }
}
