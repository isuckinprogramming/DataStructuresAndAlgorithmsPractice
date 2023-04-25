package GraphAndNodePractice;

public class Graph
{

    public Graph(int size)
    {

        matrix = new int[size][size];
        nodesContainer = new char[size];
    }

    private int[][] matrix;
    private char[] nodesContainer;
    private int locationToAddNode = 0;


    public char[] getNodesContainer(){

        return nodesContainer;
    }

    public int[][] getMatrix(){

        return matrix;
    }



    public void addNode(Node nodeToAdd){

        nodesContainer[locationToAddNode] = nodeToAdd.getData();
        locationToAddNode++;
    }

    public boolean hasEdgeInside(int source, int destination){

        return matrix[source][destination] == 1;
    }

    public boolean hasEdgeInside ( char source, char destination ){

        int srcLocation = findLocationOfNode(source);
        int dstLocation = findLocationOfNode(destination);

        if(srcLocation != -1 && dstLocation != -1) {
            return hasEdgeInside( srcLocation, dstLocation);
        }
        return false;
    }

    public boolean hasEdgeInside ( Node source, Node destination ){

        return hasEdgeInside( source.getData(), destination.getData() );
    }

    public int getMatrixSize() {
        return matrix.length;
    }


    private int findLocationOfNode( char nodeData){

        int location = 0;
        for ( char nodeInside : nodesContainer){

            if ( nodeData == nodeInside ){

                return location;
            }
            location++;
        }

        return -1;
    }

    public void addEdge( char NodeSource, char NodeDestination ){

        matrix[ findLocationOfNode( NodeSource ) ][ findLocationOfNode( NodeDestination ) ] = 1;
    }
    public void addEdge(int source, int destination){

        /*
        * add a node inside this location, 1 represents a node inside
        * the int value of 1 is a marker for a node inside of a matrix
        * */

        matrix[source][destination] = 1;
    }

    public void printContents()
    {

        int outLoopTimes = 0;
        int inLoopTimes = 0;


        System.out.print("\t");

        for(  char nodeData : nodesContainer) {
            System.out.print(nodeData);
        }
        System.out.println("\n");

        for( int[] dataContainer: matrix )
        {
            System.out.print( " "+ nodesContainer[outLoopTimes]+"  ");
            int dataCurrentPrint = 0;

            for(int data: dataContainer)
            {
                dataCurrentPrint++;

                System.out.print(
                    ( (inLoopTimes == (dataCurrentPrint + 1) ) ?  "-" : data)
                );
                inLoopTimes++;
            }

            //print a newline to enter something
            System.out.println();
            outLoopTimes++;
        }
    }

}
