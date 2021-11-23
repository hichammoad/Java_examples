package generics;

interface AList<T> {
	/*
	 * Add element to the list
	 */
	public void add(T t);

	/*
	 * get element at position index
	 */
	public T get(int index);

	/*
	 * update element:
	 */
	public void set(T t, int index);

	/*
	 * size of the list
	 */
	public int size();

	/*
	 * remove all elements:
	 */
	public void clear();

	/*
	 * check if the list is empty
	 */
	public boolean isEmpty();

	/*
	 * returns the index of element t:
	 */
	public int indexOf(T t);

	/*
	 * remove element at position index:
	 */
	public void remove(int index);

	/*
	 * print the list values:
	 */
	public void print();

}

public class MyList<T> implements AList<T> {

	T[] tab;

	// constructeur, we initialize the array:
	public MyList() {
		tab = (T[]) new Object[0];
	}

	/*
	 * Add element to the list
	 */
	@Override
	public void add(T t) {
		T[] tabPlusOne = (T[]) new Object[tab.length + 1];
		// we can also use a loop to copy the values:
		System.arraycopy(tab, 0, tabPlusOne, 0, tab.length);
		// insert the object at the last position:
		tabPlusOne[tabPlusOne.length - 1] = t;
		tab = tabPlusOne;
	}

	/*
	 * get element at position index
	 */
	@Override
	public T get(int index) {
		if (index > tab.length || index < 0)
			throw new IndexOutOfBoundsException("oops! index is greather than array size!");
		return tab[index];
	}

	/*
	 * update element:
	 */
	@Override
	public void set(T t, int index) {
		if (index > tab.length || index < 0)
			throw new IndexOutOfBoundsException("oops! index is greather than array size!");
		tab[index] = t;
	}

	/*
	 * size of the list
	 */
	@Override
	public int size() {
		return tab.length;
	}

	/*
	 * remove all elements:
	 */
	@Override
	public void clear() {
		tab = (T[]) new Object[0];
	}

	/*
	 * check if the list is empty
	 */
	@Override
	public boolean isEmpty() {
		return (tab.length == 0);
	}

	/*
	 * returns the index of element t:
	 */
	@Override
	public int indexOf(T t) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i].equals(t)) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * remove element at position index:
	 */
	@Override
	public void remove(int index) {
		if (index > tab.length || index < 0)
			throw new IndexOutOfBoundsException("oops! index is greather than array size!");
		T[] tabMinusOne = (T[]) new Object[tab.length - 1];
		// we can also use a loop to copy the values:
		System.arraycopy(tab, 0, tabMinusOne, 0, index + 1);
		System.arraycopy(tab, index + 1, tabMinusOne, index, tabMinusOne.length - index);
		tab = tabMinusOne;
	}

	/*
	 * print the list values:
	 */
	@Override
	public void print() {
		System.out.print("[ ");
		for (T t : tab) {
			System.out.print(t + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {

		MyList<String> mylist = new MyList<String>();

		System.out.println("----------- before insert  : -----------");
		System.out.println("Size : " + mylist.size());
		System.out.println("isEmpty? " + mylist.isEmpty());
		System.out.println("index of A8: " + mylist.indexOf("A8"));
		// System.out.println("element at 5th pos: "+mylist.get(5)); // throus exception
		mylist.print();

		mylist.add("A1");
		mylist.add("A2");
		mylist.add("A3");
		mylist.add("A4");
		mylist.add("A5");
		mylist.add("A6");
		mylist.add("A7");
		mylist.add("A8");

		System.out.println("----------- After add : -----------");
		System.out.println("Size : " + mylist.size());
		System.out.println("isEmpty? " + mylist.isEmpty());
		System.out.println("index of A8: " + mylist.indexOf("A8"));
		System.out.println("element at 5th pos: " + mylist.get(5));
		mylist.print();

		mylist.remove(2);
		mylist.remove(2);

		System.out.println("----------- After remove : -----------");
		System.out.println("Size : " + mylist.size());
		System.out.println("isEmpty? " + mylist.isEmpty());
		System.out.println("index of A8: " + mylist.indexOf("A8"));
		System.out.println("element at 5th pos: " + mylist.get(5));
		mylist.print();

	}

}
