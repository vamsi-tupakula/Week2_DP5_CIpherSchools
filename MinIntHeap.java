import java.util.*;

public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    public int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    public int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    public int parent(int index) {
        return items[getParentIndex(index)];
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    public void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int root() {
        if (size == 0)
            return -1;
        return items[0];
    }

    public int poll() {
        if (size == 0)
            return -1;
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && items[getRightChildIndex(index)] < items[getLeftChildIndex(index)]) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallerChildIndex]) break;
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    public void add(int num) {
        ensureExtraCapacity();
        items[size] = num;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public static void main(String[] args) {
        MinIntHeap myHeap = new MinIntHeap();
        System.out.println(myHeap.size);
        myHeap.add(5);
        myHeap.add(7);
        myHeap.add(8);
        myHeap.add(13);
        myHeap.add(15);
        System.out.println(myHeap.size);
        System.out.println(myHeap.root());
        myHeap.poll();
        System.out.println(myHeap.root());
    }
}