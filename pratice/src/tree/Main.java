package tree;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 21:50 2019/5/20
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        BinarySortTree<Integer,String> tree = new BinarySortTree<Integer, String>();
        tree.put(2,"2号选手");
        tree.put(1,"1号选手");
        tree.put(9,"9号选手");
        tree.put(4,"4号选手");
        tree.put(5,"5号选手");
        tree.put(6,"6号选手");
        tree.put(4,"4号选手");
        tree.put(3,"3号选手");
        tree.put(7,"7号选手");
        tree.put(8,"8号选手");

        tree.inOrder();
    }
}
