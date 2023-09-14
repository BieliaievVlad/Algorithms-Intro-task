package app;

import java.util.Scanner;
import java.util.Locale;

public class Main {

    static String CURRENCY = "UAH";
    static String[] days = new String[]{"Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"};
    static double[] price = new double[days.length];
    static double averagePrice;
    static Scanner sc;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        //Ввод данных
        System.out.printf("Enter the price value, %s:%n", CURRENCY);
        for (int i = 0; i < price.length; i++){
            System.out.printf("%s: ", days[i]);
            price[i] = sc.nextDouble();
        }
        sc.close();

        //Сортировка по возрастанию
        for (int i = 0; i < price.length; i++) {
            for (int j = 1; j < (price.length - i); j++) {
                if (price[j - 1] > price[j]) {
                    double temp = price[j - 1];
                    price[j - 1] = price[j];
                    price[j] = temp;
                }
            }
        }

        //Расчет среднего значения
        for (double priceValue : price){
            averagePrice += priceValue / price.length;
        }

        //Вывод результатов
        System.out.print("-----------------------");
        System.out.printf("%nSorted price values, %s:", CURRENCY);
        for (double v : price) System.out.printf("%n%.2f", v);
        System.out.printf("%n-----------------------");
        System.out.printf("%nAverage price for %d days is, %s: %.2f", days.length,
                CURRENCY, averagePrice);
    }

}
