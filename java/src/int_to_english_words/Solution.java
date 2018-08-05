package int_to_english_words;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberToWords(1_000_000_001));
    }


    final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"};
    final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int n) {
        if (n == 0) return "Zero";
        int i = 0;
        String words = "";
        while (n > 0) {
            if (n % 1000 != 0)
                words = str(n % 1000) + THOUSANDS[i] + " " + words;
            n /= 1000;
            i++;
        }
        return words.trim();
    }

    String str(int n) {
        if (n == 0)
            return "";
        else if (n < 20)
            return LESS_THAN_20[n] + " ";
        else if (n < 100)
            return TENS[n / 10] + " " + str(n % 10);
        else
            return LESS_THAN_20[n / 100] + " Hundred " + str(n % 100);
    }
}
