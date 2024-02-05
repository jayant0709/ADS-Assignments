package ADS;

import com.sun.source.tree.Tree;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int x){
        this.val=x;
        left=right=null;
    }
}
public class BST {
    public static void main(String[] args) {
        TreeNode root = null;
        root = r_insert(root, 5);
        root = r_insert(root, 8);
        root = r_insert(root, 4);
        root = r_insert(root, 2);
        root = r_insert(root, 3);
        display(root);
        System.out.println();
        if(search(root,5)){
            System.out.println("Found");
        }else {
            System.out.println("Not found");
        }
        root = delete(root,5);
        display(root);
        if(search(root,5)){
            System.out.println("Found");
        }else {
            System.out.println("Not found");
        }
    }

    static TreeNode insert(TreeNode root, int x) {
        TreeNode n = new TreeNode(x);
        TreeNode a = null;
        TreeNode b = root;

        if (root == null) {
            return n;
        } else {
            while (b != null) {
                a = b;
                if (b.val < x) {
                    b = b.right;
                } else if (b.val > x) {
                    b = b.left;
                }
            }
            if (a.val < x) {
                a.right = n;
            } else {
                a.left = n;
            }
        }
        return root;
    }

    static TreeNode r_insert(TreeNode root,int x){
        if(root==null){
            TreeNode n=new TreeNode(x);
            return n;
        }
        if(root.val>x){
            root.left=r_insert(root.left,x);
        }
        else if(root.val<x){
            root.right=r_insert(root.right,x);
        }
        return root;
    }

    static TreeNode delete(TreeNode root, int x){
        if(root==null){
            return null;
        }
        if(root.val<x){
            root.right=delete(root.right,x);
        }
        else if (root.val>x){
            root.left=delete(root.left,x);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            root.val=inorder_pre(root.left);
            root.left=delete(root.left,root.val);
        }
        return root;
    }

    static boolean search(TreeNode root, int val){
        if(root==null){
            return false;
        }
        if(root.val==val){
            return true;
        }
        if(root.val<val){
            return search(root.right,val);
        }
        if(root.val>val){
            return search(root.left,val);
        }
        return false;
    }

    private static int inorder_pre(TreeNode root) {
        while(root.right!=null){
            root=root.right;
        }
        return root.val;
    }

    static void display(TreeNode root) {
        if (root == null) {
            return;
        }
        display(root.left);
        System.out.println(root.val);
        display(root.right);
    }
}
