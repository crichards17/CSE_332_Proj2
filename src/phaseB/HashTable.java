package phaseB;
import providedCode.*;

import java.util.NoSuchElementException;


/**
 * 1. Hash table will accept any key, and any number of inputs (up to >200,000 capacity)
 * 2. Rehashes when it reaches >75% load factor
 * 3. Able to hash strings for use in WordCount
 * 4. List of primes are pre-seeded
 * 5. Uses separate chaining for collision

 * TODO: Develop appropriate JUnit tests for your HashTable.
 */
public class HashTable<E> extends DataCounter<E> {

	private static final double LOAD_MAX = 0.75;
	private static final int[] primeList = {53, 157, 269, 503, 769, 1321, 2089, 5051, 7177,
			11939, 37119, 91193, 115249, 181081, 207307};

	private HashBucket[] hashTable;
	private final Hasher<E> hasher;
	private final Comparator<? super E> comparator;
	private int primesIndex;
	private int size;

	@SuppressWarnings("unchecked")
	public HashTable(Comparator<? super E> c, Hasher<E> h) {
		primesIndex = 0;
		hashTable = (HashBucket[]) new HashTable.HashBucket[primeList[primesIndex]];
		hasher = h;
		comparator = c;
		size = 0;
	}
	
	@Override
	public void incCount(E data) {
		if( (double) getSize() / primeList[primesIndex] > LOAD_MAX ){
			resize();
		}
		int hashedIndex = hasher.hash(data) % hashTable.length;
		HashBucket checkBucket = hashTable[hashedIndex];
		if (checkBucket == null) {
			hashTable[hashedIndex] = new HashBucket(data);
		} else {
			boolean found = false;
			while (checkBucket.next != null) {
				if (comparator.compare(data, checkBucket.next.data) == 0) {
					found = true;
					checkBucket.next.count++;
					break;
				}
			}
			if (!found) {
				checkBucket.next = new HashBucket(data);
			}
		}
		size++;
	}

	// Resizes and rehashes the table.
	// Uses the next prime for table size, and copies and rehashes all entries
	@SuppressWarnings("unchecked")
	private void resize() {
		primesIndex++;
		HashBucket[] temp = (HashBucket[]) new HashTable.HashBucket[primeList[primesIndex]];
		for (HashBucket copyBucket : hashTable) {
			while (copyBucket != null) {
				int newHashIndex = hasher.hash(copyBucket.data) % temp.length;
				HashBucket checkBucket = temp[newHashIndex];
				if (checkBucket == null) {
					temp[newHashIndex] = copyBucket;
				} else {
					while (checkBucket.next != null) {
						checkBucket = checkBucket.next;
					}
					checkBucket.next = copyBucket;
				}
				copyBucket = copyBucket.next;
			}
		}
		hashTable = temp;
	}


	@Override
	public int getSize() {
		return size;
	}

	@Override
	// Returns the count of a given datum in the table.
	// Returns a 0 if the data is not present.
	public int getCount(E data) {
		HashBucket checkBucket = hashTable[hasher.hash(data) % hashTable.length];
		while (checkBucket != null) {
			if (comparator.compare(data, checkBucket.data) == 0) {
				return checkBucket.count;
			}
			checkBucket = checkBucket.next;
		}
		return 0;
	}

	@Override
	public SimpleIterator<DataCount<E>> getIterator() {
		return new SimpleIterator<DataCount<E>>() {

			private HashBucket currentBucket = null;
			private int currentIndex = -1;
			private int parsed = 0;

			public boolean hasNext() {
				return parsed < size;
			}

			public DataCount<E> next() {
				if (!hasNext()) {
					throw new NoSuchElementException("No elements remaining in Iterator");
				}
				while (currentBucket == null) {
					currentBucket = hashTable[currentIndex++];
				}
				HashBucket returnBucket = currentBucket;
				currentBucket = currentBucket.next;
				parsed++;
				return new DataCount<E>(returnBucket.data, returnBucket.count);
			}
		};
	}

	private class HashBucket {
		protected HashBucket next;
		protected E data;
		protected int count;

		public HashBucket(E d, HashBucket n, int c) {
			data = d;
			next = n;
			count = c;
		}

		// For constructing net-new buckets with null next and count of 1
		public HashBucket(E d) {
			this(d, null, 1);
		}
	}
}
