class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                res[i] = stack.peek()[1] - i;
            }
            else {
                res[i] = 0;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
