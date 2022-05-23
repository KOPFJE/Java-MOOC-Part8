import java.util.Scanner;
import static java.lang.Integer.parseInt;

class Container {
    private final String name;
    private final int maxValue;
    private int value = 0;

    public Container(String name, int maxValue) {
        this.name = name;
        this.maxValue = maxValue;
    }

    public boolean add(int n) {
        if(this.value + n > maxValue || n < 0) return false;
        this.value += n;
        return true;
    }

    public boolean remove(int n) {
        if(value-n < 0 || n < 0) return false;
        this.value -= n;
        return true;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.value + "/" + this.maxValue;
    }
}

public class LiquidContainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first  = new Container("First", 100);
        Container second = new Container("Second", 100);
        String input;
        String cmd;
        int amount;
        while(true) {
            System.out.println(first);
            System.out.println(second);
            input = scan.nextLine();
            if(input.toLowerCase().equals("quit")) break;
            String[] inputs = input.split(" ");
            cmd = inputs[0];
            amount = parseInt(inputs[1]);
            try {
                switch (cmd.toLowerCase()) {
                    case "add" -> {
                        if (first.add(amount)) break;
                        System.out.println("Can't add to 1st container!");
                    }
                    case "move" -> {
                        if (first.remove(amount)) {
                            second.add(amount);
                            break;
                        }
                        System.out.println("Can't move from 1st container to 2nd container.");
                    }
                    case "remove" -> {
                        if (second.remove(amount)) break;
                        System.out.println("Can't remove from 2nd container!");
                    }
                    default -> System.out.println("Command not recognized.");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
                break;
            }
        }
        scan.close();
    }
}