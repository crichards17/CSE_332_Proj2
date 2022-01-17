package phaseA;
import providedCode.*;

import java.util.NoSuchElementException;


/**
 * Implements a 4-ary minheap using an array as the underlying data structure.
 * When data is added or removed from the heap,
 * nodes are percolated up or down to maintain heap sorted order.
 *
**/
public class FourHeap<E> extends Heap<E> {

	private static final int INITIAL_CAPACITY = 8;
	protected Comparator<? super E> comparator;

	public FourHeap(Comparator<? super E> c) {
		super(INITIAL_CAPACITY);
		comparator = c;
		size = 0;
	}

	@Override
	public void insert(E item) {
		// 1. Insert the new item into the list (resize if needed)
		if (size == heapArray.length) {
			resize();
		}
		heapArray[size] = item;
		size++;
		// 2. Percolate to maintain heap order (call helper)
		percolateUp(size - 1);
	}

	@Override
	public E findMin() {
		if (size == 0) {
			throw new NoSuchElementException("Empty heap");
		}
		return heapArray[0];
	}

	@Override
	public E deleteMin() {
		E min = heapArray[0];
		heapArray[0] = heapArray[size-1];
		heapArray[size-1] = null;
		size--;
		percolateDown();
		return min;
	}

	@Override
	public boolean isEmpty() {
		return size > 0;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		E[] temp = (E[]) new Object[size * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = heapArray[i];
		}
		heapArray = temp;
	}

	private void percolateUp(int starting) {
		E temp;
		int current = starting;
		while (current != 0) {
			int parent = (current - 1) / 4;
			if (comparator.compare(heapArray[current] , heapArray[parent]) < 0) {
				temp = heapArray[current];
				heapArray[current] = heapArray[parent];
				heapArray[parent] = temp;
				current = parent;
			} else {
				break;
			}
		}
	}

	private void percolateDown() {
		E temp;
		int current = 0;
		int firstChild = 5;
		while (firstChild < size) {
			int minChild = firstChild;
			for (int i = 1; i < 4; i++) {
				if (heapArray[firstChild + i] == null) {
					break;
				}
				if (comparator.compare(heapArray[minChild], heapArray[minChild + i]) > 0) {
					minChild = firstChild + i;
				}
			}
			if (comparator.compare(heapArray[current], heapArray[minChild]) < 0) {
				temp = heapArray[current];
				heapArray[current] = heapArray[minChild];
				heapArray[minChild] = temp;
				current = minChild;
				firstChild = (current * 4) + 1;
			} else {
				break;
			}
		}
	}
}
