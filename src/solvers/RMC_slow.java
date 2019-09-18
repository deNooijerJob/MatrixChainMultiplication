package solvers;

public class RMC_slow extends RMC{

    @Override
    public int solve(int[] p, int i, int j) {
        if ( i == j)
            return 0;
        else {
            int cost = Integer.MAX_VALUE;
            for ( int k = i; k < j; k++ ) {
                cost = Math.min(cost, solve(p, i, k) + solve(p, k+1, j) + p[i-1]*p[k]*p[j]);
            }
            return cost;
        }
    }
}
