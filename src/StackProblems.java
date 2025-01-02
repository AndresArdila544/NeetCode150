import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StackProblems {

    public static void main(String[] args) {
        StackProblems sta = new StackProblems();


        //Valid Parentheses
        //String s= "()";
        //System.out.println(sta.isValid(s));

        //Min Stack
        //MinStack ms = new MinStack();
        //ms.push(-2);
        //ms.push(0);
        //ms.push(-3);
        //System.out.println(ms.getMin());
        //ms.pop();
        //System.out.println(ms.top());
        //System.out.println(ms.getMin());

        //Evaluate Reverse Polish Notation
        //String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        //System.out.println(sta.evalRPN(tokens));

        //Generate Parentheses
        int n=3;
        System.out.println(sta.generateParenthesis(n));
    }
    //Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '{' || c == '[' || c == '(') {
                st.push(c);
            }else if(c == '}' || c == ']' || c == ')') {
                if(st.isEmpty()) {
                    return false;
                }
                char cp=st.pop();
                if(cp=='{'&&c!='}')return false;
                if(cp=='['&&c!=']')return false;
                if(cp=='('&&c!=')')return false;
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }

    //Min Stack
    static class MinStack {
        Stack<Integer> st;
        Stack<Integer> minS;
        int min;
        public MinStack() {
            st=new Stack<>();
            minS=new Stack<>();

        }

        public void push(int val) {
            st.push(val);
            if(minS.isEmpty()||val<=minS.peek()) minS.push(val);
        }

        public void pop() {
            if(st.isEmpty()) return;

            int top =st.pop();
            if(top==minS.peek()) minS.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return minS.peek();
        }
    }

    //Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0) return 0;
        Stack<Integer> st=new Stack<>();
        int a,b;
        for(String token : tokens) {
            if(token.equals("+")){
                b=st.pop();
                a=st.pop();
                st.push(a+b);
            }else if(token.equals("-")){
                b=st.pop();
                a=st.pop();
                st.push(a-b);
            }else if(token.equals("*")){
                b=st.pop();
                a=st.pop();
                st.push(a*b);
            }else if(token.equals("/")){
                b=st.pop();
                a=st.pop();
                st.push(a/b);
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();

    }


    public List<String> generateParenthesis(int n) {

        List<String> res=new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        backtrackGP(0,0,n,res,sb);

        return res;
    }

    public void backtrackGP(int open,int close,int n,List<String> res,StringBuilder sb) {
        if(open==close&&open==n){
            res.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append('(');
            backtrackGP(open+1,close,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            backtrackGP(open,close+1,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }



}
