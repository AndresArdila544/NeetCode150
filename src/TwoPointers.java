import java.util.*;

public class TwoPointers {

    public static void main(String[] args) {

        //Valid Palindrome
        //String s = "race a car";
        //System.out.println(isPalindrome(s));

        //Two Sum II
        //int[] numbers= {-1,0,15};
        //int target=-1;
        //System.out.println(Arrays.toString(twoSum(numbers,target)));

        //3Sum
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));


    }

    //Valid Palindrome
    public static boolean isPalindrome(String s) {

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
    public static int[] twoSum(int[] numbers, int target) {

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
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            //twosum
            int target=0+nums[i];
            int a =0;
            int b = nums.length-1;
            System.out.println(target+" "+nums[i]);
            while(a<b){
                if(a==i)a++;
                if(b==i)b--;
                System.out.println(nums[a]+nums[b]);
                if(nums[a]+nums[b]>target){
                    b--;
                }else if(nums[a]+nums[b]<target){
                    a++;
                }
            }
            if(nums[a]+nums[b]==target){
                List<Integer> list = Arrays.asList(nums[a],nums[b],nums[i]);
                list.sort((x,y)->Integer.compare(x,y));
                if(!set.contains(list)){
                    set.add(list);
                    res.add(list);
                }
            }
        }
        return res;
    }


}
