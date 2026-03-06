public class SudokuSolver {

    static final int SIZE = 9;

    public static void main(String[] args) {

        int[][] grid = {
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };

        System.out.println("Unsolved Sudoku:");
        printGrid(grid);

        if (solveSudoku(grid)) {
            System.out.println("\nSolved Sudoku:");
            printGrid(grid);
        } else {
            System.out.println("No solution exists");
        }
    }

    static boolean solveSudoku(int[][] grid) {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (grid[row][col] == 0) {

                    for (int num = 1; num <= 9; num++) {

                        if (isSafe(grid, row, col, num)) {

                            grid[row][col] = num;

                            if (solveSudoku(grid))
                                return true;

                            grid[row][col] = 0; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isSafe(int[][] grid, int row, int col, int num) {

        for (int i = 0; i < SIZE; i++)
            if (grid[row][i] == num || grid[i][col] == num)
                return false;

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }

    static void printGrid(int[][] grid) {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}
