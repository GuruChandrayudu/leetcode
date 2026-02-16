import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxD = new LinkedList<>();
        Deque<Integer> minD = new LinkedList<>();

        int left = 0;
        int ans = 0;

        for(int right = 0; right < nums.length; right++) {

            // Maintain max deque (decreasing)
            while(!maxD.isEmpty() && nums[right] > nums[maxD.peekLast()])
                maxD.pollLast();
            maxD.offerLast(right);

            // Maintain min deque (increasing)
            while(!minD.isEmpty() && nums[right] < nums[minD.peekLast()])
                minD.pollLast();
            minD.offerLast(right);

            // Shrink window if invalid
            while(nums[maxD.peekFirst()] - nums[minD.peekFirst()] > limit) {

                if(maxD.peekFirst() == left)
                    maxD.pollFirst();

                if(minD.peekFirst() == left)
                    minD.pollFirst();

                left++;
            }

            // Update answer
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
