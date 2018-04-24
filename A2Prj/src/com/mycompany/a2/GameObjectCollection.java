package com.mycompany.a2;

import java.util.ArrayList;

public class GameObjectCollection implements ICollection{

	private ArrayList<GameObject> theCollection;
		
	public GameObjectCollection() {
		theCollection = new ArrayList<GameObject>();
	}
	
	/**
	 * Add GameObjects to theCollection
	 */
	public void add(GameObject obj) {
		theCollection.add(obj);
	}
	
	/**
	 * Make a new Iterator
	 */
	public IIterator getIterator() {
		return new GameIterator();
	}

	/**
	 * Clear the Collection
	 */
	public void clear() {
		theCollection.clear();
	}
	
	/**
	 * return the size of the collection
	 * @return int
	 */
	public int size() {
		return theCollection.size();
	}
	
	private class GameIterator implements IIterator{
		
		private int currentIndex;
		
		public GameIterator() {
			currentIndex = -1;
		}
		
		/**
		 * Returns if theCollection has more items in it
		 */
		public boolean hasNext() {
			//System.out.println(currentIndex);
			if(theCollection.size() <= 0) return false;
			if(currentIndex == theCollection.size() - 1) return false;
			return true;
		}
		
		/**
		 * Returns the next Object in theCollection and increments current index
		 */
		public Object getNext() {
			currentIndex++;
			return(theCollection.get(currentIndex));	
		}
		
		/**
		 * Returns the next Object in theCollection and does not increment the current index
		 */
		public Object checkNext() {
			return(theCollection.get(currentIndex + 1));
			
		}
	}
}
