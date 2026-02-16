import java.util.*;

class Solution {

    class Tuple {
        TreeNode node;
        int col, row;

        Tuple(TreeNode n, int c, int r) {
            node = n;
            col = c;
            row = r;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
                = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while(!queue.isEmpty()) {

            Tuple t = queue.poll();
            TreeNode node = t.node;
            int col = t.col;
            int row = t.row;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if(node.left != null)
                queue.offer(new Tuple(node.left, col - 1, row + 1));

            if(node.right != null)
                queue.offer(new Tuple(node.right, col + 1, row + 1));
        }

        List<List<Integer>> result = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> colList = new ArrayList<>();

            for(PriorityQueue<Integer> pq : rows.values()) {
                while(!pq.isEmpty())
                    colList.add(pq.poll());
            }

            result.add(colList);
        }

        return result;
    }
}
