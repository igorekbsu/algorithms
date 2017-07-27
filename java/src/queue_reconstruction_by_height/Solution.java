package queue_reconstruction_by_height;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        people = new Solution().reconstructQueue(people);
        for (int[] person : people) {
            System.out.print(Arrays.toString(person) + " ");
        } ;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (b[0] - a[0] != 0)
                return b[0] - a[0];
            return a[1] - b[1];
        });
        for (int i = 1; i < people.length; i++) {
            int[] p = people[i];
            if (p[1] < i) {
                int j = i;
                while (j > 0 && j > p[1]) {
                    people[j] = people[j - 1];
                    j--;
                }
                people[j] = p;
            }
        }
        return people;
    }
}
