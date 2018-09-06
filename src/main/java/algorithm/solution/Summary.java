package algorithm.solution;

/**
 * Created by yangyi on 2018/8/23.
 */
public class Summary {

    public int sum(int array[],int index,int depth){
        if(index>=depth-1)
            return array[index];
        return array[index]+sum(array,index+1,depth);
    }


    public static void main(String[] args) {
        int array[] = new int[]{2,4,6,10};
        Summary summary = new Summary();
        System.out.printf("sum=%d",summary.sum(array,0,array.length));
    }
}
