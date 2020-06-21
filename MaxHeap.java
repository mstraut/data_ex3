
package a3;

import static org.junit.Assert.*;


public class MaxHeap {

    private int[] HeapArray;

    public int[] getHeapArray() {
        return HeapArray;
    }

    @SuppressWarnings("unused")
    private int size;
    @SuppressWarnings("unused")
    private int maxsize;

    private static final int FRONT = 1;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = maxsize;
        HeapArray = new int[maxsize];
        // initialize heap array to a set of numbers, rearranged a little
        for (int i = FRONT; i < HeapArray.length; i++) {
            HeapArray[i] = maxsize - i;
        }
    }

    // Return the index of the parent of the node currently at pos
    private int parent(int pos) {
        return (pos / 2);
    }

    // Return the index of the leftchild of the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Return the index of the rightchild of the node currently at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Function to heapify the node at position i, to the position n
    private void maxHeapify(int i, int n) {
        int posIindex = i;
        int rightChildIndex = rightChild(i);
        int leftChildIndex = leftChild(i);
        /*
         * checks if the left child's index is <= position n and the left child's value
         * is > than the node at position posIindex
         */
        if (leftChildIndex <= n && HeapArray[leftChildIndex] > HeapArray[posIindex]) {
            posIindex = leftChildIndex;
        }
        /*
         * checks if the right child's index is <= position n and the right child's value
         * is > than the node at position posIindex
         */
        if (rightChildIndex <= n && HeapArray[rightChildIndex] > HeapArray[posIindex]) {
            posIindex = rightChildIndex;
        }
        // if posIindex is now different than i, values are swapped & maxHeapify
        if (posIindex != i) {
            swap(i, posIindex);
            maxHeapify(posIindex, n);
        }
    }

    // takes the array created and organizes it into a max heap
    public void buildMaxHeap() {
        /**
         * TODO implement these as shown in class.
         */

        int heapNum = getHeapArray().length - 1;
        int parentNum = parent(heapNum);
        for (int i = parentNum; i >= 0; i--) {
            maxHeapify(i, heapNum);
        }

    }

    // sorts the heap, swaps nodes
    public void sort() {
        /**
         * TODO implement these as shown in class.
         */
        int[] heap = getHeapArray();
        int heapNum = heap.length - 1;
        buildMaxHeap();

        for (int i = heap.length - 1; i > 0; i--) {
            swap(0, i);
            heapNum--;
            maxHeapify(0, heapNum);
        }

        System.out.println(heap[1] + " + " + heap[2] + " = " + (heap[2] + heap[1]));
    }

    // Swap two nodes of the heap at index first second
    private void swap(int first, int seconds) {
        int tmp;
        tmp = HeapArray[first];
        HeapArray[first] = HeapArray[seconds];
        HeapArray[seconds] = tmp;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int SIZE = 30;
        MaxHeap heap = new MaxHeap(SIZE);

        heap.sort();
        int[] heapArr = heap.getHeapArray();

        assertEquals(heapArr[0], 0);
        assertEquals(heapArr[1], 1);
        assertEquals(heapArr[2], 2);
        assertEquals(heapArr[SIZE - 1], SIZE - 1);
        assertEquals(heapArr.length, SIZE);
    }

}