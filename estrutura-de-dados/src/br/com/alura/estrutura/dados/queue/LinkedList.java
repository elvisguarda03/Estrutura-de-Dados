package br.com.alura.estrutura.dados.queue;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Stack;

public class LinkedList<E> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5416146480873888363L;
	private Node<E> first;
	private Node<E> nextItem;
	private Node<E> last;
	private int size;

	public LinkedList() {
		first = last = null;
	}

	public boolean addFirst(E item) {
		if (item == null)
			throw new NullPointerException("Objeto não foi cadastrado!");
		if (isEmpty()) {
			Node<E> newNode = new Node<E>(item);
			first = newNode;
			last = first;
		} else {
			Node<E> newNode = new Node<E>(item, first);
			first.setPrev(newNode);
			first = newNode;
		}
		size++;
		return true;
	}

	public boolean addLast(E item) {
		if (isEmpty())
			return addFirst(item);
		else {
			if (item == null)
				throw new NullPointerException("Objeto não foi cadastrado!");
			Node<E> newNode = new Node<E>(item);
			newNode.setPrev(last);
			last.setNext(newNode);
			last = newNode;
			size++;
		}
		return true;
	}

	public boolean add(int index, E item) {
		if (isEmpty())
			return addFirst(item);
		else if (index == size)
			return addLast(item);
		else {
			if (item == null)
				throw new NullPointerException("Objeto não foi cadastrado!");
			Node<E> prev = getNode(index - 1);
			Node<E> newNode = new Node<E>(item, prev.getNext(), prev);
			prev.getNext().setPrev(newNode);
			prev.setNext(newNode);
			size++;
		}
		return true;
	}

	public E removeLast() {
		if (size == 1)
			return removeFirst();
		else {
			if (isEmpty())
				throw new NoSuchElementException();
			Node<E> x = last.getPrev();
			final E i = last.item;
			last.item = null;
			last.prev = null;
			x.setNext(null);
			last = x;
			size--;
			return i;
		}
	}

	public E removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		Node<E> x = first.getNext();
		final E i = first.item;
		first.item = null;
		first.next = null;
		if (size > 1)
			x.setPrev(null);
		first = x;
		if (--size == 0)
			last = first;
		return i;
	}

	public E remove(int index) {
		if (index == 0 || size == 1)
			return removeFirst();
		else if (index == size - 1)
			return removeLast();
		else {
			Node<E> nodeRemove = getNode(index);
			nodeRemove.getNext().setPrev(nodeRemove.getPrev());
			nodeRemove.getPrev().setNext(nodeRemove.getNext());
			final E i = nodeRemove.item;
			nodeRemove.item = null;
			nodeRemove.next = nodeRemove.prev = null;
			size--;
			return i;
		}
	}

	public void clear() {
		if (isEmpty())
			throw new NoSuchElementException();
		for (Node<E> x = first; x != null;) {
			Node<E> next = x.next;
			x.item = null;
			x.next = null;
			x.prev = null;
			x = next;
		}
	}

	private Node<E> getNode(int index) {
		checkElementIndex(index);
		Node<E> x = first;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}

	private void checkElementIndex(int index) {
		if (!isElementIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	public E getFirst() {
		final Node<E> f = first;
		if (f == null)
			throw new NoSuchElementException();
		return f.item;
	}

	public E getLast() {
		final Node<E> l = last;
		if (l == null)
			throw new NoSuchElementException();
		return l.item;
	}

	public E remove(E item) {
		return remove(indexOf(item));
	}

	private void reverse(Stack<Node<E>> stack) {
		if (Integer.compare(stack.size(), size) == 0) {
			Node<E> oldLast = stack.pop();
			oldLast.setNext(oldLast.prev);
			oldLast.setPrev(null);
			first = oldLast;
		}
		else {
			Node<E> oldLast = stack.pop();
			Node<E> aux = oldLast.next;
			oldLast.setNext(oldLast.prev);
			oldLast.setPrev(aux);
			if(stack.isEmpty())
				last = oldLast;
		}
		if (!stack.isEmpty())
			reverse(stack);
	}

	public void reverse() {
		Stack<Node<E>> stack = new Stack<>();
		for (int i = 0; i < size; i++) {
			stack.push(getNode(i));
		}
		reverse(stack);
	}

	private boolean isElementIndex(int index) {
		return index >= 0 && index < size;
	}

	private String outOfBoundsMsg(int index) {
		return String.format(new Locale("pt", "BR"), "Index: %d, Size: %d", index, size);
	}

	public int indexOf(E item) {
		if (item == null)
			throw new IllegalArgumentException();
		Node<E> x = first;
		for (int i = 0; i < size; i++) {
			if (x.item.equals(item))
				return i;
			x = x.next;
		}
		return -1;
	}

	public int lastIndexOf(E item) {
		if (item == null)
			throw new IllegalArgumentException();
		Node<E> x = last;
		for (int i = size - 1; i >= 0; i++) {
			if (x.item.equals(item))
				return i;
			x = x.prev;
		}
		return -1;
	}

	public boolean contains(E item) {
		return indexOf(item) >= 0;
	}

	public boolean hasNext() {
		if (first == null)
			return false;
		else if (nextItem == null) {
			nextItem = first;
			return true;
		} else {
			boolean hasNext = nextItem.getNext() != null;
			nextItem = nextItem.next;
			return hasNext;
		}
	}

	public E get(int index) {
		return getNode(index).item;
	}

	public E next() {
		return nextItem.getItem();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		StringBuilder builder = new StringBuilder("[");
		for (Node<E> x = first; x != null; x = x.next) {
			builder.append(x.item);
			builder.append(", ");
		}
		return removeDelimiter(builder);
	}

	private String removeDelimiter(StringBuilder builder) {
		return String.format(new Locale("pt", "BR"), "%s]", builder.subSequence(0, builder.length() - 2));
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		public Node(E item, Node<E> next, Node<E> prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}

		public Node(E item) {
			this.item = item;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public E getItem() {
			return item;
		}
	}
}