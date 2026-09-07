class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // nums = [1,1,1,2,2,100] , [1,2,2,3,3,3]
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] frequency = new List[nums.length+1];
        //create the empty array list in the each index of the list frequency
        for(int i =0; i<frequency.length; i++){
            frequency[i] = new ArrayList<>();
        }
        //add the occurence in the hashmap 
        // 1, 0+1=1 | 1+1=2 | 2+1=3
        // 2, 0+1=1 | 1+1=2
        // 100, 0+1=1
        for(int n : nums){
            count.put(n, count.getOrDefault(n,0)+1);
        }
        
        //add the hashmap keys into the arraylist of the frequency arraylist
        //[0->0, 1->100, 2->2, 3->1, 4->0, 5->0, 6->0]
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            frequency[entry.getValue()].add(entry.getKey());
        }

        // get the k frequent elements from the list and put into the result list 
        // [1,2]
        int[] res = new int[k];
        int index = 0;
        for(int i=frequency.length-1; i>0 && index < k ; i--){
            for(int n : frequency[i]){
                res[index++] = n;
                if(index == k){
                    return res;
                }
            }
        }
        return res;

    }
}
