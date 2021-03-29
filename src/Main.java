import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter cells: ");
        String combined = new Scanner(System.in).next();
        String[][] cells = {combined.substring(0, 3).split(""), combined.substring(3, 6).split(""),
                combined.substring(6).split("")};

        printGrid(cells);
        printResults(cells, combined);
    }

    private static void printGrid(String[][] cells) {
        String dashes = "---------";

        System.out.println(dashes);
        for (String[] chars : cells) System.out.println("| " + chars[0] + " " + chars[1] + " " + chars[2] + " |");
        System.out.println(dashes);
    }

    private static void printResults(String[][] cells, String combined) {
        int xCount = combined.length() - combined.replace("X", "").length();
        int oCount = combined.length() - combined.replace("O", "").length();
        boolean xWins = checkWin(cells, "X");
        boolean oWins = checkWin(cells, "O");
        boolean empty = combined.contains("_");

        System.out.println(xWins && oWins || Math.abs(xCount - oCount) > 1 ? "Impossible" : xWins ? "X wins" :
                oWins ? "O wins" : empty ? "Game not finished" : "Draw");
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