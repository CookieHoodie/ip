import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println();

        String command;
        do {
            Scanner input = new Scanner(System.in);
            command = input.nextLine();
            System.out.println(command);
        }
        while (!command.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }
}
