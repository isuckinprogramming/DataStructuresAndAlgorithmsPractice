package AdjacencyListPractice;


import GraphAndNodePractice.Node;

public class mainRunner {

    public static void main(String[] args) {

        testScenario();
    }

    private static void testScenario(){

        AdjacencyList adjacentGraph = new AdjacencyList();

        adjacentGraph.addNode( new Node('A'));
        adjacentGraph.addNode( new Node('B'));
        adjacentGraph.addNode( new Node('C'));
        adjacentGraph.addNode( new Node('D'));

        adjacentGraph.printContents();

        adjacentGraph.addEdge( 'A','B' );

        adjacentGraph.printContents();
    }



}
