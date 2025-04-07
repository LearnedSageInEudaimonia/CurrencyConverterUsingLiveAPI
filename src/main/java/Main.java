import org.json.JSONObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        while(true) {
            System.out.println("\n←←← Currency Converter →→→");
            System.out.println("\nSupports All Currency Except North Korea");
            System.out.print("Enter Base Currency : ");
            String base = read.nextLine().toUpperCase();

            System.out.print("Enter the Currency Required : ");
            String target = read.nextLine().toUpperCase();

            System.out.println("Enter Amount : ");
            double amount = read.nextDouble();

            try {
                String jsonResponse = ApiHandler.getRates(base);
                JSONObject obj = new JSONObject(jsonResponse);
                double rate = obj.getJSONObject("rates").getDouble(target);
                double convertedAmount = amount * rate;


                System.out.printf("%.2f %s = %.2f %s%n", amount, base, convertedAmount, target);

                String record = STR."\{base}, \{target}, \{amount}, \{convertedAmount}";

                HistoryManager.saveHistory(record);

                System.out.println("\nShow conversion history? (Y/N)");
                read.nextLine();

                String choice = read.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    HistoryManager.displayHistory();
                }
            } catch (Exception e) {
                System.out.println(STR."Error occurred : \{e.getMessage()}");
            }

            System.out.print("\nExit (Y/N) : ");
            if(read.nextLine().equalsIgnoreCase("Y")){
                break;
            }
        }
    }
}
