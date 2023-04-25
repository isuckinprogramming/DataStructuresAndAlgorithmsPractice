package DepthFirstSearchPractice;

import GraphAndNodePractice.Graph;

public class DepthFirstSearchAlgorithms {


    public static void DepthFirstSearch(int valueToFind, Graph graphToSearch)  {


        boolean[] visitedNodes = new boolean[graphToSearch.getMatrixSize()];

        dfsHelper( valueToFind, visitedNodes, graphToSearch );
    }

    private static void dfsHelper( int valueToFind, boolean[] visitedNodes, Graph graphToSearchInside){

        if(visitedNodes[valueToFind]){

            return;
        }

        visitedNodes[valueToFind] = true;

        System.out.println(
        graphToSearchInside.getNodesContainer()[valueToFind] + " = visited "
        );

//
//        int iterationCount = 0;
//
//        for( int[] nodeDataContainer : graphToSearchInside.getMatrix()   ){
//
//            if ( graphToSearchInside.getMatrix()[source][iterationCount] == 1){
//
//                dfsHelper(source, visitedNodes, graphToSearchInside);
//            }
//            iterationCount++;
//        }

        /*
        * in recursion, WHEN PASSING VARIABLES, NEVER PASS VARIABLES
        * WHOSE VALUE IS CONSTANT THROUGHOUT RUNTIME.
        *
        *ALWAYS HAVE A CHANGE INSIDE OF THE VARIABLES YOU ARE PASSING,
        * OR PASS BY VALUE INSTEAD OF REFERENCE, NOT A CONSTANT VALUE, BUT A VALUE THAT
        * CHANGES OVER THE PROCESS.
        *
        * ELSE THE CODE STOPS AT THE BASE
        * CASE WITHOUT FILLING IT'S PURPOSE
        *
        * */

        for (
            int iterationCount = 0;
            iterationCount < graphToSearchInside.getMatrix()[valueToFind].length;
            iterationCount++
        ) {

            if( graphToSearchInside.getMatrix()[valueToFind][iterationCount] != 1 ){
                continue;
            }

            dfsHelper(iterationCount , visitedNodes , graphToSearchInside);
        }
    }

}
