package struct.stack;

/**
 * Created by yangyi on 2018/8/7.
 */
public class Stack {
    private int array[] = null;
    private static final int defaultSize = 10;
    private int modCount = 0;

    public Stack(){
        this(defaultSize);
    }

    public Stack(int capitalSize){
        array = new int[capitalSize];
    }

    public void push(int item){
        array[modCount++] = item;
    }

    public int pop(){
        return array[modCount--];
    }
}
