public class ArenaPopulation {
    public static int[][] arenaPopulationGeneration(int arenaSize) {
        // creates a random zeroth generation with variables 0 or 1 (more could be added)
        int[][] generationZero = new int[arenaSize][arenaSize];
        for(int i = 0; i < arenaSize; i++) {
            for(int j = 0; j < arenaSize; j++) {
                double preCellLife = (Math.random() * 100);
                int cellLife = (int)preCellLife;
                cellLife = cellLife % 2;
                generationZero[i][j] = cellLife;
            }
        }
        return generationZero;
    }
    public static int[][] arenaRules(int[][] generationInput) {
        int x = generationInput.length;
        int y = generationInput[0].length;
        int[][] generationRecord = new int[x][y];
        // checks every cell
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                // sets min and max variables to prevent out of bounds errors
                int minRow = Math.min(i, i - 1);
                if(minRow < 0) {
                    minRow = i;
                }
                int minCol = Math.min(j, j - 1);
                if(minCol < 0) {
                    minCol = j;
                }
                int maxRow = Math.max(i, i + 1);
                if(maxRow > y) {
                    minRow = i;
                }
                int maxCol = Math.max(j, j + 1);
                if(maxCol > x) {
                    maxCol = j;
                }
                // check adjacent squares of every cell
                for (int row = minRow; row <= maxRow; row++) {
                    for (int col = minCol; col <= maxCol; col++) {
                        // prevents out of bounds errors again?
                        if (row >= 0 && col >= 0 && row < generationInput.length && col < generationInput[0].length) {
                            // prevents cell from checking itself
                            if(row != i || col != j) {
                                if (generationInput[row][col] == 1) {
                                    generationRecord[i][j] += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return generationRecord;
    }
    public static int[][] arenaRulesApplied(int[][] generationOld, int[][] generationRulesReady) {
        int x = generationRulesReady.length;
        int y = generationRulesReady[0].length;
        int[][] generationNew = new int[x][y];
        // runs through every cell
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                // compares the current generation and its adjacent squares and applies the rules to create new generation
                if (generationRulesReady[i][j] == 1 && (generationOld[i][j] < 2 || generationOld[i][j] > 3)) {
                    generationNew[i][j] = 0;
                }
                if (generationRulesReady[i][j] == 1 && (generationOld[i][j] == 2 || generationOld[i][j] == 3)) {
                    generationNew[i][j] = 1;
                }
                if (generationRulesReady[i][j] == 0 && (generationOld[i][j] > 3 || generationOld[i][j] < 3)) {
                    generationNew[i][j] = 0;
                }
                if (generationRulesReady[i][j] == 0 && generationOld[i][j] == 3) {
                    generationNew[i][j] = 1;
                }
            }
        }
        return generationNew;
    }
}