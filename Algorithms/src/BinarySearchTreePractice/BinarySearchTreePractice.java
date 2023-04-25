package BinarySearchTreePractice;

import GraphAndNodePractice.Node;

import java.util.Scanner;

public class BinarySearchTreePractice {

    TreeNode rootNode;

    public void insertNode(TreeNode nodeToInsert){

        rootNode = helperForInsertNode(rootNode, nodeToInsert);
    }

    public TreeNode helperForInsertNode( TreeNode rootTreeNode, TreeNode nodeToAdd ){


        if( rootTreeNode == null ){

            /*
            * assign the value of the rootnode to be
            * the value of the node to be added,
            * since by default the value of the
            * root node is null or not assigned,
            *
            * in the case it is null, assign it a
            * value, the value will be the node to
            * be added
            *
            * */


            rootTreeNode = nodeToAdd;
            return rootTreeNode;
        }

        int rootNodeData = rootTreeNode.getData();
        int nodeToAddData = nodeToAdd.getData();


        if ( rootNodeData < nodeToAddData) {

            /*
            * pass the node to be added to the right node of the root node
            * , since it is greater in value
            * */
            rootTreeNode.setRightNode(
                helperForInsertNode( rootTreeNode.getRightNode(), nodeToAdd )
            );
        }
        else if ( rootNodeData > nodeToAddData ) {


            /*
             * pass the node to be added to the left node of the root node
             * , since it is smaller in value
             * */
            rootTreeNode.setLeftNode(
                helperForInsertNode( rootTreeNode.getLeftNode(), nodeToAdd )
            );
        }

        return rootTreeNode;
    }


    final int SMALL_TO_LARGE_DISPLAY = 1;

    final int REVERSE_ORDER_OF_DISPLAY = 2;


    public void display( ) {

        //I need the variable to be initialized before using it in a function
        int displayChoice = -1;

        System.out.println("Display for Tree Of Node: \n 1 = Small to Large Display \n 2 = Large to Small" );

        try {

            displayChoice = new Scanner(System.in).nextInt();

        } catch (Exception e){

            System.out.println("fuck you, run the program again and enter only the necessary shit.");

            e.printStackTrace();
        }

        helperForDisplay( rootNode, displayChoice);
    }

    private void helperForDisplay(TreeNode nodeToDisplay, int choiceOfDisplay){


        if (nodeToDisplay == null){
            return;
        }


        switch ( choiceOfDisplay ) {

            case SMALL_TO_LARGE_DISPLAY -> displayFromSmallestToLargestValue( nodeToDisplay, choiceOfDisplay );

            case REVERSE_ORDER_OF_DISPLAY -> displayFromLargestToSmallerValue( nodeToDisplay,choiceOfDisplay );

            default -> throw new IllegalStateException( "Unexpected value: " + choiceOfDisplay );
        }

    }

    private void displayFromSmallestToLargestValue( TreeNode node, int choiceOfDisplay ){

        helperForDisplay( node.getLeftNode(), choiceOfDisplay );

        System.out.println( node.getData() );

        helperForDisplay( node.getRightNode(), choiceOfDisplay );
    }

    private void displayFromLargestToSmallerValue( TreeNode node, int choiceOfDisplay ){

        helperForDisplay( node.getRightNode(), choiceOfDisplay );

        System.out.println( node.getData() );

        helperForDisplay( node.getLeftNode(), choiceOfDisplay );
    }


    public void searchForValueToFind(){

        System.out.println("ENTER A VALUE TO FIND: ");
        try{

            int valueToFind = new Scanner(System.in ).nextInt();

            if( search(valueToFind)){
                System.out.println("value exist inside the tree");
            } else {
                System.out.println("value exist inside the tree");
            }

        } catch (Exception e){

            System.out.println("hahahhhahahahaha fuck you");

            e.printStackTrace();
        }

    }



    public boolean search(int dataToSearch){

        return searchHelper( rootNode, dataToSearch);
    }


    /*
    *This function wiil be recursively called until the
    * base case is reached.
    *
    * As to why recursion is used instead of iteration,
    * I don't know how to implement a recursive structure
    * to an iterative structure.
    *
    * I want a function, a set of code to be repeatedly
    * implemented until a conclusion is reached, I still
    * don't understand it to the point that I can reverse
    * the application.
    *
    * Recursion works because the function has a defined
    * condition to stop and a condition to continue the
    * cycle of calling itself.
    *
    * As to why traversing a tree of nodes needs a
    * recursive algorithm, or why am I using a
    * recursive approach, I don't fucking know
    *
    * I just copied this shit straight from a
    * tutorial, I don't even get how this would be
    * applcable to any sort of code that I write.
    *
    *
    * */
    public boolean searchHelper(TreeNode rootNodeToSearch, int dataToSearch){

        if( rootNodeToSearch == null ){
            //return false directly since node has no value
            return false;
        }


        int rootData = rootNodeToSearch.getData();

        if ( rootData == dataToSearch ){

            //found the data, meaning it exist inside of the node tree
            return true;
        }
        else if ( rootData < dataToSearch ){

            return searchHelper( rootNodeToSearch.getLeftNode(), dataToSearch );
        }
        else {

            return searchHelper( rootNodeToSearch.getRightNode(), dataToSearch );
        }

    }


    public void remove(int dataToRemove){

        if( !search( dataToRemove)  ){
            //nothing to remove if the data does not exist inside the tree of nodes

            System.out.println(
            "hahahahahhaha could not find what the fuck your looking for\n"
            + "why do you think I can remove something that does not exist in\n"
            + "the first place?????? "
            );
            return;
        }

        removeHelper( rootNode, dataToRemove );
    }

    public TreeNode removeHelper( TreeNode rootToRemove, int dataToRemove ) {


        if( rootToRemove == null ) {

            //the base case, stop all the looping
            return rootToRemove;
        }


        int rootData = rootToRemove.getData();

        if (rootData == dataToRemove ){

            if( rootToRemove.isBothLeftAndRightNodesNull() ){

                rootToRemove = null;
            }
            else if ( !rootToRemove.isRightNodeNull() ){

                rootToRemove.setNumberToHold( findSuccessor( rootToRemove ) );

                TreeNode rightNewValue = removeHelper( rootToRemove.getRightNode(), rootToRemove.getData() );

                rootToRemove.setRightNode( rightNewValue );
            }
            else if ( !rootToRemove.isLeftNodeNull() ) {

                rootToRemove.setNumberToHold( findPredessor( rootToRemove ) );

                TreeNode leftNewValue = removeHelper( rootToRemove.getLeftNode(), rootToRemove.getData() );

                rootToRemove.setLeftNode( leftNewValue );
            }

        }
        else if( rootData > dataToRemove ) {

            rootToRemove.setLeftNode( removeHelper( rootToRemove.getLeftNode(), dataToRemove ) );

        } else {

            rootToRemove.setRightNode( removeHelper( rootToRemove.getRightNode(), dataToRemove ) );
        }

        return rootToRemove;
    }




    /*
    * The find successor method aims to find teh least value
    * of the right child of the root to remove
    *
    * */
    private int findSuccessor(TreeNode rootNode ){

        rootNode = rootNode.getRightNode();

        while( !rootNode.isLeftNodeNull() ){

            rootNode = rootNode.getLeftNode();
        }


        return rootNode.getData();
    }

    private int findPredessor(TreeNode rootNode ){

        rootNode = rootNode.getLeftNode();


        while( !rootNode.isRightNodeNull() ){

            rootNode = rootNode.getRightNode();
        }

        return rootNode.getData();
    }

}
