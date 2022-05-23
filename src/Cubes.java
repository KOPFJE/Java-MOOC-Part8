import java.util.Locale;
import java.util.Scanner;

public class Cubes {
    public static void main(String[] args) {
        System.out.println("Cubic calculation.");

        while(true) {
            String str = askForUser();
            if(str.equalsIgnoreCase("end")) break;
            try {
                int n = Integer.parseInt(str);
                int cube = n * n * n;
                System.out.println(cube);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    public static String askForUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
