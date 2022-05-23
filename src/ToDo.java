import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserInterface {
    private final TodoList list;
    private final Scanner scanner;

    public UserInterface(TodoList l, Scanner s) {
        this.list = l;
        this.scanner = s;
    }

    public void start() {
        String input;
        System.out.println("Type help for help on commands.");
        MainLoop: while(true) {
            System.out.print("Command: ");
            input = scanner.next();
            switch(input.toLowerCase()) {
                case "help":
                    System.out.print(
                            """
                                    help - displays commands
                                    stop - stops the program
                                    add - adds a new task
                                    list - lists all the tasks
                                    remove - removes a specified task.
                            """
                    );
                    break;
                case "stop":
                    System.out.println("Exiting program...");
                    break MainLoop;
                case "add":
                    System.out.print("To add: ");
                    input = scanner.next();
                    list.add(input);
                    break;
                case "list":
                    list.print();
                    break;
                case "remove":
                    System.out.print("Which one should be removed? ");
                    input = scanner.next();
                    try {
                        int i = Integer.parseInt(input);
                        list.remove(i);
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex);
                    }
                    break;
                default:
                    System.out.println("Command not recognized.");
                    break;
            }
        }
    }
}

class TodoList {
    List<String> todos;

    public TodoList() {
        this.todos = new ArrayList<>();
    }

    public void print() {
        int i = 1;
        for(String task : todos) {
            System.out.println(i + ": " + task);
            i++;
        }
    }

    public void add(String task) {
        todos.add(task);
    }

    public void remove(int i) {
        try {
            todos.remove(i - 1);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}

public class ToDo {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        Scanner scan = new Scanner(System.in);
        UserInterface ui = new UserInterface(list, scan);
        ui.start();
        scan.close();
    }
}
