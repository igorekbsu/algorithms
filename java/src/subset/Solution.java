package subset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(new Solution().subsetsWithDup(a));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> r = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            while(count + i < nums.length && nums[i] == nums[count + i])
                count++;
            int previousN = r.size();
            for(int k = 0; k < previousN; k++){
                List<Integer> list = new ArrayList<>(r.size());
                for(int j = 0; j < count; j++){
                    list.add(nums[j]);
                    r.add(new ArrayList<>(list));
                }
            }
        }
        return r;
    }
}
