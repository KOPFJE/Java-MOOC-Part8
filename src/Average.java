import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        System.out.println("Average calculation. Add positive numbers. When done, type '0'");
        double sum = 0;
        double avg;
        int n;
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        while (true) {
            String str = scanner.next();
            try {
                n = Integer.parseInt(str);
                if (n == 0) break;
                if (n < 0) continue;
                numbers.add(n);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        scanner.close();
        if (numbers.toArray().length == 0) System.out.println("Cannot calculate the average!");
        else {
            for (Integer num : numbers) {
                sum += num;
            }
            avg = sum / numbers.toArray().length;
            System.out.print(avg);
        }
    }
}
