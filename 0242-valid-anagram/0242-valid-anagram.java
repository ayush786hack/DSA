class Solution {
    public boolean isAnagram(String s, String t) {
    if(s.length()!=t.length())
    return false;

StringBuilder sb = new StringBuilder(t);

for(int j=0; j<s.length(); j++) {

    boolean found = false;

    for(int k=0; k<sb.length(); k++) {

        if(s.charAt(j)==sb.charAt(k)) {
            sb.deleteCharAt(k);
            found = true;
            break;
        }
    }

    if(!found)
        return false;
}

return sb.length()==0;
    }
}