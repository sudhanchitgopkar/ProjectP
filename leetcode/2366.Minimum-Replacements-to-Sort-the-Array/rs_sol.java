class Solution {
    public long minimumReplacement(int[] nums) {
        int curr = nums[nums.length - 1];
        long sol = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (curr >= nums[i]) curr = nums[i];
            else {
                // calculate highest factor that is still less than or equal to curr

                /* if nums[i] is divisible by curr, then just add to the solution counter,
                 * minus 1 since the split takes 1 less operation than calculated ()i.e. 6 -> 3 + 3 is 1 split, but 6 / 3 = 2)
                 */
                if  (nums[i] % curr == 0) sol += nums[i] / curr - 1;
                else {
                    // calculate highest factor that is still less than curr

                    // take an example where nums[i] is 301 and curr is 100
                    int div = nums[i] / curr;
                    // nums[i] / curr = 3.01
                    
                    // add the number of splits to the solution counter
                    sol += div;
                    // since we can't divide 301 by 3 and get a value less than curr, divide by 3 + 1
                    div++;
                    curr = nums[i] / div; 
                    // curr is now 301 / 4 = 75
                } // if
            } // if
        } // for
        return sol;
    } // minimumReplacement
} // Solution
