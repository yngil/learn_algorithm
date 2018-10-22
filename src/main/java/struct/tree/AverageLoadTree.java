package struct.tree;

/**
 * Created by yangyi on 2018/10/9.
 */
public class AverageLoadTree<T> extends BinarySearchTree<T>{
    protected AVLNode<T> tree;

    private AVLNode<T> leftToLeftRotation(AVLNode<T> k1){
        AVLNode<T> k2 = k1.left;
        k1.left = k2.right;
        k2.right = k1;
        k1.height = Math.max(height(k1.left),height(k1.right))+1;
        k2.height = Math.max(height(k2.left),height(k1))+1;
        return k2;
    }

    private AVLNode<T> rightToRightRotation(AVLNode<T> k1){
        AVLNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left),height(k1.right))+1;
        k2.height = Math.max(height(k1),height(k2.right))+1;
        return k2;
    }

    private AVLNode<T> rightToLeftRotation(AVLNode<T> k1){
        k1.right = leftToLeftRotation(k1.right);
        return rightToRightRotation(k1);
    }

    private AVLNode<T> leftToRightRotation(AVLNode<T> k1){
        k1.left = rightToRightRotation(k1.left);
        return leftToLeftRotation(k1);
    }

    public void insert(T key){
        tree = insert(tree,key);
    }

    protected AVLNode<T> insert(AVLNode<T> tree,T key){
        if(tree==null){
            tree = createNode(tree,key);
            return tree;
        }else if(compare(key,tree.key)<0){
            tree.left = insert(tree.left,key);
            if(lostBalance(tree.left,tree.right)){
                if(compare(key,tree.left.key)<0) {
                    tree = leftToLeftRotation(tree);
                }else{
                    tree = leftToRightRotation(tree);
                }
            }
        }else if(compare(key,tree.key)>0){
            tree.right = insert(tree.right,key);
            if(lostBalance(tree.left,tree.right)){
                if(compare(key,tree.right.key)>0) {
                    tree = rightToRightRotation(tree);
                }else{
                    tree = rightToLeftRotation(tree);
                }
            }
        }else{

        }
        tree.height = Math.max(height(tree.left),height(tree.right))+1;
        return tree;
    }

    public void delete(T key){
        delete(tree,key);
    }

    private AVLNode<T> delete(AVLNode<T> node,T key){
        if(compare(node.key,key)>0){
            node.left = delete(node.left,key);
        } else if(compare(node.key,key)<0){
            node.right = delete(node.right,key);
            if(lostBalance(node.left,node.right)){

            }
        } else{
            if(node.left!=null && node.right!=null){

            }else{
                node = node.left!=null?node.left:node.right;
            }
        }
        return node;
    }

    private AVLNode<T> createNode(AVLNode<T> node,T key){
        node = new AVLNode<T>(key,null,null,node);
        return node;
    }

    private int height(AVLNode<T> node){
        return node==null?-1:node.height;
    }

    private boolean lostBalance(AVLNode<T> left, AVLNode<T> right){
        return Math.abs(height(left)-height(right))==2;
    }

    public static void main(String[] args) {
        int array[] = {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
        AverageLoadTree<Integer> avlTree = new AverageLoadTree<Integer>();
        for(int num : array) {
            avlTree.insert(num);
        }
        avlTree.delete(5);
        avlTree.presort(avlTree.tree);
    }

    public void presort(AVLNode<T> node){
        if(node==null) return;
        System.out.printf("%d \t",node.key);
        presort(node.left);
        presort(node.right);
    }

    public void midsort(AVLNode<T> node){
        if(node==null) return;
        midsort(node.left);
        System.out.printf("%d \t",node.key);
        midsort(node.right);
    }

    public void postsort(AVLNode<T> node){
        if(node==null) return;
        postsort(node.right);
        System.out.printf("%d \t",node.key);
        postsort(node.left);
    }

}
class AVLNode<T> extends Node<T>{
    protected int height;
    protected AVLNode<T> left;
    protected AVLNode<T> right;
    protected AVLNode<T> parent;

    public AVLNode(T key, Node<T> left, Node<T> right, Node<T> parent){
        super(key, left, right, parent);
    }
}
