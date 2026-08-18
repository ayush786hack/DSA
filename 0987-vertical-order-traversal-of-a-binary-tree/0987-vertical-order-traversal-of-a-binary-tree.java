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
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<int[]>> mp = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        vertical(root, mp, 0, 0);

        for (Map.Entry<Integer, List<int[]>> entry : mp.entrySet()) {

            List<int[]> nodes = entry.getValue();

            nodes.sort((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }

                return Integer.compare(a[1], b[1]);
            });

            List<Integer> column = new ArrayList<>();

            for (int[] node : nodes) {
                column.add(node[1]);
            }

            ans.add(column);
        }

        return ans;
    }

    public void vertical(
        TreeNode root,
        TreeMap<Integer, List<int[]>> mp,
        int row,
        int col
    ) {
        if (root == null) {
            return;
        }

        vertical(root.left, mp, row + 1, col - 1);

        mp.computeIfAbsent(col, k -> new ArrayList<>())
          .add(new int[]{row, root.val});

        vertical(root.right, mp, row + 1, col + 1);
    }
}