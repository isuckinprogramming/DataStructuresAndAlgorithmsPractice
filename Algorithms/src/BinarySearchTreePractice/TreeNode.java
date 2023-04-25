package BinarySearchTreePractice;

import com.sun.source.tree.Tree;

public class TreeNode {

    private int data;

    private TreeNode rightNode;
    private TreeNode leftNode;


    public TreeNode getRightNode(){
        return rightNode;
    }

    public TreeNode getLeftNode(){
        return leftNode;
    }




    public TreeNode(int dataToHold){

        data = dataToHold;

    }


    public int getData(){

        return data;
    }

    public void setNumberToHold(int numberToHold){

        data = numberToHold;
    }

    public void setNumberToChildren(int numberToPass) throws Exception{

        if( numberToPass < data ) {

            rightNode = new TreeNode(numberToPass);
            return;
        }
        else if (numberToPass > data ) {

            leftNode = new TreeNode(numberToPass);
            return;
        }

        throw new Exception("cannot pass the same data inside to another tree");
    }

    public void setRightNode(TreeNode nodeForRight){

        rightNode = nodeForRight;
    }

    public void setLeftNode(TreeNode nodeForLeft) {

        leftNode = nodeForLeft;
    }

    public boolean isBothLeftAndRightNodesNull(){

        return this.leftNode == null && this.rightNode == null;
    }

    public boolean isLeftNodeNull(){

        return this.leftNode == null;
    }
    public boolean isRightNodeNull(){

        return this.rightNode == null;
    }
}
