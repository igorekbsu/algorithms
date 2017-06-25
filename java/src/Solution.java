import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String[] s1 = {"Peter", "Vasil", "Victor"};
        String[] s2 = {"visited", "left"};
        String[] s3 = {"park", "gym"};
        String[][] s = {s1, s2, s3};
        Queue<String> q = new LinkedList<>();
        q.add("");
        for (String[] values : s) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String p = q.poll();
                for (String v : values)
                    q.add(p + " " + v);
            }
        }
       while(!q.isEmpty())
           System.out.println(q.poll().trim());
    }
}