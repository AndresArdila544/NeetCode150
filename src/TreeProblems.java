import java.util.*;

public class TreeProblems {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    
    
    
    public static void main(String[] args) {
        TreeProblems tp = new TreeProblems();


        //Invert Binary Tree


    }

    //Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;

    }

    //Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //Diameter of Binary Tree
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 1;
        int ans=0;
        dfs(root,ans);
        return ans;
    }
    public int dfs(TreeNode root,int ans) {
        if(root == null) return 0;
        int left=dfs(root.left,ans);
        int right=dfs(root.right,ans);
        ans=Math.max(ans,left+right);
        return 1+Math.max(left,right);
    }
    class Pair{
        int height;
        int diameter;
        public Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    public int diameterOfBinaryTree2(TreeNode root) {

        Map<TreeNode,Pair> map = new HashMap<>();
        //map.put(null, new Pair(0,0));
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode top = stack.peek();

            if(top.left != null&&!map.containsKey(top.left)) {
                stack.push(top.left);
            } else if (top.right != null&&!map.containsKey(top.right)) {
                stack.push(top.right);
            }else{
                top = stack.pop();

                Pair left = map.get(top.left);
                Pair right = map.get(top.right);

                int height = 1 + Math.max(left.height, right.height) ;
                int diameter = Math.max(left.height+ right.height,Math.max(left.diameter, right.diameter));

                map.put(top,new Pair(height,diameter));
            }
        }
        return map.get(root).diameter;
    }

    ////Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int left=height(root.left);
        int right=height(root.right);
        int balance=Math.abs(left-right);
        if(balance>1)return false;
        return isBalanced(root.left)&&isBalanced(root.right);


    }
    public int height(TreeNode node){
        if(node==null)return 0;
        return 1+Math.max(height(node.left),height(node.right));
    }

    //Same Binary Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null&&q==null))return true;
        if((p==null||q==null)&&!(p==null&&q==null))return false;
        if(p.val!=q.val) return false;
        return true && isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    //Subtree of Another Tree
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null||subRoot==null)return false;

        if(dfs2(root,subRoot))return true;

        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    public boolean dfs2(TreeNode root, TreeNode subRoot){
        if(root==null&&subRoot==null)return true;
        if(root==null||subRoot==null)return false;
        if(root.val!=subRoot.val)return false;
        boolean left = dfs2(root.left,subRoot.left);
        boolean right = dfs2(root.right,subRoot.right);
        return left&&right;
    }


}
