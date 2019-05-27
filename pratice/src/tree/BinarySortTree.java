package tree;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 21:18 2019/5/20
 * @Modified By:
 */

/**
 * 两个泛型 其中 Key（或者其父类）要继承于Comparabale接口，使其可以进行比较
 * @param <Key>         键值对中的键
 * @param <Value>       键值对中的值
 */
public class BinarySortTree<Key extends Comparable<? super Key>,Value> {
    private Node root;

    /* 内部节点类 */
    private class Node{
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value val){
            this.key = key;
            this.val = val;
        }
    }

    //查找方法入口
    public Value get(Key key){
        if(key == null)
            throw new IllegalArgumentException("argument to get() is null");
        else
            get(root,key);
            return null;
    }

    //二分查找查找二叉树
    public Value get(Node p, Key key){
        while (p!=null){
            if(key.compareTo(p.key) == 0) // 查找键值与该点键值相等 返回该点值
                return p.val;
            else if (key.compareTo(p.key)<0) //查找键值小于该点键值 进入左子树
                p = p.left;
            else                        //查找键值大于该点键值 进入右子树
                p = p.right;
        }
        return null;    //查找失败，返回null
    }


    public boolean put(Key key, Value value){
        if(key == null || value == null)
            throw new IllegalArgumentException("argument to get() is null");
        if(root == null) {
            root = new Node(key, value);
        } else {
            /*声明根节点 和 父节点（一开始根节点没有父母节点，是个孤儿  ）*/
            Node p = root;
            Node parent = null;
            while (p!=null){
                parent = p; //记录最终插入节点的父节点
                if(key.compareTo(p.key) == 0) // 该键已存在 插入失败
                    return false;
                else if (key.compareTo(p.key)<0) //查找键值小于该点键值 进入左子树
                    p = p.left;
                else                        //查找键值大于该点键值 进入右子树
                    p = p.right;
            }
            /*确定最终位置,parent 节点将是新插入的节点的父节点*/
            /*接下来判读插到左孩子还是右孩子*/
            if(key.compareTo(parent.key) < 0)
                parent.left = new Node(key,value); //key<parent.key 插到左孩子
            else
                parent.right = new Node(key,value);//key>parent.key 插到右孩子
        }
        return true;
    }

    public void inOrder(){
        inOrder(root);
    }

    //中序遍历
    private void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.val.toString());
            inOrder(root.right);
        }
    }
}
