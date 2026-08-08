class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1; 
        HashSet<Character> count = new HashSet<>();
        int l = 0;
        int maxCount = 0;

        for(int r = 0; r < s.length(); r++){
            while(count.contains(s.charAt(r))){
                count.remove(s.charAt(l));
                l++;
            }
            count.add(s.charAt(r));
            maxCount = Math.max(maxCount, r - l + 1);
        }

        return maxCount;
    }
}
