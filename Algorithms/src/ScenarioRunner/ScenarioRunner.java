package ScenarioRunner;

import BinarySearchTreePractice.TreeNode;
import BinarySearchTreePractice.BinarySearchTreePractice;

import DepthFirstSearchPractice.DepthFirstSearchAlgorithms;

import GraphAndNodePractice.Graph;
import GraphAndNodePractice.Node;

import LevelSearchAlgorithmPractice.BreadthFirstSearch;

import java.util.Scanner;

public class ScenarioRunner {

    public static void main(String[] args) {

        BinarySearchTreeTestScenario();
    }

    private static void BinarySearchTreeTestScenario(){

        BinarySearchTreePractice testingBinaryTree = new BinarySearchTreePractice();


        long startTime = System.nanoTime();

        for(int i = 0; i < 12123; i++){

            testingBinaryTree.insertNode( new TreeNode(i * i));

        }

        long finishTime = ( System.nanoTime() - startTime );

        System.out.println(
        "time it took to add all contents: " + finishTime + " nanoseconds "
        );

        testingBinaryTree.display();

        testingBinaryTree.display();

        testingBinaryTree.searchForValueToFind();

    }

    private static void BreadthFirstSearchTestScenario( ) {


        Graph graph = new Graph(4);

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));

        graph.addEdge('B', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'A');
        graph.addEdge('B', 'B');

        graph.addEdge('D', 'C');
        graph.addEdge('D', 'A');
        graph.addEdge('D', 'B');


        graph.printContents();

        BreadthFirstSearch.breadthFirstSearch(3 , graph);
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


    private static void graphTestScenario() {

        Graph graphToTest = new Graph(4);

        graphToTest.addNode(new Node('A'));
        graphToTest.addNode(new Node('B'));
        graphToTest.addNode(new Node('C'));
        graphToTest.addNode(new Node('D'));

        graphToTest.addEdge('A', 'B');
        graphToTest.addEdge('A', 'D');
        graphToTest.addEdge('A', 'C');

        graphToTest.addEdge('B', 'C');
        graphToTest.addEdge('B', 'D');

        graphToTest.addEdge('C', 'D');


        graphToTest.printContents();


        System.out.println( graphToTest.hasEdgeInside('B','D'));

    }




}
