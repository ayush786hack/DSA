class Solution {
     public int removeDuplicates(int[] nums) {
        // HashSet to store unique elements we have seen
        HashSet<Integer> seen = new HashSet<>();

        // Position to overwrite next unique element
        int index = 0;

        // Loop over each number in nums
        for (int num : nums) {
            // If num is not in the set, it is unique
            if (!seen.contains(num)) {
                // Add num to the set
                seen.add(num);

                // Write num at current index position
                nums[index] = num;

                // Move index forward
                index++;
            }
        }
        // Return number of unique elements
        return index;
    }
}