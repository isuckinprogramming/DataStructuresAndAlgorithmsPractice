package AdjacencyListPractice;

import GraphAndNodePractice.Node;
import java.util.LinkedList;

public class AdjacencyList extends LinkedList< LinkedList < Node > > {


    public void addNode(Node nodeToAdd){

        if( doesNodeExistInside(nodeToAdd) ){
            /*
            *
            * if the node to be added already exist,
            * no need to create a new linkedlist for the node
            *
            * */
            return;
        }
        offerLast(new LinkedList<Node>());

        getLast().add(nodeToAdd);
    }


    public boolean doesNodeExistInside(Node nodeToCheck){
        return doesNodeExistInside( nodeToCheck.getData() );
    }

    public boolean doesNodeExistInside( char dataToCheck ){

        for( LinkedList<Node> nodeContainer : this){

            if( nodeContainer.getFirst().getData() == dataToCheck ){
                return true;
            }
        }
        return false;
    }


    private LinkedList<Node> getNodeContainer(char nodeData){

        for(  LinkedList<Node> nodeContainerInside : this ){

            if (nodeContainerInside.getFirst().getData() == nodeData){

                return nodeContainerInside;
            }
        }
        //null will serve as the default value to return when there's no value to return
        return null;
    }


    public boolean checkEdge(char source, char destination){

        if( !doesNodeExistInside(source) ||
            !doesNodeExistInside(destination) ) {

            return false;
        }

        if( getNodeContainer(source) != null){

            return getNodeContainer(source).contains( new Node(destination) ) ;
        }

        return false;
    }


    public void addEdge( char nodeToAddRelations, char nodeToAdd){


        if( !doesNodeExistInside(nodeToAddRelations) ){
            return;
        }

        getNodeContainer(nodeToAddRelations).add( new Node( nodeToAdd ) );
    }

    public void printContents(){


        for(  LinkedList<Node> nodeContainer : this) {

            System.out.print(nodeContainer.getFirst().getData() + "  ");

            for (Node nodeInside : nodeContainer) {

                System.out.print(nodeInside.getData() + " -> ");
            }

            System.out.println();

        }
    }


}

