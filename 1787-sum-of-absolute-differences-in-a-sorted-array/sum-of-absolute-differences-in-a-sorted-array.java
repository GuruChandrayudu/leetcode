class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Compute total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int prefixSum = 0;
        
        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum;
            int rightSum = totalSum - prefixSum - nums[i];
            
            int leftContribution = nums[i] * i - leftSum;
            int rightContribution = rightSum - nums[i] * (n - i - 1);
            
            result[i] = leftContribution + rightContribution;
            
            prefixSum += nums[i];
        }
        
        return result;
    }
}
