package zadanie_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Lists {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean temp = true;

        while (temp) {
            System.out.println("Podaj kolejną liczbę dadatnią/ lub ujemną jak chcesz zakończyć program: ");
            int input = scanner.nextInt();
            if (input > 0) {
                Integer num = Integer.parseInt(String.valueOf(input));
                numbers.add(num);
            } else {
                temp = false;
            }
        }

        //wyświetlanie w kolejności odwrotnej niż wprowadzone liczby
        for (int i = numbers.size(); i > 0; i--) {
            System.out.println(numbers.get(i - 1));
        }

        //wyświtlanie największej wprowadzonej liczby
        int max = numbers.get(0);
        for (int i = 0  ; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        System.out.println("Maksymalna liczba: " + max);


        //wyświtlanie najmniejszej wprowadzonej liczby
        int min = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (min > numbers.get(i)) {
                min = numbers.get(i);
            }
        }
        System.out.println("Minimalna liczba: " + min);

        //sumowanie liczb
        int sum = 0;
        for (int n : numbers) {
            sb.append(n);
            sb.append('+');
            sum += n;
        }
        sb.replace(sb.length() - 1, sb.length(), "=");
        sb.append(sum);
        System.out.println(sb.toString());


    }


}
