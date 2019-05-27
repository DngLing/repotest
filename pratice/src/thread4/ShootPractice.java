package thread4;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 11:13 2019/5/25
 * @Modified By:
 */
public class ShootPractice {
    //参与打靶的全部士兵
    final Soldier[][] rank;
    //靶的个数
    final int N;
    //持续打靶的时间
    final int lasting;
    //是否打靶结束
    volatile boolean done = false;
    //用来指示下一轮打靶的是哪一排
    volatile int nextLine = 0;
    final CyclicBarrier shiftBarriar;
    final CyclicBarrier startBarriar;

    public ShootPractice(int N, int lasting, boolean done) {

        this.N = N;
        this.lasting = lasting;
        this.done = done;
    }

    static class  Soldier{
        private final int seqNo;

        public Soldier(int seqNo){
            this.seqNo = seqNo;
        }

        public void fire(){
            System.out.println("Soldier "+seqNo+ " fire");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Soldier-"+seqNo;
        }
    }
}
