package LevelSearchAlgorithmPractice;

import GraphAndNodePractice.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {


    public static void breadthFirstSearch(int source , Graph graphToSearchInside){


        Queue<Integer> numQueue = new LinkedList<>();

        int[][] matrix = graphToSearchInside.getMatrix();

        boolean[] visited = new boolean[matrix.length];


        numQueue.offer(source);
        visited[source] = true;

        while( numQueue.size() != 0 ) {

            source = numQueue.poll();

            System.out.println(
                graphToSearchInside.getNodesContainer()[source] + " = VISITED"
            );


            for(
                int iterationCount = 0;
                iterationCount < matrix[source].length;
                iterationCount++
            ) {

                if ( matrix[source][iterationCount] == 1 &&
                    !visited[iterationCount] ) {

                    numQueue.offer(iterationCount);
                    visited[iterationCount] = true;

                }
            }
        }

    }

}
