package algorithm.solution;

/**
 * Created by yangyi on 2018/8/7.
 */
public class PalindromeString {
    public boolean match(String str){
        int i = 0,j = str.length()-1;
        char array[] = str.toCharArray();
        for(;i<=j;i++,j--){
            if(array[i]!=array[j]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "ababa";
        PalindromeString instance = new PalindromeString();
        boolean bool = instance.match(str);
        System.out.printf("%s %s plaindrome ",str,(bool?"exists":"not exists"));
    }
}
