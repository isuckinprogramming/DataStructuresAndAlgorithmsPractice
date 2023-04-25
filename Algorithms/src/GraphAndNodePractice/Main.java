package GraphAndNodePractice;

public class Main {
    public static void main(String[] args) {


        AlgorithmTestScenario();
    }



    private static void AlgorithmTestScenario(){

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