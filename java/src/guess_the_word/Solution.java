package guess_the_word;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        String[] words = {
            "gaxckt", "trlccr", "jxwhkz", "ycbfps", "peayuf", "yiejjw", "ldzccp", "nqsjoa", "qrjasy", "pcldos", "acrtag", "buyeia", "ubmtpj", "drtclz", "zqderp", "snywek", "caoztp", "ibpghw",
            "evtkhl", "bhpfla", "ymqhxk", "qkvipb", "tvmued", "rvbass", "axeasm", "qolsjg", "roswcb", "vdjgxx", "bugbyv", "zipjpc", "tamszl", "osdifo", "dvxlxm", "iwmyfb", "wmnwhe", "hslnop",
            "nkrfwn", "puvgve", "rqsqpq", "jwoswl", "tittgf", "evqsqe", "aishiv", "pmwovj", "sorbte", "hbaczn", "coifed", "hrctvp", "vkytbw", "dizcxz", "arabol", "uywurk", "ppywdo", "resfls",
            "tmoliy", "etriev", "oanvlx", "wcsnzy", "loufkw", "onnwcy", "novblw", "mtxgwe", "rgrdbt", "ckolob", "kxnflb", "phonmg", "egcdab", "cykndr", "lkzobv", "ifwmwp", "jqmbib", "mypnvf",
            "lnrgnj", "clijwa", "kiioqr", "syzebr", "rqsmhg", "sczjmz", "hsdjfp", "mjcgvm", "ajotcx", "olgnfv", "mjyjxj", "wzgbmg", "lpcnbj", "yjjlwn", "blrogv", "bdplzs", "oxblph", "twejel",
            "rupapy", "euwrrz", "apiqzu", "ydcroj", "ldvzgq", "zailgu", "xgqpsr", "wxdyho", "alrplq", "brklfk"
        };
        new Solution().solve("hbaczn", words);
    }

    void solve(String secret, String[] wordList) {
        Master m = new Master(secret);
        findSecretWord(wordList, m);
        System.out.println(m.attempts);
    }

    public void findSecretWord(String[] wordsList, Master m) {
        Random r = new Random();
        List<String> words = new ArrayList<>(wordsList.length);
        Collections.addAll(words, wordsList);
        int matches = 0;
        for (int i = 0; matches < 6; i++) {
            String guess = words.get(r.nextInt(words.size()));
            List<String> next = new ArrayList<>(words.size());
            matches = m.guess(guess);
            for (String w : words) {
                int currMatches = 0;
                for (int j = 0; j < w.length(); j++)
                    if (guess.charAt(j) == w.charAt(j))
                        currMatches++;
                if (currMatches == matches)
                    next.add(w);
                words = next;
            }
        }
    }

    int matches(String w1, String w2) {
        int matches = 0;
        for (int i = 0; i < w1.length(); i++)
            if (w1.charAt(i) == w2.charAt(i))
                matches++;
        return matches;
    }

    class Master {
        final String secret;
        int attempts = 0;

        Master(String secret) { this.secret = secret;}

        public int guess(String word) {
            attempts++;
            return matches(secret, word);
        }
    }
}
