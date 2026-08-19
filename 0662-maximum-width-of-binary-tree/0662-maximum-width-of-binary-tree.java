/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    TreeNode node;
    long position;

    Pair(TreeNode node, long position) {
        this.node = node;
        this.position = position;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int MaxWidth = 0;
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            Pair first = q.peek();
            long min = first.position;
            long lastPosition = 0;

            for (int i = 0; i < size; i++) {
                Pair current = q.poll();

                TreeNode node = current.node;
                long position = current.position;

                long currentposition = position - min;
                lastPosition = currentposition;

                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * currentposition));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * currentposition + 1));
                }
            }

            int width = (int) (lastPosition + 1);
            MaxWidth = Math.max(MaxWidth, width);
        }
        return MaxWidth;
    }

}