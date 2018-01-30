package airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundNumber {
    //sum(Y) = round(sum(x)) minimize (|y1-x1| + |y2-x2| + ... + |yn-xn|)
    //Example1: input = 30.3, 2.4, 3.5 output = 30 2 4
    //Example2: input = 30.9, 2.4, 3.9 output = 31 2 4

    public List<Long> round(List<Double> X) {

        //calculate diff = sum(X) - sum(floorX)
        int floorSum = 0;
        double sumX = 0;
        for (Double x : X) {
            floorSum += Math.floor(x); //or (int)x
            sumX += x;
        }
        double diff = sumX - floorSum;
        //reorder floorX in the order of largest difference between floor and actual value first
        //don't calculate diff(X, ceil(X)) for nums like 4.0, 5.0
        List<E> Z = new ArrayList<>(); //(lhs, rhs) -> -Double.compare(lhs.diff, rhs.diff)
        for (int i = 0; i < X.size(); ++i) {
            double x = X.get(i);
            Z.add(new E(x, x - Math.floor(x), i));
        }
        Z.sort((lhs, rhs) -> -Double.compare(lhs.diff, rhs.diff));
        //for each of the number, add 1, until diff < 1
        //rearrange to corresponding input if required, depending on whether the output must be in the same order as input
        List<Long> ans = new ArrayList<>(Collections.nCopies(X.size(), 0L));
        for (E z : Z) {
            if (diff >= 1.0) {
                diff -= 1.0;
                z.x = z.x - z.diff + 1;
            }
            ans.set(z.i, (long)z.x);
        }
        return ans;
    }

    //could use Lombok in production code
    private static class E {
        double x;
        double diff; //x - floor(x)
        int i;
        public E(double x, double diff, int i) {
            this.x = x;
            this.diff = diff;
            this.i = i;
        }
    }
}
