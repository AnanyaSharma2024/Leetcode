import java.util.*;
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] last = new int[26];
        // Sabko -1 se initialize kar do
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        // Right se left jaakar first time jo mile wahi last occurrence hoga
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.charAt(i) - 'a';
            if (last[index] == -1) {
                last[index] = i;
            }
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // Current character ka last index
            end = Math.max(end, last[s.charAt(i) - 'a']);
            // Agar current index end ke equal aa gaya
            // to partition complete
            if (i == end) {
                list.add(end - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}