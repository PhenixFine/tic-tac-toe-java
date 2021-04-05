import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] cells = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
        String letter = "X";
        boolean xWins = false;
        boolean oWins = false;
        int empty = 9;

        do {
            printGrid(cells);
            getCell(cells, letter);
            if (letter.equals("X")) {
                xWins = checkWin(cells, letter);
                letter = "O";
            } else {
                oWins = checkWin(cells, letter);
                letter = "X";
            }
            empty--;
        } while (!xWins && !oWins && empty != 0);

        printGrid(cells);
        System.out.println(xWins ? "X wins" : oWins ? "O wins" : "Draw");
    }

    private static void printGrid(String[][] cells) {
        String dashes = "---------";

        System.out.println(dashes);
        for (String[] chars : cells) System.out.println("| " + chars[0] + " " + chars[1] + " " + chars[2] + " |");
        System.out.println(dashes);
    }

    private static void getCell(String[][] cells, String letter) {
        try {
            System.out.print("Enter the coordinates: ");
            String[] hold = new Scanner(System.in).nextLine().split(" ");
            int first = Integer.parseInt(hold[0]);
            int second = Integer.parseInt(hold[1]);

            if (notRange(first) || notRange(second)) throw new Exception("Coordinates should be from 1 to 3!");
            else if (!cells[first - 1][second - 1].equals("_")) {
                throw new Exception("This cell is occupied! Choose another one!");
            } else cells[first - 1][second - 1] = letter;
        } catch (Exception e) {
            System.out.println(e instanceof NumberFormatException || e instanceof IndexOutOfBoundsException ?
                    "You should enter numbers!" : e.getMessage());
            getCell(cells, letter);
        }
    }

    private static boolean notRange(int number) {
        return number < 1 || number > 3;
    }

    private static Boolean checkWin(String[][] cells, String check) {
        for (String[] line : cells) if ((line[0] + line[1] + line[2]).equals(check.repeat(3))) return true;
        for (int i = 0; i < cells.length; i++) {
            if (cells[0][i].equals(check) && cells[1][i].equals(check) && cells[2][i].equals(check)) return true;
        }
        if (cells[0][0].equals(check) && cells[1][1].equals(check) && cells[2][2].equals(check)) return true;
        return cells[0][2].equals(check) && cells[1][1].equals(check) && cells[2][0].equals(check);
    }
}