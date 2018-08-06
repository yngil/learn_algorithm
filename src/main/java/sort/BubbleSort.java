package sort;

/**
 * Created by yangyi on 2018/8/6.
 */
public class BubbleSort {

    public void sort(int array[]){
        for(int i=0,n=array.length;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(array[j]>array[j+1]){
                    _swap(array,j,j+1);
                }
            }
        }
    }

    private void _swap(int array[],int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void display(int array[]){
        for(int item : array){
            System.out.printf(item+"\t");
        }
    }

    public static void main(String[] args) {
        int array[] = {7,1,3,6,2,9,4,8,5,10};
        BubbleSort instance = new BubbleSort();
        instance.sort(array);
        instance.display(array);
    }
}
