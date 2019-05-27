package thread3;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 9:41 2019/5/25
 * @Modified By:
 */
public class Run {
    public static void main(String[] args) {
        //开始执行操作，每完成异常相应操作，执行一次countDown
        ServiceManager.startService();

        boolean allIsOK;

        //内部执行了 CountDownLatch.await()方法,会柱塞调用它的线程(该线程)，直到指定的count数变为0
        allIsOK = ServiceManager.checkServiceStatus();

        if(allIsOK)
            System.out.println("All Services were successfully started");
        else {
            System.out.println("Some Service(s) failed to start, exting JVM");
            System.exit(1);
        }
    }
}
