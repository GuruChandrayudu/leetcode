import java.util.*;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if(root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {

        if(node == null)
            return;

        // add current node to path
        path += node.val;

        // if leaf node
        if(node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // go deeper
        path += "->";
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}
