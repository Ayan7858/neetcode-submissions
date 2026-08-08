class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> numsCount = new HashMap<>();
        if(nums.length<=1){
            return false;
        }
        for(int i=0; i<nums.length; i++){
            if(numsCount.containsKey(nums[i])){
                return true;
            }
            numsCount.put(nums[i], numsCount.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }
}
