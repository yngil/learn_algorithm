package struct.tree;

import java.util.Comparator;

/**
 * Created by yangyi on 2018/9/25.
 */
public class BinarySearchTree<T> {

    private Node<T> root;

    public void presort(Node<T> node){
        if(node==null) return;
        System.out.printf("%d \t",node.key);
        presort(node.left);
        presort(node.right);
    }

    public void midsort(Node<T> node){
        if(node==null) return;
        midsort(node.left);
        System.out.printf("%d \t",node.key);
        midsort(node.right);
    }

    public void postsort(Node<T> node){
        if(node==null) return;
        postsort(node.right);
        System.out.printf("%d \t",node.key);
        postsort(node.left);
    }

    public void insert(T value) {
        insert(root, new Node<T>(value, null, null, null));
    }

    private void insert(Node<T> m, Node<T> node) {
        Node<T> x = m;
        Node<T> y = null;
        if (node == null) {
            return;
        }
        while (x != null) {
            y = x;
            if (compare(x.key, node.key) > 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if(root==null){
            root = node;
        }
        if(y!=null) {
            if (compare(y.key, node.key) > 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        }
    }

    public Node<T> search(T key){
        Node<T> x = root;
        while(x!=null){
            if(compare(x.key,key)==0){
                return x;
            } else if (compare(x.key, key) > 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }

    public Node<T> max(Node<T> node){
        Node<T> x = node;
        Node<T> y = null;
        while(x!=null){
            y = x;
            x = x.right;
        }
        return y;
    }

    public Node<T> min(Node<T> node){
        Node<T> x = node;
        Node<T> y = null;
        while(x!=null){
            y = x;
            x = x.left;
        }
        return y;
    }

    /**
     * 前驱是小于该节点的最大子节点
     * @param node
     * @return
     */
    public Node<T> predecessor(Node<T> node){
        if(node.left != null) {
            return max(node.left);
        }
        //如果不存在左子节点,那么查找最近公共父节点
        Node<T> x = node;
        Node<T> y = null;
        while(x.parent!=null&&x.parent.left==x){
            y = x.parent.left;
            x = x.parent;
        }
        return y;
    }

    /**
     * 前驱是大于该节点的最小子节点
     * @param node
     * @return
     */
    public Node<T> successor(Node<T> node){
        if(node.right != null) {
            return min(node.right);
        }
        //如果不存在左子节点,那么查找最近公共父节点
        Node<T> x = node;
        Node<T> y = null;
        while(x.parent!=null&&x.parent.right==x){
            y = x.parent.right;
            x = x.parent;
        }
        return y;
    }

    public void remove(Node<T> node){
        if(search(node.key)==null){
            return;
        }
        Node<T> y = null;
        if(node.left==null || node.right==null){
            y = node;
        }else{
            y = successor(node);
        }
        Node<T> x = null;
        if(y.left!=null){
            x = y.left;
        }else{
            x = y.right;
        }
        if(x!=null){
            x.parent = y.parent;
        }
        if (y.parent==null){
            root = x;
        } else if(y.parent.left==y){
            y.parent.left = x;
        }else{
            y.parent.right = x;
        }
        if(y!=node){
             node.key = y.key;
        }
    }

    public void display(Node<T> node,int deepth){
        if(node!=null){
            System.out.print(node.key+"\t");
            display(node.left,-1);
            display(node.right,-1);
        }
        if(deepth==0){
            System.out.println();
        }
    }


    protected int compare(T key1, T key2) {
        return ((Comparable) key1).compareTo(key2);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(2);
        bst.insert(0);
        System.out.printf("pre sort :");
        bst.presort(bst.root);
        System.out.println();
        System.out.printf("mid sort :");
        bst.midsort(bst.root);
        System.out.println();
        System.out.printf("post sort :");
        bst.postsort(bst.root);
//        bst.display(bst.root,0);
//        bst.remove(bst.root.right);
//        bst.display(bst.root,0);
//        Node<Integer> max = brt.max(brt.root);
//        Node<Integer> min = brt.min(brt.root);
//        if(max!=null) {
//            System.out.printf("maximum is %d\n", max.key);
//        }else{
//            System.out.println("maximun is none");
//        }
//        if(min!=null) {
//            System.out.printf("minimum is %d\n", min.key);
//        }else{
//            System.out.println("minimum is none");
//        }
//        Node<Integer> predecessor =  brt.predecessor(brt.root.left);
//        System.out.printf("predecessor is %d\n",predecessor.key);
//        Node<Integer> successor =  brt.successor(brt.root.right);
//        System.out.printf("successor is %d\n",successor.key);
    }
}

class Node<T> {
    T key;
    Node<T> left;
    Node<T> right;
    Node<T> parent;

    public Node() {}

    public Node(T key, Node<T> left, Node<T> right, Node<T> parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

}
