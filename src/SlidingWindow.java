import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    public static void main(String[] args) {

        SlidingWindow sw = new SlidingWindow();

        //Best Time to Buy and Sell Stock
        //int[] prices = {7,1,5,3,6,4};
        //System.out.println(sw.maxProfit(prices));

        //Longest Substring Without Repeating Characters
        String s = "pwwkew";
        System.out.println(sw.lengthOfLongestSubstring(s));

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



}
