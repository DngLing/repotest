package avltree;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 15:55 2019/5/21
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        ReadBlackTree<Integer,String> tree = new ReadBlackTree<>();
        MyRandom random = new MyRandom();
        tree.put(1,"1运动员");
        tree.put(2,"2运动员");
        tree.put(3,"3运动员");
        tree.put(4,"4运动员");
        tree.put(5,"5运动员");
        tree.put(6,"6运动员");
        tree.put(7,"7运动员");
        tree.put(8,"8运动员");
        tree.put(9,"9运动员");
        System.out.println(tree.size());
        System.out.println(tree.getHeight());
        tree.display();
    }
}
