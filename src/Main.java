import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String combined = new Scanner(System.in).next();
        String[] lines = combined.split("(?<=\\G.{3})");

        printGrid(lines);
        printResults(lines, combined);
    }

    private static void printGrid(String[] lines) {
        String dashes = "---------";

        System.out.println(dashes);
        for (String line : lines) {
            char[] chars = line.toCharArray();
            System.out.println("| " + chars[0] + " " + chars[1] + " " + chars[2] + " |");
        }
        System.out.println(dashes);
    }

    private static void printResults(String[] lines, String combined) {
        int xCount = charCount(combined, "X");
        int oCount = charCount(combined, "O");
        boolean xWins = checkWin(lines, "X");
        boolean oWins = checkWin(lines, "O");
        boolean empty = combined.contains("_");

        System.out.println(xWins && oWins || Math.abs(xCount - oCount) > 1 ? "Impossible" : xWins ? "X wins" :
                oWins ? "O wins" : empty ? "Game not finished" : "Draw");
    }

    private static int charCount(String text, String check) {
        String[] letter = text.split("");
        int count = 0;

        for (String one : letter) if (one.equals(check)) count++;
        return count;
    }

    private static Boolean checkWin(String[] lines, String check) {
        String[][] cells = {lines[0].split(""), lines[1].split(""), lines[2].split("")};

        for (String line : lines) if ((line).equals(check.repeat(3))) return true;
        for (int i = 0; i < cells.length; i++) {
            if (cells[0][i].equals(check) && cells[1][i].equals(check) && cells[2][i].equals(check)) return true;
        }
        if (cells[0][0].equals(check) && cells[1][1].equals(check) && cells[2][2].equals(check)) return true;
        return cells[0][2].equals(check) && cells[1][1].equals(check) && cells[2][0].equals(check);
    }
}