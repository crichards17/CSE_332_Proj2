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
	
	// TODO: To-be implemented

}
