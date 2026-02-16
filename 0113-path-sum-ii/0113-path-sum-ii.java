import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);
        return result;
    }

    private void dfs(TreeNode node, int sum,
                     List<Integer> path,
                     List<List<Integer>> result) {

        if(node == null)
            return;

        // add current node
        path.add(node.val);
        sum -= node.val;

        // check leaf
        if(node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(path)); // copy path
        }

        // explore
        dfs(node.left, sum, path, result);
        dfs(node.right, sum, path, result);

        // BACKTRACK (MOST IMPORTANT LINE)
        path.remove(path.size() - 1);
    }
}
