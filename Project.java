import java.util.Arrays;
import java.util.Collections;

public class Project{
    
    //Sorting algorithm from the book
    public static int SortAnalysis(int Array[]){

        int count = 0;

        for (int i = 0; i < Array.length; i++){
            int v = Array[i];
            int j = i - 1;
            while ((j >= 0) && (Array[j] > v)){
                count++;
                Array[j+1] = Array[j];
                j--;
            }
            if (j >= 0) {
                count++;
            }
            Array[j+1] = v;
        }
        return count;
    }

    //Overloading SortAnalysis() so that it will work with the 
    //descending order array
    public static int SortAnalysis(Integer Array[]){

        int count = 0;

        for (int i = 0; i < Array.length; i++){
            int v = Array[i];
            int j = i - 1;
            while ((j >= 0) && (Array[j] > v)){
                count++;
                Array[j+1] = Array[j];
                j--;
            }
            if (j >= 0) {
                count++;
            }
            Array[j+1] = v;
        }
        return count;
    }

    public static void main(String[] args) {

        //Maximum & minimum values to generate random numbers
        int max = 20000;
        int min = 1;

        //***************************************************** RANDOM UNSORTED ARRAYS ************************************ */

        //Size of the first array to be made, will increase by 1000
        //for each array up to 20000
        int size = 1000;

        //Outer loop creates and allocates space for the 
        //20 arrays of increasing size
        System.out.println("Random, initially unsorted array times of array sizes 1,000-20,000");
        for (int i = 0; i < 20; i++){
            int array[] = new int[size];

            //Inner loop sets the elements in the array
            for (int j = 0; j < size; j++) {
                array[j] = (int)(Math.random() * (max - min + 1) + min);
            }

            //Calls SortAnalysis() and prints the number of times
            //the comparison loop was executed
            int arrayCount = SortAnalysis(array);
            System.out.println(size + " " + arrayCount);

            //Increasing the size of the array
            size += 1000;
        }
        System.out.println();

        //**************************************** RANDOM ASCENDING ARRAYS **********************************************************************/

        //Reset size back to 1000 for the 20 new, already sorted arrays,
        //will also increase by 1000 up to 20000
        size = 1000;

        //Outer loop creates and allocates space for the 
        //20 arrays of increasing size
        System.out.println("Random, already sorted (ascending) arrays times, sizes 1,000-20,000");
        for (int i = 0; i < 20; i++){
            int ascendingArray[] = new int[size];

            //Inner loop sets the elements in the array
            for (int j = 0; j < size; j++) {
                ascendingArray[j] = (int)(Math.random() * (max - min + 1) + min);
            }

            //Sorts the array in ascending order then
            //calls SortAnalysis() and prints the number of times
            //the comparison loop was executed
            Arrays.sort(ascendingArray);
            int arrayCount2 = SortAnalysis(ascendingArray);
            System.out.println(size + " " + arrayCount2);

            //Increasing the size of the array
            size += 1000;
        }
        System.out.println();

        //*************************************** RANDOM DESCENDING ARRAYS ************************************************************/

        //Reset size back to 1000 for the 20 new, already sorted arrays,
        //will also increase by 1000 up to 20000
        size = 1000;

        //Outer loop creates and allocates space for the 
        //20 arrays of increasing size
        //This time, made Integer object arrays to work with .reverseOrder()
        System.out.println("Random, already sorted (descending) arrays times, sizes 1,000-20,000");
        for (int i = 0; i < 20; i++){
            Integer descendingArray[] = new Integer[size];

            //Inner loop sets the elements in the array
            for (int j = 0; j < size; j++) {
                descendingArray[j] = (int)(Math.random() * (max - min + 1) + min);
            }

            //Sorts the array in descending order then
            //calls SortAnalysis() and prints the number of times
            //the comparison loop was executed
            Arrays.sort(descendingArray, Collections.reverseOrder());
            int arrayCount3 = SortAnalysis(descendingArray);
            System.out.println(size + " " + arrayCount3);

            //Increasing the size of the array
            size += 1000;
        }
        System.out.println();
    }
}