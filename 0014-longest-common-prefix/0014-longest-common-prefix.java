class Solution {
    public String longestCommonPrefix(String[] strs) {
      String prefix=strs[0];
   
      int i=0;
    
      while(i<strs.length-1){
           String current=strs[i+1];
             int j=0;
        while((j<prefix.length() && j<current.length())&&prefix.charAt(j)==current.charAt(j)){
         
          j++;
          if(prefix.length()==0){
            return prefix;
        
          }
           
        }
        prefix = prefix.substring(0, j);
                i++;
      }
         return prefix;
    }
}
