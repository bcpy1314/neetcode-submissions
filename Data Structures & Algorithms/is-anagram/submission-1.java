class Solution {
    public boolean isAnagram(String s, String t) {
        // corner case check when two strings are different length
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }
        // build two maps of the strings and then check if char frequency are matching
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+ 1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
            if (tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tMap.get(t.charAt(i))+ 1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++){
            Integer freS = sMap.get(s.charAt(i));
            Integer freT = tMap.get(s.charAt(i));
            if (!Objects.equals(freS, freT)){
                return false;
            }
        }
        return true;

    }
}