class Solution {
    public int[] productExceptSelf(int[] nums) {
       if(nums.length == 0) return new int[0];
       int n = nums.length;
       int[] prefix = new int[n];
       int[] suffix = new int[n];
       int[] res = new int[n];


       int pre = nums[0]; 
       int suf = nums[n - 1];
       for(int i = 1; i < n; i++){
            prefix[i] = pre;
            pre *= nums[i];
       }

       for(int i = n - 2; i >= 0; i--){
            suffix[i] = suf;
            suf *= nums[i];
       }

       for(int i = 0; i < n; i++){
        if(i == 0){
            res[i] = suffix[i];
        }
        else if(i == n - 1){
            res[i] = prefix[i];
        }
        else{
            res[i] = prefix[i] * suffix[i];
        }
       }

       return res;
    }
}  
