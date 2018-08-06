package struct.queue.v1;

/**
 * Created by yangyi on 2018/8/6.
 */
public class Queue {

    public static void main(String[] args) {
        int array[] = new int[102];
        int src[] = {6,3,1,7,5,8,9,2,4};
        System.arraycopy(src,0,array,0,src.length);
        int head = 0,tail = 9;
        while(head<tail){
            System.out.print(array[head]+"\t");
            head++;//出队
            array[tail] = array[head];
            tail++;
            head++;//继续出队
        }
    }

}
