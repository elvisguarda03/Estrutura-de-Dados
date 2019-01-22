package br.com.alura.estrutura.dados.queue;

public class Queue<E> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6714590229792815833L;
	private LinkedList<E> queues;
	
	public Queue() {
		queues = new LinkedList<E>();
	}
	
	public boolean toQueue(E item) {
		return queues.addLast(item);
	}
	
	public E dequeue() {
		return queues.removeFirst();
	}
	
	public E get(int index) {
		return queues.get(index);
	}
	
	public boolean contains(E item) {
		return queues.contains(item);
	}
	
	public E peek() {
		return queues.getFirst();
	}
	
	public int size() {
		return queues.size();
	}
	
	public boolean isEmpty() {
		return queues.isEmpty();
	}
	
	@Override
	public String toString() {
		return queues.toString();
	}
}