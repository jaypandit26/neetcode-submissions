class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        for(int i = 0;i<n;i++){
            int h = heights[i];
            int start = i;
        

        while(!stack.isEmpty() && stack.peek()[1] > h){
             int[] top = stack.pop();
             int index = top[0], height = top[1];

             maxArea = Math.max(maxArea, height * (i - index));
             // The popped bar was taller, so the current bar's rectangle
            // can extend left to where that bar started.

             start = index;
        }
        stack.push(new int[]{start, h});
        }
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            int index = top[0], height = top[1];
            maxArea = Math.max(maxArea, height * (n - index));
        }
        return maxArea;
    }
}
