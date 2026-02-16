class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // case 1: both null
        if(p == null && q == null)
            return true;

        // case 2: one null
        if(p == null || q == null)
            return false;

        // case 3: values different
        if(p.val != q.val)
            return false;

        // check left and right subtree
        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
