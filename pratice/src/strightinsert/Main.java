package strightinsert;

import java.util.Arrays;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 13:58 2019/5/20
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1,0};
        int[] b = new int[10];
        for (int i=0; i<a.length;i++){
            int temp = i;
            for (int j=i; j>0;j--){
                if(a[i]<b[j-1]){
                    b[j] = b[j-1];
                    temp = j-1;
                }else {
                    break;
                }
            }
            b[temp] = a[i];
        }

        System.out.println(Arrays.toString(b));
    }
}
