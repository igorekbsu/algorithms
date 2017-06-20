package num2words;
public class Solution {
    String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    String helper(int num) {
        String r;
        if (num < 10) r = belowTen[num];
        else if (num < 20) r = belowTwenty[num - 10];
        else if (num < 100) r = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1_000) r = helper(num / 100) + " Hundred " + helper(num % 100);
        else if (num < 1_000_000) r = helper(num / 1_000) + " Thousand " + helper(num % 1_000);
        else if (num < 1_000_000_000) r = helper(num / 1_000_000) + " Million " + helper(num % 1_000_000);
        else r = helper(num / 1_000_000_000) + " Billion " + helper(num % 1_000_000_000);
        return r.trim();
    }
}