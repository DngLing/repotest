package shellsort;

import java.util.Arrays;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 14:15 2019/5/20
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {8,5,4,2,3,1,9,6,7,0};
        int gap = a.length;
        int temp;
        int k;
        while (gap>1){
            gap = gap/3 +1;
            for (int i=0;i<gap;i++){
                for (int j=i; j+gap<a.length;j++){
                    if(a[j]>a[j+gap]){
                        temp = a[j+gap];
                        k = j;
                        while (k>=0 && a[k]>temp){
                            a[k+gap] = a[k];
                            k -= gap;
                        }
                        a[k+gap] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
