package sliding_window_median;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

public class Solution {
    public double[] medianSlidingWindow(int[] a, int k) {
        Comparator<Integer> comparator = (t1, t2) -> a[t1] != a[t2] ? Integer.compare(a[t1], a[t2]) : t1 - t2;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);
        Supplier<Double> median = (k % 2 == 0) ?
            () -> ((double) a[left.first()] + a[right.first()]) / 2 :
            () -> (double) a[right.first()];
        Runnable balance = () -> {
            while (left.size() > right.size()) right.add(left.pollFirst());
        };
        double[] result = new double[a.length - k + 1];
        for (int i = 0; i < k; i++)
            left.add(i);
        balance.run();
        result[0] = median.get();
        for (int i = k, r = 1; i < a.length; i++, r++) {
            if (!left.remove(i - k))
                right.remove(i - k);
            right.add(i);
            left.add(right.pollFirst());
            balance.run();
            result[r] = median.get();
        }
        return result;
    }
}
