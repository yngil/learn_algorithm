package algorithm.solution;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by yangyi on 2018/8/31.
 */
public class ShortestRoute {

    private static final int n = 4;
    private int dist[] = new int[n];
    private int processed[] = new int[n];
    private int e[][] = new int[n][n];
    private int maxRoute = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ShortestRoute test = new ShortestRoute();
        test.fill();
        test.find();
        test.display();
    }

    public void find(){
        for(int i=0;i<n-1;i++){
            int u = 0;
            int min = maxRoute;
            //选择一个离源点最近的顶点加入到集合P
            for(int j=0;j<n;j++){
                if(processed[j]==0&&e[i][j]<min){
                    min = e[i][j];
                    u = j;
                }
            }
            processed[u] = 1;
            //存在一条u到v的边，通过u->v添加到尾部来拓展一条从s到v的路径，这条路径的长度是dis[u]+e[u][v]
            for(int v=0;v<n;v++){
                if(e[u][v]<maxRoute){
                    dist[v] = dist[u]+e[u][v];
                }
            }
        }
    }


    public void fill(){
        //源点到自己为0,其余点为最大路径
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    e[i][j] = 0;
                }else{
                    e[i][j] = maxRoute;
                }
            }
        }
        e[0][1] = 6;
        e[0][2] = 2;
        e[1][3] = 1;
        e[2][1] = 3;
        e[2][3] = 5;
        //源点为已知Q集合
        processed[0] = 1;
        //若存在源点到顶点,则设置顶点距离
        for(int i=0;i<n;i++){
            if(e[0][i]<maxRoute) {
                dist[i] = e[0][i];
            }
        }

    }

    public void display(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                    if(e[i][j]<maxRoute&&e[i][j]>0) {
                        System.out.printf("%d %d %d\n", i, j, e[i][j]);
                    }
            }
        }
        System.out.println("########################");
        for(int i=0;i<n;i++){
            System.out.printf("%d %d %d\n",0,i,dist[i]);
        }
    }

}
