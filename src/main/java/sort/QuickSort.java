package sort;

/**
 * Created by yangyi on 2018/8/3.
 */
public class QuickSort {

    public void sort(int array[]){
        _sort(array,0,array.length-1);
    }

    /**
     *
     * @param array  7,1,3,6,2,9,4,8,5,10
     * @param left
     * @param right
     */
    private void _sort(int array[],int left,int right){
        if(left>right){
            return;
        }
        int k = array[left];
        int i = left,j = right;
        while(i<j){
            //从右向左找,比基数小的数
            while(array[j]>=k&&i<j){
                j--;
            }
            //从左向有找,比基数大的数
            while(array[i]<=k&&i<j){
                i++;
            }
            if(i<j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        // 左右相遇,交换基数
        if(i==j){
            array[left] = array[j];
            array[j] = k;
        }
        _sort(array,left,i-1);
        _sort(array,i+1,right);
    }

    public void display(int array[]){
        for(int item : array){
            System.out.printf(item+"\t");
        }
    }

    public static void main(String[] args) {
        int array[] = {7,1,3,6,2,9,4,8,5,10};
        QuickSort instance = new QuickSort();
        instance.sort(array);
        instance.display(array);
    }

}
