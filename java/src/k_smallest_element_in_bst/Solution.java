package k_smallest_element_in_bst;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static nub.Nu.TreeNode;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        return vals.get(k);
    }

    void inorder(TreeNode root, List<Integer> vals) {
       if(root != null){
           inorder(root.left, vals);
           vals.add(root.val);
           inorder(root.right, vals);
       }
    }
}
