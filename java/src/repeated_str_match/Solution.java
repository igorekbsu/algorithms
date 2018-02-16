package repeated_str_match;
public class Solution {
  public static void main(String[] args) {
    System.out.println(new Solution().repeatedStringMatch("baa", "abaab"));
  }

  public int repeatedStringMatch(String A, String B) {
    StringBuilder b = new StringBuilder(A);
    int count = 1;
    while (b.length() < B.length()) {
      b.append(A);
      count++;
    }
    if (b.toString().contains(B)) return count;
    if (b.append(A).toString().contains(B)) return count + 1;
    return -1;
  }
}
