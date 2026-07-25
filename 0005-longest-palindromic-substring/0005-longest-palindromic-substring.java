class Solution {
    public String longestPalindrome(String s) {
        String res ="";
       for (int i = 0; i < s.length(); i++) {
    for (int j = i; j < s.length(); j++) {
        String temp = s.substring(i, j + 1);

        if (isPalindrome(temp) && temp.length() > res.length()) {
            res = temp;
        }
    }

}
      return res;  
  } 
  private boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right))
            return false;
        left++;
        right--;
    }
    return true;
}
}
