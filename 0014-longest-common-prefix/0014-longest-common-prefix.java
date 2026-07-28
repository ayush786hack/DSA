class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Handle empty input array
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        StringBuilder prefix = new StringBuilder();
        // Use the first string as a reference for comparison
        String firstStr = strs[0];
        
        // Loop through each character of the first string
        for (int i = 0; i < firstStr.length(); i++) {
            char ch = firstStr.charAt(i);
            
            // Check this character against all other strings
            for (int j = 1; j < strs.length; j++) {
                // Stop if string is too short or character doesn't match
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return prefix.toString();
                }
            }
            
            // Character matches in all strings, add it to StringBuilder
            prefix.append(ch);
        }
        
        return prefix.toString();
    }
}
