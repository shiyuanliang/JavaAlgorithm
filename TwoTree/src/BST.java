import java.util.Stack;

public class BST {
    public static void main(String[] args) {

    }

    class TwoTree{
        int val;
        TwoTree left;
        TwoTree right;
    }

    public  static int pre = Integer.MIN_VALUE;

    public  static  boolean isBST(TwoTree head){
        if(head == null){
            return  false;
        }
        boolean leftIsBst = isBST(head.left);
        if(!leftIsBst){
            return  false;
        }
        if(head.val<=pre){
            return false;
        }else{
            pre = head.val;
        }
        return  isBST(head.right);
    }

    public  static  boolean isBSTUncur(TwoTree head){
        if(head == null){
            return true;
        }
        int pre = Integer.MIN_VALUE;
        Stack<TwoTree> stack = new Stack<TwoTree>();
        while(!stack.isEmpty() || head !=null){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                if(head.val<=pre){
                    return  false;
                }else {
                    pre = head.val;
                }
                head = head.right;
            }
        }
        return  true;
    }
}
