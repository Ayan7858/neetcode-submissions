class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() != t.length())
            return false;
        HashMap<Character, Integer> firstCharCount = new HashMap<>();
        HashMap<Character, Integer> secondCharCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            firstCharCount.put(s.charAt(i), firstCharCount.getOrDefault(s.charAt(i), 0) + 1);
            secondCharCount.put(t.charAt(i), secondCharCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        if(firstCharCount.equals(secondCharCount))
            return true;
        else
            return false;
    }
}
