package nested_int;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().deserialize("[123,[456,[789]]]");
    }

    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) return new NestedInteger();
        if (!s.startsWith("[")) return new NestedInteger(Integer.parseInt(s));
        NestedInteger ni = new NestedInteger();
        s = s.substring(1, s.length() - 1);
        int prev = 0, open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') open++;
            if (s.charAt(i) == ']') open--;
            if (s.charAt(i) == ',' && open == 0) {
                ni.add(deserialize(s.substring(prev, i)));
                prev = i + 1;
            }
        }
        if (prev != s.length())
            ni.add(deserialize(s.substring(prev, s.length())));
        return ni;
    }

    public class NestedInteger {
        int val;
        List<NestedInteger> list;

        public NestedInteger() {
            list = new ArrayList<>();
        }

        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
        }

        public NestedInteger(int value) {
            this.val = value;
        }

        public boolean isInteger() {return list == null;}

        public Integer getInteger() {return val;}

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            val = value;
        }

        public void add(NestedInteger ni) {
            list.add(ni);
        }

        public List<NestedInteger> getList() {return list;}

        @Override public String toString() {
            StringBuilder b = new StringBuilder();
            if (list != null) b.append(list);
            else b.append(val);
            return b.toString();
        }
    }
}