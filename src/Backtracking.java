import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Backtracking {

    public static void main(String[] args) {



    }

    //Subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> curr=new ArrayList<>();
        backtrack(0,curr,ans,nums);
        return ans;
    }
    public void backtrack(int index,List<Integer> curr ,List<List<Integer>> ans,int[] nums) {
        if (index==nums.length) {
            //System.out.println(curr);
            ans.add(new ArrayList<>(curr));
            return;
        }
        backtrack(index+1,curr,ans,nums);
        curr.add(nums[index]);
        backtrack(index+1,curr,ans,nums);
        //System.out.println(curr);
        curr.remove(curr.size()-1);
    }

    //Permutations
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        HashMap<Integer,Boolean> contains = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            contains.put(nums[i], false);
        }
        backtrackP(curr,ans,nums,contains);
        return ans;

    }
    public void backtrackP(List<Integer> curr,List<List<Integer>> ans,int[]nums, HashMap<Integer,Boolean>contains){

        if(curr.size()==nums.length) ans.add(new ArrayList<>(curr));
        //System.out.println(curr);
        for(int i=0;i<nums.length;i++){

            if(!contains.get(nums[i])){
                curr.add(nums[i]);
                contains.replace(nums[i], true);
                backtrackP(curr, ans, nums, contains);
                curr.remove(curr.size()-1);
                contains.replace(nums[i],false);
            }
        }

    }

}

