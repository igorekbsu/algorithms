package print_comments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        boolean block = false;
        Scanner in = new Scanner(new FileInputStream("/home/rommel/projects/algorithms/java/src/comp/input04.txt"));
        while (in.hasNext()) {
            String s = in.nextLine().trim();
            int i = s.indexOf("//");
            if (i > -1) {
                System.out.println(s.substring(s.indexOf("//")));
                continue;
            }
            i = s.indexOf("/*");
            int j = s.indexOf("*/");
            if (!block && i > -1) {
                block = true;
                if (j > -1) {
                    block = false;
                    System.out.println(s.substring(i, j + 2));
                    continue;
                } else System.out.println(s.substring(i));
                continue;
            }
            if (block) {
                if (j > -1) {
                    block = false;
                    System.out.println(s.substring(0, j + 2));
                } else System.out.println(s);
            }
        }
    }
}