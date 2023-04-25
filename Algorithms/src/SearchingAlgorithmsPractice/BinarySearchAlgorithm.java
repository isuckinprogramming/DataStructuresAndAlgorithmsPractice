package SearchingAlgorithmsPractice;

public class BinarySearchAlgorithm {



    /*
    * Binary search algorithm does not work well with unsorted data set.
    *
    * Works best when data inside is already sorted from smallest to highest.
    * with the highest data located in high index and the lower the data the
    * lower the index.
    *
    * I don't know how to reverse the binary search alogrithm, I can but it's too
    * much work for the effort. Just reversing the greater than and less than
    * operator should do the trick.
    *
    *
    * */


    private static final int NON_FLOATING_POINT_NUMBER = 0;
    private static final int FLOAT_NUMBER = 1;
    private static final int DOUBLE_NUMBER = 2;


    private static <T extends Number > boolean isDataTypeFloat( T[] array, T number ){

        return array instanceof Float[] ||
                number instanceof Float;
    }

    private static <T extends Number > boolean isDataTypeDouble( T[] array, T number ){

        return array instanceof Double[] ||
                number instanceof Double;
    }


    private static <T extends Number > int getOperationAccordingToDataType( T[] array, T number  ){

        if( ! (  isDataTypeFloat(array, number) ||
            isDataTypeDouble(array, number) )
        ) {

            return NON_FLOATING_POINT_NUMBER;
        }
        else if (isDataTypeDouble( array, number)){

            return DOUBLE_NUMBER;
        }
        else if ( isDataTypeFloat( array, number ) ) {

            return FLOAT_NUMBER;
        }

        return -1;
    }


    public static <T extends Number > int binarySearch( T[] arrayToSearch, T valueToFind ) {


        Integer lowIndex = 0;
        Integer highIndex = arrayToSearch.length - 1;
        Integer middleIndex;
        
        Integer iteratorCount = 0;

        int dataTypeToBeOperated = getOperationAccordingToDataType( arrayToSearch, valueToFind);


        while( lowIndex <= highIndex ){

            middleIndex =  lowIndex + (highIndex - lowIndex) / 2;
            T middleValue = arrayToSearch[middleIndex];

            System.out.println( "middle: " + middleValue );

            int locationOfData = switch (dataTypeToBeOperated) {

                case NON_FLOATING_POINT_NUMBER -> indexLocatorForNonFloatingPoint(
                    lowIndex, highIndex, middleIndex,
                    valueToFind, middleValue
                );
                case FLOAT_NUMBER -> indexLocatorForFloat(
                    lowIndex, highIndex, middleIndex,
                    valueToFind, middleValue
                );
                case DOUBLE_NUMBER ->  indexLocatorForDouble(
                    lowIndex, highIndex, middleIndex,
                    valueToFind, middleValue
                );
                default -> throw new IllegalArgumentException(
                    "Hmmmmm, I don't know what wrong happend"
                );

            };

            if (locationOfData != -1){
                return locationOfData;
            }

        }

        return -1;
    }


    private static <T extends Number > int indexLocatorForNonFloatingPoint(
        Integer lowIndex, Integer highIndex, Integer midIndex, T numberToFind, T numberToCompareTo
    ){
        if ( numberToFind.longValue() == numberToCompareTo.longValue() ){

            return midIndex;
        }

        if (numberToCompareTo.longValue() > numberToFind.longValue()){

            highIndex = midIndex - 1;
        }
        else {

            lowIndex = midIndex + 1;
        }

        return -1;
    }

    private static <T extends Number > int indexLocatorForFloat(
        int lowIndex, int highIndex, int midIndex, T numberToFind, T numberToCompareTo
    ){
        if ( numberToFind.floatValue() == numberToCompareTo.floatValue() ){

            return midIndex;
        }

        if (numberToCompareTo.floatValue() > numberToFind.floatValue()){

            highIndex = midIndex - 1;
        }
        else {

            lowIndex = midIndex + 1;
        }

        return -1;
    }

    private static <T extends Number > int indexLocatorForDouble(
        int lowIndex, int highIndex, int midIndex, T numberToFind, T numberToCompareTo
    ){
        if ( numberToFind.doubleValue() == numberToCompareTo.doubleValue() ){

            return midIndex;
        }

        if (numberToCompareTo.doubleValue() > numberToFind.doubleValue() ){

            highIndex = midIndex - 1;
        }
        else {

            lowIndex = midIndex + 1;
        }

        return -1;
    }

}
