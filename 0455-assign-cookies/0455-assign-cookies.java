class Solution {
    public int findContentChildren(int[] g, int[] s) {
   // Sort both arrays to apply the greedy strategy
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0;
        int sIndex = 0;

        // Try to assign cookies until any one list is fully processed
        while (gIndex < g.length && sIndex < s.length) {
            // If the cookie satisfies the student's greed
            if (s[sIndex] >= g[gIndex]) {
                gIndex++;
            }
            // Move to next cookie in both cases
            sIndex++;
        }

        // Number of students satisfied is equal to studentIndex
        return gIndex;
    }
}