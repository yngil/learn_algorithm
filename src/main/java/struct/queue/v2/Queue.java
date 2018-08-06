package struct.queue.v2;

/**
 * Created by yangyi on 2018/8/6.
 */
public class Queue {
    private int head = 0;
    private int tail = 0;
    private int modCount = 0;
    private int array[];
    private int capitalSize;
    private static final int defaultSize = 10;


    public Queue(){
        this(defaultSize);
    }

    public Queue(int capitalSize){
        this.capitalSize = capitalSize;
        array = new int[capitalSize];
    }

    public void enqueue(int item){
        array[tail++] = item;
        modCount++;
    }

    public int dequeue(){
        modCount++;
        return array[head--];
    }

    public boolean isEmpty(){
        return head==tail;
    }

    public int peek(){
        return array[head];
    }

    public int pop(){
        return array[head--];
    }

    public void display(){
        for(int i=0;i<modCount;i++){
            System.out.printf(array[i]+"\t");
        }
    }

    public static void main(String[] args) {
        Queue instance = new Queue(102);
        int src[] = {6,3,1,7,5,8,9,2,4};
        for(int item : src){
            instance.enqueue(item);
        }
        while(instance.head<instance.tail){
            System.out.printf(instance.peek()+"\t");
            instance.head++;//出队
            instance.enqueue(instance.peek());
            instance.head++;//继续出队
        }
//        instance.display();
    }
}
