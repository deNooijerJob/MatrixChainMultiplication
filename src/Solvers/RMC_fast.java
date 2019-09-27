package Solvers;

import ADT.Matrix;

public class RMC_fast extends RMC {

    @Override
    public int solve(Matrix[] matrices, int[] p, int q, int w) {
        int n = p.length;

        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (int L = 2; L < n; L++) {

            for (int i = 1 ; i < (n - L +1); i++ ) {
                int j = i + L - 1;
                if (j == n) continue;
                m[i][j] = 1000000;
                for (int k = i; k <= j-1; k++) {
                    int cost = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Parenthesized result:");
        PrintParenthesis.print(matrices, s, 0,n-2);
        System.out.print("\n");
        return m[1][n-1];
    }
}