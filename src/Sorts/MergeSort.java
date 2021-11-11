package Sorts;

/**
 * A sorting class that Merge sorts any type array of E on a given comparator in O(n * log(n)) time.
 * @param <E> Generic Type E
 */
public class MergeSort<E extends Comparable<E>> {

    private final Class<E> type;

    /**
     * Initializes the class.
     * @param type Given class type, used for generics.
     */
    public MergeSort(Class<E> type){
        this.type = type;
    }


    /**
     * Takes in an array and recursively divides it into 2 arrays until there is one or two elements in each.
     * It then merges them back together by calling merge.
     *
     * @param arr an arr
     * @return a target arr
     */
    @SuppressWarnings("unchecked")
    public E[] mergeSort(E[] arr) {
        // base case
        if (arr.length == 1) return arr;

        // initialize leftArr and rightArr arrays
        int midpoint = arr.length / 2;
        E[] leftArr;
        E[] rightArr;

        leftArr = (E[]) java.lang.reflect.Array.newInstance(type, midpoint); //for generics only

        if (arr.length % 2 == 0) {
            rightArr = (E[]) java.lang.reflect.Array.newInstance(type, midpoint); //for generics only
        } else {
            rightArr = (E[]) java.lang.reflect.Array.newInstance(type, midpoint + 1); //for generics only
        }

        //populate arrays
        for (int i = 0; i < midpoint; i++) {
            leftArr[i] = arr[i];
        }

        for (int j = 0; j < rightArr.length; j++) {
            rightArr[j] = arr[midpoint + j];
        }

        E[] resultArr;
        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);
        resultArr = merge(leftArr, rightArr);
        return resultArr;
    }


    /**
     * Prints the contents of the array in a readable format
     * @param arr
     */
    public void printArr(E[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i ++){
            System.out.print(arr[i].toString() + ", ");
        }
        System.out.print(arr[arr.length-1] + "]");
    }


    /**
     * Sorts the arr and merges it back into the target arr.
     *
     * @param leftArr  a left sub arr.
     * @param rightArr a right sub arr.
     * @return a target arr.
     */
    @SuppressWarnings("unchecked")
    private E[] merge(E[] leftArr, E[] rightArr) {
        E[] resultArr = (E[]) java.lang.reflect.Array.newInstance(type, leftArr.length + rightArr.length); //for generics only
        int currentLeftIdx = 0;
        int currentRightIdx = 0;
        int currentResultIdx = 0;
        while (currentLeftIdx < leftArr.length && currentRightIdx < rightArr.length) {
            int compareResult = leftArr[currentLeftIdx].compareTo(rightArr[currentRightIdx]);
            if (compareResult == 0 || compareResult < 0) { // val in right arr is less than or equal to val in left arr
                resultArr[currentResultIdx] = leftArr[currentLeftIdx];
                currentLeftIdx += 1;
            } else {
                resultArr[currentResultIdx] = rightArr[currentRightIdx];
                currentRightIdx += 1;
            }
            currentResultIdx += 1;
        }
        // if one of the arrays is at the end we tack on the rest of the other array.
        while (currentLeftIdx != leftArr.length) {
            resultArr[currentResultIdx] = leftArr[currentLeftIdx];
            currentLeftIdx += 1;
            currentResultIdx += 1;
        }
        while (currentRightIdx != rightArr.length) {
            resultArr[currentResultIdx] = rightArr[currentRightIdx];
            currentRightIdx += 1;
            currentResultIdx += 1;
        }
        return resultArr;
    }


}

