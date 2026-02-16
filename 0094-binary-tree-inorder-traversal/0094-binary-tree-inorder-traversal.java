import java.util.*;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {

            // go left
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // visit node
            curr = stack.pop();
            result.add(curr.val);

            // go right
            curr = curr.right;
        }

        return result;
    }
}
