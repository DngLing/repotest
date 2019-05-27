package avltree;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author： Dong
 * @Description:
 * @Date: Created in 13:51 2019/5/21
 * @Modified By:
 */
public class ReadBlackTree<Key extends Comparable<? super Key>,Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private boolean color;
        private Node left,right;
        private int size;

        public Node(Key key, Value val, boolean color, int size){
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    private boolean isRed(Node x){
        if (x == null)
            return false;
        return x.color == RED;
    }

    private int size(Node x){
        if (x == null)
            return  0;
        return x.size;
    }

    public int size(){
        return size(root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Value get(Key key){
        if(key == null)
            throw new IllegalArgumentException("键值为空");
        return get(root, key);
    }

    public Value get(Node p, Key key){
        while (p!= null){
            if(key.compareTo(p.key) == 0)
                return p.val;
            else if(key.compareTo(p.key)<0)
                p = p.left;
            else
                p = p.right;
        }
        return null;
    }

    //左旋子树 记该节点为h
    private Node rotateLeft(Node h){
        //选择右子树作为选择支点 记该节点为x
        Node x = h.right;
        //将x节点的左子树父节点指针指向h节点的右孩子
        h.right = x.left;
        //将h节点的父节点指针指向x节点的左孩子
        x.left = h;
        //将x节点的颜色改变为他左孩子的颜色
        x.color = x.left.color;
        //将x节点的左孩子改变为红色
        x.left.color = RED;
        //将原h节点的size 赋给 x节点
        x.size = h.size;
        //h节点的size等于他左节点的size加右节点的size
        h.size = size(h.left) + size(h.right) + 1;
        //将x返回
        return x;
    }

    //右旋子树 记该节点为h
     private Node rotateRight(Node h){
        //选择左子树作为旋转支点 记作x
        Node x = h.left;
        //将x的右孩子链接的h的左孩子指针上
        h.left = x.right;
        //将h的父节点指针链接到x的右孩子上
        x.right = h;
        //将x节点的颜色转换为他右孩子的颜色
        x.color = x.right.color;
        //将他右孩子转化为红色
        x.right.color =RED;
        //x赋予大小
        x.size = h.size;
        //h修改大小
        h.size = size(h.left) + size(h.right) + 1;
        //将x返回
        return x;
    }

    //变化颜色
    private void flipColors(Node h){
        //将对父节点的链接变色
        h.color = !h.color;
        //将对左孩子的链接变色
        h.left.color = !h.left.color;
        //将对右孩子的链接变色
        h.right.color = !h.right.color;
    }

    //对外暴露的put方法
    public void put(Key key, Value val){
        if(key == null || val ==null)
            throw new IllegalArgumentException("argument to put() is null");
        //将该类拥有的root根节点传入
        root = put(root, key, val);
        root.color = BLACK;
    }

    //递归的使用以保证递归返回时对每一层红黑树进行操作
    private Node put(Node h, Key key, Value val){
        //如果该节点为空（这里是从根节点开始），直接新建一个节点返回为root节点
        if(h==null){
            return new Node(key,val,RED,1);
        }
        //记录该节点的键值与查询的键值key 的比较结果值
        int cmp = key.compareTo(h.key);
        if(cmp<0)
            h.left = put(h.left,key,val);  //当插入节点键值小于该节点键值，向左孩子递归
        else if(cmp >0)
            h.right = put(h.right,key,val);//当插入节点键值大于该节点键值，向右孩子递归
        else h.val = val;                  //当插入节点键值等于该节点键值，覆盖该节点的值

        //当完成最后移除插入后，递归返回，并从最底开始整理红黑树结构
        //注意顺序
        if(isRed(h.right) && !isRed(h.left)) //当右孩子为红，左孩子不为红时 左旋
            h = rotateLeft(h);
        if(isRed(h.left)&&isRed(h.left.left))//当左孩子和左孩子的左孩子都为红，右旋
            h = rotateRight(h);
        if(isRed(h.left)&&isRed(h.right))//左右孩子都为红，反转该节点和左右孩子节点的颜色
            flipColors(h);
        h.size = size(h.right) + size(h.left) + 1;  //重新计算该节点下节点个数
        return h;
    }

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(Node p){
        if(p==null)
            return 0;
        else {
            int lh = getHeight(p.left);
            int rh = getHeight(p.right);
            return lh>rh?lh+1:rh+1;
        }
    }

    public void display(){
        display(root);
    }

    public void display(Node p){
        if (p != null){
            display(p.left);
            System.out.println(p.val);
            display(p.right);
        }
    }

}
