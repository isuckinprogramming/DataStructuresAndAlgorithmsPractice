package SearchingAlgorithmsPractice;

public class LinearSearchAlgorithm {



    /*
    * I used a generic type because I want the function to sort even the ones that are
    * not of type int. In this case I used a bounded generic to make sure that I'm only
    * getting a type of Integer, Double, or Long.
    *
    * The chances that someone, probably me will pass a variable of type String is
    * high. To make sure that I save myself the trouble of shooting myself, I used a
    * bounded generic.
    *
    * I just don't want to create an overloaded type of this method just to accept
    * different data types for holding numbers.
    *
    * I don't want to make a version of this function for long and double.
    *
    * Though the use of Reference type variables instead of Primitives is unusual or
    * weird, I mean I don't know how to use primitive data types with generics, much
    * less how using both could change the program.
    * */
    public static <T extends Number > int linearSearch( T[] arrayToSearchInside, T valueToFind ){

        int iteratorCount = 0;

        while( arrayToSearchInside.length > iteratorCount  ){

            //a fucking error appears if I use '==' or a '!=', I don't fukcing know why
            if( ! arrayToSearchInside[iteratorCount].equals( valueToFind ) ) {

                iteratorCount++;
                continue;
            }

            //return the index that represents the
            // location of the value to be searched for
            return iteratorCount;
        }

        //if the value is not found, -1 will serve as a sign for a negative result.
        return -1;
    }
}
