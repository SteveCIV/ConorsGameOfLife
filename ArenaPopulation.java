public class ArenaPopulation {
    public static int[][] arenaPopulationGeneration(int arenaSize) {
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

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {

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

                for (int row = minRow; row <= maxRow; row++) {
                    for (int col = minCol; col <= maxCol; col++) {
                        if (row >= 0 && col >= 0 && row < generationInput.length && col < generationInput[0].length) {
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

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
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