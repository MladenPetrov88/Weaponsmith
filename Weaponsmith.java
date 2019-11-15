import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Weaponsmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        List<String> name = new ArrayList<>();


        for (int i = 0; i < input.length; i++) {
            name.add(input[i]);
        }
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] temp = command.split("\\s+");
            String firstCommand = temp[0];

            if (firstCommand.equals("Check")) {
                if (temp[1].equals("Odd")) {
                    for (int i = 0; i < name.size(); i++) {
                        if (i % 2 == 1) {
                            System.out.print(name.get(i) + " ");

                        }
                    }
                    System.out.println();
                } if (temp[1].equals("Even")) {
                    for (int i = 0; i < name.size(); i++) {
                        if (i % 2 == 0) {
                            System.out.print(name.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            }
            
            if (firstCommand.equals("Move")) {
                if (temp[1].equals("Right")) {
                    if (Integer.parseInt(temp[2]) >= 0 && Integer.parseInt(temp[2]) < name.size() -1) {
                        String newWord = name.get(Integer.parseInt(temp[2]));
                        int itemPos = name.indexOf(newWord);
                        name.remove(itemPos);
                        name.add(itemPos + 1, newWord);
                    }
                }

                 if (temp[1].equals("Left")) {
                     if (Integer.parseInt(temp[2]) > 0 && Integer.parseInt(temp[2]) < name.size()) {
                         String newWord = name.get(Integer.parseInt(temp[2]));
                         int itemPos = name.indexOf(newWord);
                         name.remove(itemPos);
                         name.add(itemPos - 1, newWord);
                     }
                }
            }

            command = scanner.nextLine();
        }

        System.out.print("You crafted ");
        for (String s : name) {
            System.out.print(String.join("", s));
        }
        System.out.print("!");

    }
}
