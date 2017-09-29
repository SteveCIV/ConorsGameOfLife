public class ArenaPopulation {
    public static int[][] arenaPopulationGeneration(int arenaSize) {
        int[][] generationOutput = new int[arenaSize][arenaSize];
        for(int i = 0; i < arenaSize; i++) {
            for(int j = 0; j < arenaSize; j++) {
                double preCellLife = (Math.random() * 100);
                int cellLife = (int)preCellLife;
                cellLife = cellLife % 2;
                generationOutput[i][j] = cellLife;
            }
        }
        return generationOutput;
    }
    public static int[][] arenaRules(int[][] generationInput) {
        int x = generationInput.length;
        int y = generationInput[0].length;
        int[][] generationRecord = new int[x][y];

        for(int i = 0; i < x; i++) { // <= or < ?
            for(int j = 0; j < y; j++) { // <= or < ?

                // mistake in here
                int minRow = Math.min(i, i - 1);
                if(minRow <= 0) {
                    minRow = i;
                }
                int maxRow = Math.max(i, i + 1);
                if(maxRow >= y) {
                    minRow = i;
                }
                int minCol = Math.min(j, j - 1);
                if(minCol <= 0) {
                    minCol = j;
                }
                int maxCol = Math.max(j, j + 1);
                if(maxCol >= x) {
                    maxCol = j;
                }

                for (int row = minRow; row < maxRow; row++) {
                    for (int col = minCol; col < maxCol; col++) {
                        if(generationInput[row][col] == 1) { // problem ?
                            generationRecord[i][j] += 1; // problem ?
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
                if (generationOld[i][j] == 1 && (generationRulesReady[i][j] < 2 || generationRulesReady[i][j] > 3)) {
                    generationNew[i][j] = 0;
                }
                if (generationOld[i][j] == 1 && (generationRulesReady[i][j] == 2 || generationRulesReady[i][j] == 3)) {
                    generationNew[i][j] = 1;
                }
                if (generationOld[i][j] == 0 && (generationRulesReady[i][j] > 3 || generationRulesReady[i][j] < 3)) {
                    generationNew[i][j] = 0;
                }
                if (generationOld[i][j] == 0 && generationRulesReady[i][j] == 3) {
                    generationNew[i][j] = 1;
                }
            }
        }
        return generationNew;
    }
}