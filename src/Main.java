import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int selection = 1;
        while (selection == 1) {
            System.out.println("Would you like to enter contact data?");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            if (scanner.nextInt() == 1) {
                GenerateValues values = new GenerateValues();
                values.feedValues();
            } else {
                selection = 2;
            }
        }
    }
}