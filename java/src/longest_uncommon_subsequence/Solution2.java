package longest_uncommon_subsequence;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
  public static void main(String[] args) {
    System.out.println(new Solution2().findLUSlength(new String[]{"Igor", "Vasil", "Anton", "JonSnow"}));
  }

  public int findLUSlength(String[] strs) {
    Set<String> dups = new HashSet<>(), used = new HashSet<>();
    for (String str : strs) {
      if (dups.contains(str)) continue;
      if (used.contains(str)) {
        used.remove(str);
        dups.add(str);
      } else
        used.add(str);
    }
    int max = -1;
    for (String s : used)
      max = Math.max(max, s.length());
    return max;
  }
}
