package masking_personal_info;
public class Solution {
    public String maskPII(String s) {
        int at = s.indexOf('@');
        if (at > 0)
            return (s.charAt(0) + "*****" + s.substring(at - 1)).toLowerCase();
        String[] country = {"", "+*-", "+**-", "+***-"};
        String r = s.replaceAll("[^0-9]", "");
        return country[r.length() - 10] + "***-***" + r.substring(r.length() - 4);
    }
}
