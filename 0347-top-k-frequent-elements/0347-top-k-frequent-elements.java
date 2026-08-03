class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> p=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
          p.put(nums[i],p.getOrDefault(nums[i],0)+1);
        }
     List<Map.Entry<Integer, Integer>> list = new ArrayList<>(p.entrySet());
    list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
    int ans[]=new int[k];
    for(int j=0;j<k;j++){
        ans[j]=list.get(j).getKey();
    }
    return ans;
    }
}