package repeated_substr_pattern;
public class Solution {
  public boolean repeatedSubstringPattern(String s) {
    StringBuilder ss = new StringBuilder(s).append(s);
    return ss.substring(1, ss.length() - 1).contains(s);
  }
}
