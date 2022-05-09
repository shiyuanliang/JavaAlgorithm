package TreeDP;

/**
 * @author LiangShiyuan
 * @create 2022-05-09 11:13
 */
public class MaxDisTreeTest {

    public  static  class  Node {
        public int value;
        public  Node left;
        public  Node right;


        public  Node(int data){
            this.value = data;
        }
    }

    public  static int maxDistance(Node head){
        return process(head).maxDistance;
    }


    public  static  class  Info{
        public  int maxDistance;
        public  int height;
        public  Info(int dis, int h){
            maxDistance = dis;
            height = h;
        }
    }

    //返回以X为头的整棵树的两个信息
    public  static  Info process(Node x){
        if(x==null){
            return new Info(0,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        //处理信息
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height +1+rightInfo.height;
        int maxDistance = Math.max(p3,Math.max(p1,p2));
        int height = Math.max(leftInfo.height,rightInfo.height)+1;
        return  new Info(maxDistance,height);
    }
}
