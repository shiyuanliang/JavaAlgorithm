public class classTwoTree {
    public static void main(String[] args) {

    }
    class TwoTree{
        int val;
        TwoTree left;
        TwoTree right;
    }
    public static TwoTree lowestAncestor(TwoTree head, TwoTree o1, TwoTree o2){
        if(head==null||head==o1||head==o2){
            return head;
        }
        TwoTree left  = lowestAncestor(head.left, o1, o2);
        TwoTree right  = lowestAncestor(head.right, o1, o2);
        if(left!=null && right!=null){
            return  head;
        }
        return  left !=null ? left : right;
    }


}
