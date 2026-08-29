class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anaMap = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            String keyCount = Arrays.toString(count);
            anaMap.putIfAbsent(keyCount, new ArrayList<>());
            anaMap.get(keyCount).add(s);
        }
        return new ArrayList<>(anaMap.values());
    }
}
