import ADT.Matrix;
import solvers.RMC;
import solvers.RMC_fast;
import solvers.RMC_slow;

import java.util.Random;

public class Main {

    public static void main (String[] args) {
        Matrix[] matrices = generateMatrices();
        int[] p = generateSizes(matrices);
        RMC rmc = new RMC_fast();
        long startTime = System.nanoTime();

        int minCost = rmc.solve(p, 1, 4);

        long endTime = System.nanoTime();
        double runtime = (double) (endTime - startTime)/1000000;

        System.out.println("Minimal cost = " + minCost);
        System.out.println("Ellapsed time = " + runtime + "ms");
    }



     private static Matrix[] generateMatrices() {
        Matrix[] res = new Matrix[4];
        res[0] = new Matrix(40, 20, "A");
        res[1] = new Matrix(20, 30, "B");
        res[2] = new Matrix(30, 10, "C");
        res[3] = new Matrix(10, 30, "D");

        return res;
    }


    private static int[] generateSizes(Matrix[] matrices) {
        int numMatrices = matrices.length;
        int[] res = new int[numMatrices + 1];

        int i = 0;
        for (Matrix m : matrices) {
            if ( i == 0) {
                res[i] = m.getW();
                res[i+1] = m.getH();
                i = 2;
            } else {
                res[i] = m.getH();
                i++;
            }
        }

        return res;
    }

}
