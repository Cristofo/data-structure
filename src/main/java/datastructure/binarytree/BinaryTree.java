package datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
        List<TreeNode> stackBinary = new ArrayList<>();
        TreeNode root =  new TreeNode();
        root.value = 4;
        TreeNode nodeB =  new TreeNode();
        nodeB.value = 5;
        TreeNode nodeC =  new TreeNode();
        nodeC.value = 6;
        root.leftN = nodeB;
        root.rightN = nodeC;
        TreeNode nodeD =  new TreeNode();
        nodeD.value = 7;
        TreeNode nodeE =  new TreeNode();
        nodeE.value = 8;
        nodeB.leftN = nodeD;
        nodeB.rightN = nodeE;
        TreeNode nodeF =  new TreeNode();
        nodeF.value = 9;
        nodeC.leftN = nodeF;

        printBinaryTree(root)
    }

    private static void printBinaryTree(TreeNode root){
        Stack<TreeNode> stackBinary = new Stack<>();
        //Stack<TreeNode> st2 = new Stack<>();
        stackBinary.push(root);

        while(!stackBinary.isEmpty()){
            root = stackBinary.pop();
            System.out.println(root.value);


            if(root.rightN != null) stackBinary.push(root.rightN);
            if(root.leftN != null) stackBinary.push(root.leftN);

        }
    }


    private static class TreeNode {
        TreeNode rightN;
        TreeNode leftN;
        int value;

        public TreeNode(){}

        public TreeNode(TreeNode rightN, TreeNode leftN, int value) {
            this.rightN = rightN;
            this.leftN = leftN;
            this.value = value;
        }
    }


}
