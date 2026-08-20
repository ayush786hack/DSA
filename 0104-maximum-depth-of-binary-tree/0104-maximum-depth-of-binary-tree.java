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
    int lvl;

    Pair(int lvl, TreeNode node) {
        this.node = node;
        this.lvl = lvl;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, root));

        int maxLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();

                maxLevel = Math.max(p.lvl, maxLevel);

                if (p.node.left != null) {
                    q.add(new Pair(p.lvl + 1, p.node.left));
                }

                if (p.node.right != null) {
                    q.add(new Pair(p.lvl + 1, p.node.right));
                }
            }
        }

        return maxLevel;
    }
}