
import java.util.LinkedList;
import java.util.Queue;

public class CBT {

    public static void main(String[] args) {

    }
    class TwoTree{
        int val;
        TwoTree left;
        TwoTree right;
    }
    public   static  boolean isCBT(TwoTree head){
        int i = 0;
        if(head ==null){
            return  true;
        }
        boolean left = false;
        TwoTree r=null;
        TwoTree l = null;
        Queue<TwoTree>  queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            TwoTree node = queue.poll();
            r = node.right;
            l = node.left;
            //判断是否是完全二叉树
            if((r!=null&&l==null)
                || (left&&!(r==null&&l==null))){
                return  false;
            }
            if(r!=null){
                queue.add(r);
            }
            if(l!=null){
                queue.add(l);
            }

            if(r==null||(l == null)){
                left=true;
            }
        }
        return  true;
    }
}
