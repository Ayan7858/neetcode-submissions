class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        Arrays.sort(nums);

        while(l <= r) {
            int mid = r - l / 2;
            if(nums[mid] > target) {
                r--;
            }
            else if(nums[mid] < target) {
                l++;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
