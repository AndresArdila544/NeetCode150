import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    public static void main(String[] args) {

        SlidingWindow sw = new SlidingWindow();

        //Best Time to Buy and Sell Stock
        //int[] prices = {7,1,5,3,6,4};
        //System.out.println(sw.maxProfit(prices));

        //Longest Substring Without Repeating Characters
        //String s = "pwwkew";
        //System.out.println(sw.lengthOfLongestSubstring(s));

        //Longest Repeating Character Replacement
        String s = "AABABBA";
        int k = 1;
        System.out.println(sw.characterReplacement(s, k));
    }

    //Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {

        int left = 0;
        //int ans = 0;
        int max=0;

        //int profit = right-left;

        for (int rignt = 0; rignt < prices.length; rignt++) {

            max=Math.max(prices[rignt]-prices[left],max);

            while(prices[left]>prices[rignt]){
                left++;
            }

        }



        return max;
    }

    //Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {

        Set<Character> st= new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            while(st.contains(s.charAt(right))){
                st.remove(s.charAt(left));
                left++;
            }

            st.add(s.charAt(right));
            max = Math.max(max,right-left+1);
        }


        return max;
    }

    //Longest Repeating Character Replacement
    public int characterReplacement(String s, int k) {

        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int right = 0; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            while((right-left+1)-map.values().stream().max(Integer::compare).get()>k){
                map.replace(s.charAt(left), map.getOrDefault(s.charAt(left), 0)-1);
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;


    }

    //Permutation in String
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        if(s1.equals(s2))return true;
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            freq.put(s1.charAt(i), freq.getOrDefault(s1.charAt(i), 0) + 1);
            freq2.put(s2.charAt(i), freq2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int match = 0;
        for (Character c : freq.keySet()) {
            if(freq.get(c).equals(freq2.getOrDefault(c, 0))){
                match++;
            }
        }

        int left = 0;
        for(int right = s1.length();right<s2.length();right++){
            if(match==freq.size())return true;
            char c = s2.charAt(right);
            freq2.put(c, freq2.getOrDefault(c,0)+1);
            if(freq.containsKey(c)){
                if(freq.get(c).equals(freq2.get(c))){
                    match++;
                }else if(freq.get(c)+1==freq2.get(c)){
                    match--;
                }
            }


            char c2 = s2.charAt(left);
            freq2.put(c2, freq2.get(c2)-1);
            if(freq.containsKey(c2)){
                if(freq.get(c2).equals(freq2.get(c2))){
                    match++;
                }else if(freq.get(c2)-1==freq2.get(c2)){
                    match--;
                }
            }
            left++;


        }

        return match==freq.size();

    }

}
