class Solution {
    public boolean isValid(String s) {
        Stack<Character> p = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                p.push(s.charAt(i));
            }
           
            if (s.charAt(i) == ')' && (!p.isEmpty()) && p.peek() == '(') {
                p.pop();
            }else if(s.charAt(i) == ')'){
                return false;
            }

            if (s.charAt(i) == '}' && (!p.isEmpty()) && p.peek() == '{') {
                p.pop();
            }else if(s.charAt(i) == '}'){
                return false;
            }

            if (s.charAt(i) == ']' && (!p.isEmpty()) && p.peek() == '[') {
                p.pop();
            }else if(s.charAt(i) == ']'){
                return false;
            }
             

        }
        
        if (!p.isEmpty()) {
            return false;
        }

        return true;
    }
}