class Solution {
    public int[] productExceptSelf(int[] nums) {
     int n = nums.length;
     int[] res = new int[n];


     //iterate from the left to right the nums and get the res prerpared for the prefix
    int prefix = 1;
    for(int i=-1; i<n-1;i++){
        res[i+1] = prefix;
        prefix *= nums[i+1];
    }

    //iterate from the right to left the nums and get the res multiple by prefix and prerpare the res
        int postfix =1;
        for(int i =n-1;i>=0 ; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}  
