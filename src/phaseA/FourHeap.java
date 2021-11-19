package phaseA;
import providedCode.*;


/**
 * TODO: Replace this comment with your own as appropriate.
 * 1. It is exactly like the binary heap we studied, except nodes
 *    should have 4 children instead of 2. Only leaves and at most one
 *    other node will have fewer children.
 * 2. Use an array-based implementation, beginning at index 0 (Root
 *    should be at index 0).  Construct the FourHeap by passing
 *    appropriate argument to superclass constructor.  Hint: Complete
 *    written homework #2 before attempting this.
 * 3. Throw appropriate exceptions in FourHeap whenever needed. For
 *    example, when deleteMin is on an empty heap, you could use
 *    UnderFlowException as is done in the Weiss text, or you could
 *    use NoSuchElementException (in which case it will be fine if you
 *    want to import it).
 * TODO: Develop appropriate JUnit tests for your FourHeap.
 * 
 * IMPORTANT NOTE:
 * 1. You MUST use the fields defined in the superclass!
 * 2. FourHeap should be a MIN-HEAP, which means the "smallest"
 *    element according to the given comparator should be at the root. It
 *    is obvious from the name of methods, deleteMin() & findMin(),
 *    which should return the minimum element determined by the given
 *    comparator. For example, the DataCountStringComparator considers
 *    the element with the highest count to be the "smallest", so when you
 *    call deleteMin() or findMin() your FourHeap should return the
 *    element with highest count.
 * 3. If you accidentally made it as MAX-HEAP instead of MIN-HEAP, it
 *    will return the "largest" element (with
 *    DataCountStringComparator, this will be the one with lowest count) when
 *    deleteMin() is called, and you are going to lose considerable
 *    amount of FourHeap points.
 * 4. For Testing: Given the same comparator, FourHeap's deleteMin()
 *    should return the same element as Java's PriorityQueue's poll().
 */
public class FourHeap<E> extends Heap<E> {
	
	public FourHeap(Comparator<? super E> c) {
		// TODO: To-be implemented. Replace the dummy parameter to superclass constructor.
		super(0);
	}

	@Override
	public void insert(E item) {
		// TODO Auto-generated method stub
	}

	@Override
	public E findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E deleteMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
