package phaseA;
import providedCode.*;


/**
 * TODO: REPLACE this comment with your own as appropriate.
 * 1. The list is typically not sorted.
 * 2. Add new items (with a count of 1) to the front of the list.
 * 3. Whenever an existing item has its count incremented by incCount
 *    or retrieved by getCount, move it to the front of the list. That
 *    means you remove the node from its current position and make it
 *    the first node in the list.
 * 4. You need to implement an iterator. The iterator SHOULD NOT move
 *    elements to the front.  The iterator should return elements in
 *    the order they are stored in the list, starting with the first
 *    element in the list.
 * TODO: Develop appropriate JUnit tests for your MoveToFrontList.
 */
public class MoveToFrontList<E> extends DataCounter<E> {
	private int size;
	private LinkedNode front;
	private Comparator<? super E> comparator;

	
	public MoveToFrontList(Comparator<? super E> c) {
		size = 0;
		front = null;
		comparator = c;
	}

	// Adds a new node to the list, or increments the count of an existing node
	@Override
	public void incCount(E data) {
		if(front == null) {
			front = new LinkedNode(data, null);
			size++;
			return;
		}
		if (comparator.compare(front.data, data) == 0) {
			front.count++;
			return;
		}
		LinkedNode pointer = front;
		while(pointer.next != null) {
			if (comparator.compare(pointer.next.data, data) == 0) {
				pointer.next.count++;
				moveToFront(pointer);
				return;
			} else {
				pointer = pointer.next;
			}
		}
		front = new LinkedNode(data, front);
		size ++;
	}

	private void moveToFront(LinkedNode node) {
		LinkedNode moving = node.next;
		node.next = moving.next;
		moving.next = front;
		front = moving;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getCount(E data) {
		if(front == null) {
			return -1;
		}
		if (comparator.compare(front.data, data) == 0) {
			return front.count;
		}
		LinkedNode pointer = front;
		while(pointer.next != null) {
			if (comparator.compare(pointer.next.data, data) == 0) {
				int count = pointer.next.count;
				moveToFront(pointer);
				return count;
			} else {
				pointer = pointer.next;
			}
		}
		return -1;
	}

	@Override
	public SimpleIterator<DataCount<E>> getIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	private class LinkedNode {
		private E data;
		private int count;
		private LinkedNode next;

		private LinkedNode(E d, LinkedNode node) {
			data = d;
			next = node;
			count = 1;
		}
	}

}
