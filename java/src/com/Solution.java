package com;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().similarRGB("#1155cc"));
    }

    public String similarRGB(String color) {
        int r = Integer.parseInt(color.substring(1, 3), 16);
        int g = Integer.parseInt(color.substring(3, 5), 16);
        int b = Integer.parseInt(color.substring(5, 7), 16);
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int max = Integer.MIN_VALUE;
        String result = "";
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
                for (int k = 0; k < 16; k++) {
                    int a1 = 16 * i + i - r;
                    int a2 = 16 * j + j - g;
                    int a3 = 16 * k + k - b;
                    int score = -a1 * a1 - a2 * a2 - a3 * a3;
                    if (score > max) {
                        max = score;
                        result = "" + map[i] + map[i] + map[j] + map[j] + map[k] + map[k];
                    }
                }
        return "#" + result;
    }

    public int minSwap(int[] A, int[] B) {
        int i = 1   ;
        for (; i < B.length; i++)
            if (A[i - 1] >= A[i] || B[i - 1] >= B[i])
                break;
        if (i >= B.length) return 0;
        swap(A, B, i - 1);
        int swaps1 = minSwap(A, B);
        swap(A, B, i - 1);
        swap(A, B, i);
        int swaps2 = minSwap(A, B);
        swap(A, B, i);
        return 1 + Math.min(swaps1, swaps2);
    }

    void swap(int[] A, int[] B, int i) {
        int t = A[i];
        A[i] = B[i];
        B[i] = t;
    }
}
