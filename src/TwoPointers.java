import java.util.*;

public class TwoPointers {

    public static void main(String[] args) {
        TwoPointers t = new TwoPointers();
        //Valid Palindrome
        //String s = "race a car";
        //System.out.println(t.isPalindrome(s));

        //Two Sum II
        //int[] numbers= {-1,0,15};
        //int target=-1;
        //System.out.println(Arrays.toString(t.twoSum(numbers,target)));

        //3Sum
        //int[] nums = {-2,0,1,1,2};
        //System.out.println(t.threeSum(nums));

        //Container With Most Water
        //int[] heights = {1,7,2,5,4,7,3,6};
        //System.out.println(t.maxArea(heights));

        //Trapping Rain Water
        //int[] height = {5,4,1,2};
        //System.out.println(t.trap(height));
    }

    //Valid Palindrome
    public boolean isPalindrome(String s) {

        char[] chars = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        int start = 0, end = chars.length-1;
        while(start < end) {
            if(chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //Two Sum II
    public int[] twoSum(int[] numbers, int target) {

        int a=0;
        int b=numbers.length-1;

        while(numbers[a]+numbers[b]!=target){
            if(numbers[a]+numbers[b]>target){
                b--;
            }else if(numbers[a]+numbers[b]<target){
                a++;
            }
        }

        return new int[]{a+1,b+1};
    }

    //3Sum
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //twosum
            int a =i+1;
            int b = nums.length-1;
            while(a<b){
                int sum = nums[i]+nums[a]+nums[b];
                if(a==i)a++;
                if(b==i)b--;
                if(sum>0){
                    b--;
                }else if(sum<0){
                    a++;
                }else{
                    List<Integer> list = Arrays.asList(nums[a],nums[b],nums[i]);
                    res.add(list);
                    a++;
                    b--;
                    while(a<b&&nums[a]==nums[a-1]){
                        a++;
                    }
                }
            }
        }
        return res;
    }

    //Container With Most Water
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;
        int max = 0;
        while (left < right) {
            int h = (right-left) *Math.min(heights[left], heights[right]);
            max = Math.max(max, h);
            if (heights[left] < heights[right]) {
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    //Trapping Rain Water
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxL=height[0];
        int maxR=height[height.length-1];

        int sum=0;
        while (left < right) {

            if(maxL<maxR){
                left++;
                maxL = Math.max(maxL, height[left]);
                int w = Math.min(maxR,maxL)-height[left];
                if(w>0)sum+=w;
            }else{
                right--;
                maxR = Math.max(maxR, height[right]);
                int w = Math.min(maxR,maxL)-height[right];
                if(w>0)sum+=w;

            }
        }

        return sum;
    }
}
