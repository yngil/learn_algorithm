package algorithm.solution;

/**
 * Created by yangyi on 2018/9/11.
 */
public class ZeroOnePackage {
    private static int totalItemSize = 5;
    private static int totalWeight = 6;
    private int w[] = new int[totalWeight+1];
    private int v[] = new int[totalItemSize+1];
    private static int c[][] = new int[totalItemSize+1][totalWeight+1];
    private static int maxTotalAmount = 0;

//         水(重3磅，价值10);
//         书(重1磅，价值3)
//         食物(重2磅，价值9);
//         夹克(重2磅，价值5);
//         相机(重1磅，价值6)。
    public void init(){
        w[1] = 3;
        v[1] = 10;
        w[2] = 1;
        v[2] = 3;
        w[3] = 2;
        v[3] = 9;
        w[4] = 2;
        v[4] = 9;
        w[5] = 1;
        v[5] = 6;
    }

    /**
     * w[i] > j   c[i-1][j]
     * w[i] <= j  max{ c[i-1][j-w(i)]+v[i] | c[i-1][j] }
     */
    public void calculate(){
        for(int i=1;i<=totalItemSize;i++){
            for(int j=1;j<=totalWeight;j++){
                if(w[i]>j){
                    c[i][j] = c[i-1][j];
                }else{
                    if(c[i-1][j-w[i]]+v[i]>c[i-1][j]){
                        c[i][j] = c[i-1][j-w[i]]+v[i];
                    }else{
                        c[i][j] = c[i-1][j];
                    }
                }
                if(c[i][j]>maxTotalAmount){
                    maxTotalAmount = c[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroOnePackage solution = new ZeroOnePackage();
        solution.init();
        solution.calculate();
        for(int i=1;i<=totalItemSize;i++){
            for(int j=1;j<=totalWeight;j++){
                if(c[i][j]>0) {
                    System.out.printf("%d %d %d\n",i,j,c[i][j]);
                }
            }
        }
        System.out.printf("max_total_amount:%d\n",maxTotalAmount);
    }
}
