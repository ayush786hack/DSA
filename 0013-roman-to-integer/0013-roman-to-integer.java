class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int prevValue = 0;
        
        // Loop backwards to easily handle subtraction rules
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = getValue(s.charAt(i));
            
            // If current value is less than the previous value, subtract it
            if (currentValue < prevValue) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }
            
            prevValue = currentValue;
        }
        
        return sum;
    }
    
    // Helper method using primitive char comparison
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
