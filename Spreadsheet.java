import java.util.*;

class Spreadsheet {
    private int[][] grid; // store integers, not chars
    private int rows;
    private final int cols = 26; // A-Z

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][cols]; // all initialized to 0
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        // formula is like "=A1+B2" or "=10+5"
        formula = formula.substring(1); // remove '='
        String[] parts = formula.split("\\+");

        int sum = 0;
        for (String part : parts) {
            if (Character.isLetter(part.charAt(0))) {
                // it's a cell reference
                int[] pos = parseCell(part);
                sum += grid[pos[0]][pos[1]];
            } else {
                // it's an integer
                sum += Integer.parseInt(part);
            }
        }
        return sum;
    }

    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';

        // row part can be multiple digits
        int row = Integer.parseInt(cell.substring(1)) - 1; // convert to 0-indexed

        return new int[]{row, col};
    }
}
