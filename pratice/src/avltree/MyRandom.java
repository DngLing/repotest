package avltree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 16:05 2019/5/21
 * @Modified By:
 */
public class MyRandom {

    public int getRandom(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }

    public int[] getRandoms(int min, int max, int count){
        int[] randoms = new int[count];
        List<Integer> listRandoms = new ArrayList<>();

        if (count>(max-min+1))
            return null;

        for (int i=min; i<max; i++)
            listRandoms.add(i);

        for (int i=0; i<count; i++){
            int index = getRandom(0,listRandoms.size()-1);
            randoms[i] = listRandoms.get(index);
            listRandoms.remove(index);
        }

        return randoms;
    }
}
