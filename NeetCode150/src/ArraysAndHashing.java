import java.util.*;

public class ArraysAndHashing {

    public static void main(String[] args) {
        ArraysAndHashing a = new ArraysAndHashing();

        //Contains Duplicate
        //int[] nums = {1,2,3,3};
        //System.out.println(a.hasDuplicate(nums));

        //Valid Anagram
        //String s = "racecar", t = "carrace";
        //System.out.println(a.isAnagram(s, t));

        //Two Sum
        //int[] nums = {3,4,5,6};
        //int target = 7;
        //System.out.println(a.twoSum(nums,target));

        //Group Anagrams
        //String[] strs = {"act","pots","tops","cat","stop","hat"};
        //System.out.println(a.groupAnagrams(strs));

        //Top K Frequent Elements
        //int[] nums = {1,2,2,3,3,3};
        //int k = 2;
        //System.out.println(Arrays.toString(a.topKFrequent(nums, k)));

        //Encode and Decode Strings
        //System.out.println(a.encode(new ArrayList<>(List.of(new String[]{"neet", "code", "love", "you"}))));
        //System.out.println(a.decode(a.encode(new ArrayList<>(List.of(new String[]{"neet", "code", "love", "you"})))));

        //Products of Array Except Self
        //int[] nums = {1,2,4,6};
        //System.out.println(a.productExceptSelf(nums));

        //Valid Sudoku
        /*char[][] board = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}};*/
        //System.out.println(a.isValidSudoku(board));

        //Longest Consecutive Sequence
        //int[] nums={2,20,4,10,3,4,};
        //System.out.println(a.longestConsecutive(nums));
    }

    //Contains Duplicate
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(Integer i:nums){
            if(hs.contains(i))return true;
            hs.add(i);
        }
        return false;

    }

    //Valid Anagram
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        for(int i=0;i<s1.length;i++){

            if(s1[i]!=t1[i])return false;
        }
        return true;


    }

    //Two Sum
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hm = new HashMap();


        int[] ans =new int[2];

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }


        for(int i=0;i<nums.length;i++){
            ans[0]=i;
            if(hm.containsKey(target-nums[i])&&hm.get(target-nums[i])!=i){
                ans[1]=hm.get(target-nums[i]);
                return ans;
            }
        }
        return ans;
    }

    //Group Anagrams
    public String sortChars(String s){
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> anagrams = new HashMap<>();

        for(String s:strs){
            String sorted = sortChars(s);
            if(!anagrams.containsKey(sorted)){
                List<String> temp = new ArrayList<>();
                temp.add(s);
                anagrams.put(sorted,temp);
            }else{
                List<String> temp = anagrams.get(sorted);
                temp.add(s);
                anagrams.replace(sorted,temp);
            }

        }

        return new ArrayList<>(anagrams.values());

    }

    //Top K Frequent Elements
    class Pair{
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Pair> map = new HashMap<>();

        for(int n:nums){
            if(map.containsKey(n)){
                map.replace(n,new Pair(n,map.get(n).value+1));
            }else{
                map.put(n,new Pair(n,1));
            }
        }

        List<Pair> pairs = map.values().stream().sorted((x,y)->Integer.compare(y.value,x.value)).toList();
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=pairs.get(i).key;
        }


        return ans;
    }

    //Encode and Decode Strings
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.isEmpty())return "";
        if(strs.size()==1)return strs.get(0)+"12044";
        for(String s:strs){

            sb.append(s);
            sb.append("12044");
        }
        return sb.toString();
    }
    public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();
        if(str.isEmpty())return ans;
        if(str.equals("12044")){
            ans.add("");
            return ans;
        };
        String[] sa = str.split("12044");
        ans = Arrays.stream(sa).toList();
        return ans;
    }

    //Products of Array Except Self
    public int[] productExceptSelf(int[] nums) {
        long value=1;
        boolean zero=false;
        boolean zero2=false;
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]==0){
                if(zero){
                    zero2=true;
                }else{
                    zero=true;
                }
            }else{
                value*=nums[i];
            }
        }
        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; i++) {
            if(zero&&nums[i]!=0){

                ans[i]=0;
            }else{
                if(nums[i]==0&&!zero2){

                    ans[i]= (int) (value);
                }else{
                    if(zero2){

                        ans[i]=0;
                    }else{

                        ans[i]= (int) (value/nums[i]);
                    }

                }

            }
        }

        return ans;
    }

    //Valid Sudoku
    public boolean isValid(List<Character> characters){
        Set<Character> s = new HashSet<>(characters);
        return s.size()==characters.size();
    }
    public boolean isValidSudoku(char[][] board) {
        boolean ans = true;
        for (int i = 0; i < board.length; i++) {
            List<Character> rows=new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]!='.')rows.add(board[i][j]);
            }
            ans=ans&&isValid(rows);

        }
        //System.out.println(ans);
        for (int i = 0; i < board.length; i++) {
            List<Character> cols=new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                if(board[j][i]!='.')cols.add(board[j][i]);
            }
            ans=ans&&isValid(cols);

        }
        //System.out.println(ans);
        int row=0;
        int col=0;
        for (int k = 0; k < 9; k++) {
            List<Character> sq1=new ArrayList<>();
            row=(k*3)%9;
            for (int i = row; i < row+3; i++) {
                for (int j = col; j < col+3; j++) {
                    System.out.print(board[i][j]);
                    if(board[i][j]!='.')sq1.add(board[i][j]);
                }
                //System.out.println();
            }


            System.out.println(row);
            if(k==2)col=3;
            if(k==5)col=6;
            ans=ans&&isValid(sq1);
            //System.out.println(sq1);
            //System.out.println(ans);
        }
        return ans;

    }

    //Longest Consecutive Sequence
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int i = 0; i <nums.length; i++) {
            if(set.contains(nums[i])&&!set.contains(nums[i]-1)){
                int curr=0;
                for (int j = 0; j < nums.length; j++) {
                    if(set.contains(nums[i]+j)){
                        curr++;
                        max=Math.max(max,curr);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return max;
    }
}
