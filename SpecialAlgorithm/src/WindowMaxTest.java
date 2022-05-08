import java.util.LinkedList;

/**
 * @author LiangShiyuan
 * @create 2022-05-08 14:23
 */
public class WindowMaxTest {


    public  static  class WindowMax{//形成window的类  可以直接调用
        private  int L;
        private  int R;
        private  int[] arr;
        private LinkedList<Integer> qmax;

        public  WindowMax(int[] a){
            arr = a;
            L = -1;
            R = 0;
            qmax = new LinkedList<>();
        }
        public  void addNumFromRight(){//窗口的右边界向右移
            if(R==arr.length){
                return;
            }
            while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[R]){
                qmax.pollLast();
            }

            qmax.addLast(R);
            R++;
        }
        public  void removeNumFromLeft(){
            if(L>=R-1){
                return;
            }
            L++;
            if(qmax.peekFirst()==L){
                qmax.pollFirst(); //只需要判断头部是不是还有L  如果没有就证明早就弹出来了  最大值一定不会是弹出来的那个值
            }
        }

        public  Integer getMax(){
            if(!qmax.isEmpty()){
                return  arr[qmax.pollFirst()];
            }
            return  null;
        }
    }

    public  static  int[] getMaxWindow(int[] arr,int w){//没有使用上述类直接编解决固定窗口的问题
        if(arr==null||w<1||arr.length<w){
            return  null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for(int i= 0;i<arr.length;i++){//窗口R
            while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekLast() == i-w){//表示左边界过期了
                qmax.pollFirst();
            }
            if(i>=w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return  res;
    }
}
