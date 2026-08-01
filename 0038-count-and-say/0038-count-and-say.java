class Solution {
    public String countAndSay(int n) {
        if (n<0) return "";
        String current="1";
       for (int i = 1; i < n; i++) {
            StringBuilder nextSequence = new StringBuilder();
            int len = current.length();

             int j = 0;
            while (j < len) {
                char currentChar = current.charAt(j);
                int count = 0;
                 while (j < len && current.charAt(j) == currentChar) {
                    count++;
                    j++;
                }
                 nextSequence.append(count).append(currentChar);
            }
            
            
            current = nextSequence.toString();
        }
        
        return current;
    }
}
