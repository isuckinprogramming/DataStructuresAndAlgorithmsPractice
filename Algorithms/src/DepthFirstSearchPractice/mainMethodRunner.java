package DepthFirstSearchPractice;

import GraphAndNodePractice.Graph;
import GraphAndNodePractice.Node;

public class mainMethodRunner {


    public static void main(String[] args) {

        testScenarioForDepthFirstSearch();

    }


    private static void testScenarioForDepthFirstSearch(){


        Graph testGraph = new Graph(4);

        testGraph.addNode(new Node('A') );
        testGraph.addNode(new Node('B') );
        testGraph.addNode(new Node('C') );
        testGraph.addNode(new Node('D') );

        testGraph.printContents();

        testGraph.addEdge('A', 'B');
        testGraph.addEdge('A', 'D');
        testGraph.addEdge('A', 'C');


        testGraph.addEdge('B', 'C');
        testGraph.addEdge('D', 'C');

        testGraph.printContents();

        DepthFirstSearchAlgorithms.DepthFirstSearch(0, testGraph );



    }


}
