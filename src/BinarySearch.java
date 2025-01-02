import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        //Binary Search
        //int[] nums = {-1,0,2,4,6,8};
        //int target = 4;
        //System.out.println(bs.search(nums,target));

        //Search a 2D Matrix
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        //int target = 11;
        //System.out.println(bs.searchMatrix(matrix, target));

        //Koko Eating Bananas
        //int[] piles = {25,10,23,4};
        //int h = 4;
        //System.out.println(bs.minEatingSpeed(piles, h));

        //Find Minimum in Rotated Sorted Array
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(bs.findMin(nums));

    }


    //Binary Search
    public int search(int[] nums, int target) {
        int start = 0;
        int end=nums.length-1;

        while(start<=end){

            int mid = start+(end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;

    }

    //Search a 2D Matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        //if(matrix.length==1) return matrix[0][0]==target;
        //searchcol
        int start = 0;
        int end = matrix.length-1;
        int idx=-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            idx=mid;
            //System.out.println(matrix[mid][0]);
            if(target==matrix[mid][0]){
                return true;
            }
            if(matrix[mid][0]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        idx=end;
        System.out.println(idx);
        if(idx==-1)return false;
        //search row
        System.out.println(idx);
        start = 0;
        end=matrix[0].length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target==matrix[idx][mid]){
                return true;
            }
            if(target<matrix[idx][mid]){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;

    }

    //Koko Eating Bananas
    public int minEatingSpeed(int[] piles, int h) {
        int right = Arrays.stream(piles).max().getAsInt();
        int left =1;
        int ans = right;
        while(left<=right){

            int mid = left + (right-left)/2;
            long time = 0;
            for(int p:piles){
                time+=Math.ceil((double)p/mid);
            }
            if(time<=h){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;

    }

    //Find Minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
        int left = 0;;
        int right = nums.length-1;

        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<nums[right]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return nums[left];

    }


}
