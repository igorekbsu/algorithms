package tiny_url;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public class Codec {
        final static String PRE = "http://tinyurl/";
        Map<Integer, String> map = new HashMap<>();
        int counter;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            map.put(counter, longUrl);
            return PRE + counter++;
        }

        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.substring(PRE.length())));
        }
    }
}
