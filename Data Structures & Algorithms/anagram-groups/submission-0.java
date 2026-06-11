class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // corner case, if the string array only have 1 or less charactor, return the list of that string

        // 1. traverse the array, build maps for each different elements
        // 2. compare if the frequency of the letter
        // 3. instead of using single letter as key, using a string array as a map key
        // the array size is 26, which contains a-z
        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) return result;
        if (strs.length == 1){
            List<String> sublist = new ArrayList<>();
            sublist.add(strs[0]);
            result.add(sublist);
            return result;
        }

        Map<String, List<String>> resultMap = new HashMap<>();
        for (String word: strs){
            int[] wordFrequency = mapFrequency(word);
            String key = Arrays.toString(wordFrequency);
            if (resultMap.containsKey(key)){
                resultMap.get(key).add (word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                resultMap.put(key, list);
            }
        }
        for (String key:resultMap.keySet()){
            result.add(resultMap.get(key));
        }
        return result;
    }

    public int[] mapFrequency(String word){
        int[] frequency = new int[26];
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) -'a';
            frequency[index]++;
        }
        return frequency;
    }
}