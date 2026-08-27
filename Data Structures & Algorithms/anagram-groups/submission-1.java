class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use array to represent the frequency of the string
        // group the same frequency array

        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            int[] freq = new int[26];
            for (int i = 0; i < str.length(); i++){
                freq[str.charAt(i) - 'a'] ++;
            }
            String key = Arrays.toString(freq);
            if (map.containsKey(key)){
                map.get(key).add(str);
            } else {
                List<String> solution = new ArrayList<>();
                solution.add(str);
                map.put(key, solution);
            }

        }
        return new ArrayList<>(map.values());
    }
}
