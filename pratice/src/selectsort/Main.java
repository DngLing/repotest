package selectsort;

import java.util.Arrays;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 13:52 2019/5/20
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {2,1,4,3,5,6,7,9,8,0};
        for(int i = 0; i<a.length; i++){
            int min = a[i];
            for(int j = i+1 ; j<a.length;j++){
                if(a[i]<min){
                    int temp = a[i];
                    a[i] = min;
                    min = temp;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
