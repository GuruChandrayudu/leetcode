import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0) return new int[0];

        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];

        int index = 0;

        for(int i = 0; i < n; i++) {

            // 1. Remove out of window elements
            if(!dq.isEmpty() && dq.peekFirst() == i - k)
                dq.pollFirst();

            // 2. Remove smaller elements from back
            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()])
                dq.pollLast();

            // 3. Add current index
            dq.offerLast(i);

            // 4. Record max
            if(i >= k - 1)
                result[index++] = nums[dq.peekFirst()];
        }

        return result;
    }
}
