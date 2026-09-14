class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }

        int streak = 0;
        for(int num : numSet){
            if(!numSet.contains(num-1)){
                int length =1;
                while(numSet.contains(num+length)){
                    length++;
                }
                streak = Math.max(streak, length);
            }
        }
        return streak;
        
    }
}
