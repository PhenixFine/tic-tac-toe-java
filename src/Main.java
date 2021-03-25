import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        String[] grid = new Scanner(System.in).next().split("(?<=\\G.{3})");
        String dashes = "---------";

        System.out.println(dashes);
        for (String line : grid) {
            char[] chars = line.toCharArray();
            System.out.println("| " + chars[0] + " " + chars[1] + " " + chars[2] + " |");
        }
        System.out.println(dashes);
    }
}