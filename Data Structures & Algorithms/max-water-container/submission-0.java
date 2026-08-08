class Solution {
    public int maxArea(int[] heights) {
        if(heights.length <= 1) return 0;
        int l = 0, r = heights.length - 1;
        int result = 0;

        while(l < r) {
            int vol = Math.abs(l-r) * Math.min(heights[l], heights[r]);
            result = Math.max(result, vol);
            if(heights[l] < heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return result;
    }
}
