package bubblesort;

import java.util.Arrays;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 13:30 2019/5/20
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {1,3,5,6,4,2,5,9,7,0};
        boolean flag = true;
        for (int i=0 ;i<a.length&&flag;i++){
            for (int j = 0; j<a.length -i-1; j++ ){
                flag = false;
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
