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
        String[] inputList = new String[100];
        int itemNum = 0;
        while (true) {
            Scanner input = new Scanner(System.in);
            command = input.nextLine();

            if (command.equals("bye")) {
                break;
            }
            else if (command.equals("list")) {
                for (int i = 0; i < itemNum; i++) {
                    System.out.println((i+1) + ". " + inputList[i]);
                }
            }
            else {
                System.out.println("added: " + command);
                inputList[itemNum] = command;
                itemNum++;
            }
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
