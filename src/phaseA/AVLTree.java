package phaseA;
import providedCode.*;


/**
 * TODO: REPLACE this comment with your own as appropriate.
 * AVLTree must be a subclass of BinarySearchTree<E> and must use
 * inheritance and calls to superclass methods to avoid unnecessary
 * duplication or copying of functionality.
 * 1. Create a subclass of BSTNode, perhaps named AVLNode.
 * 2. Override incCount method such that it creates AVLNode instances
 *    instead of BSTNode instances.
 * 3. Do NOT "replace" the left and right fields in BSTNode with new
 *    left and right fields in AVLNode.  This will instead mask the
 *    super-class fields (i.e., the resulting node would actually have
 *    four node fields, with code accessing one pair or the other
 *    depending on the type of the references used to access the
 *    instance).  Such masking will lead to highly perplexing and
 *    erroneous behavior. Instead, continue using the existing BSTNode
 *    left and right fields.
 * 4. Cast left and right fields to AVLNode whenever necessary in your
 *    AVLTree. This will result a lot of casts, so you can also follow
 *    the hints given during section to reduce the number of casts.
 * 5. Do NOT override the dump method of BinarySearchTree & the toString
 *    method of DataCounter. They are used for grading.
 * TODO: Develop appropriate JUnit tests for your AVLTree (TestAVLTree
 * in testA package).
 */
public class AVLTree<E> extends BinarySearchTree<E> {

	public AVLTree(Comparator<? super E> c) {
		super(c);
	}

	public void incCount(E data) {
		overallRoot = incCount(data, (AVLNode) overallRoot);
	}

	private AVLNode incCount(E data, AVLNode node) {
		if (node == null) {
			node = new AVLNode(data);
			return node;
		}
		int compare = comparator.compare(data, node.data);
		if (compare ==0) {
			node.count++;
		} else if (compare < 0) {
			node.left = incCount(data, (AVLNode) node.left);
			if (getHeight(node.left) - getHeight(node.right) == 2) {
				if (comparator.compare(data, node.left.data) < 0) {
					//left-left
					node = rotateRight(node);
				} else {
					//left-right
					node = rotateLeftRight(node);
				}
			}
			// update height
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		} else {
			node.right = incCount(data, (AVLNode) node.right);
			if (getHeight(node.right) - getHeight(node.left) == 2) {
				if (comparator.compare(data, node.right.data) > 0) {
					// right-right
					node = rotateLeft(node);
				} else {
					//right-left
					node = rotateRightLeft(node);
				}
			}
			// update height
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		}
		return node;
	}

	// Returns a subtree root after a single right rotation
	private AVLNode rotateRight(AVLNode node) {
		AVLNode ref = (AVLNode) node.left;
		node.left = ref.right;
		ref.right = node;
		// update height
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		ref.height = Math.max(getHeight(ref.left), getHeight(ref.right)) + 1;
		return ref;
	}

	// Returns a subtree root after a single left rotation
	private AVLNode rotateLeft(AVLNode node) {
		AVLNode ref = (AVLNode) node.right;
		node.right = ref.left;
		ref.left = node;
		// update height
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		ref.height = Math.max(getHeight(ref.left), getHeight(ref.right)) + 1;
		return ref;
	}

	// Returns a subtree root after a double rotation left-right
	private AVLNode rotateLeftRight(AVLNode node) {
		node.left = rotateLeft((AVLNode) node.left);
		return rotateRight(node);
	}

	// Returns a subtree root after a double rotation right-left
	private AVLNode rotateRightLeft(AVLNode node) {
		node.left = rotateRight((AVLNode) node.left);
		return rotateLeft(node);
	}

	// Return the height of a given node
	private int getHeight(BSTNode node) {
		if (node==null) {
			return -1;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	protected class AVLNode extends BSTNode {
		protected int height;

		public AVLNode(E data) {
			super(data);
			height = 0;
		}

	}



}
