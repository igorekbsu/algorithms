package detect_capital;
public class Solution {
  public boolean detectCapitalUse(String word) {
    int uc = 0;//upper count
    for (char c : word.toCharArray())
      if ('Z' - c >= 0) uc++;
    return (uc == 0 || uc == word.length()) || (uc == 1 && 'Z' - word.charAt(0) >= 0);
  }
}
