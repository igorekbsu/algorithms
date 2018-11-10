package uniq_email_addresses;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> s = new HashSet<>();
        for (String email : emails) {
            String p[] = email.split("@"), local = p[0], domain = p[1];
            StringBuilder send = new StringBuilder();
            for (char c : local.toCharArray())
                if (c == '+')
                    break;
                else if (c != '.')
                    send.append(c);
            s.add(send.append('@').append(domain).toString());
        }
        return s.size();
    }
}
