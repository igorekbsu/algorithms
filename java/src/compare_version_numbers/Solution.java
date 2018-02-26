package compare_version_numbers;
public class Solution {
    public int compareVersion(String v1, String v2) {
        String[] v1parts = v1.split("\\."), v2parts = v2.split("\\.");
        for (int i = 0; i < Math.max(v1parts.length, v2parts.length); i++) {
            int n1 = i < v1parts.length ? Integer.parseInt(v1parts[i]) : 0;
            int n2 = i < v2parts.length ? Integer.parseInt(v2parts[i]) : 0;
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
        }
        return 0;
    }
}
