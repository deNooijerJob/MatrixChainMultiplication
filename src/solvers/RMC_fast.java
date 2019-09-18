package solvers;

public class RMC_fast extends RMC {
    /*
        i = x
        j = y
     */
    @Override
    public int solve(int[] p, int i, int j) {
        int n = p.length;

        int[][] m = new int[n][n];

        for (int x = 0; x < n-1; x++) {
            m[x][x] = 0;
        }
        for (int x = n-1; x >= 0; x--) {
            //System.out.println("x = " + x);
            for (int y = x+1; y < n; y++) {
                m[x][y] = Integer.MAX_VALUE;
                for (int k = x; k < y-1; k++) {
                    int cost = m[x][k]+ m[k+1][y] + p[x]*p[k]*p[y];
                    System.out.println("cost = " + cost);
                    if (cost < m[x][y])
                        m[x][y] = cost;
                        //printM(m,n);
                }
            }
        }
        printM(m, n);
        return m[0][n-1];
    }

    private void printM(int[][] m, int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print("|"+ m[i][j] + "|");
            }
            System.out.println("\n-------------------------------------");
        }
    }


}
