package com;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
    }

    public int[] numberOfLines(int[] widths, String S) {
        int lines = 0, currWidth = 0;
        for (char c : S.toCharArray()) {
            currWidth += widths[c - 'a'];
            if (currWidth == 100) {
                lines++;
                currWidth = 0;
            } else if (currWidth > 100) {
                lines++;
                currWidth = widths[c - 'a'];
            }
        }
        return new int[]{lines + 1, currWidth};
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."};
        Set<String> s = new HashSet<>();
        for (String word : words) {
            StringBuilder b = new StringBuilder();
            for (char c : word.toCharArray())
                b.append(morse[c - 'a']);
            s.add(b.toString());
        }
        return s.size();
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] top = new int[grid.length], left = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            left[i] = grid[i][0];
            top[i] = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                left[i] = Math.max(left[i], grid[i][j]);
                top[i] = Math.max(top[i], grid[j][i]);
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++) {
                max += Math.min(left[i], top[j]) - grid[i][j];
            }
        return max;
    }

    public boolean splitArraySameAverage(int[] A) {
        double sum = 0;
        for (int n : A)
            sum += n;
        double avr = sum / A.length;
        Arrays.sort(A);
        return split(A, 0, A.length - 1, avr, 0);
    }

    boolean split(int[] a, int left, int right, double avr, double sum) {
        if(sum == avr)return true;
        
        return false;
    }

}
