package pkgDoublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E>{
	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList() {
		size = 0;
	}
	/**
	 * Esta clase guarda la información de cada elemento
	 * @author Jose Maria Castellano López
	 *
	 */
	private class Node {
		E element;
		Node next;
		Node prev;

		public Node(E element, Node next, Node prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}
	/**
	 * Devuelve el tamaño de la lista
	 * @return
	 */
	public int size() { return size; }

	/**
	 * Devuelve si la lista está vacia o no lo está
	 * @return
	 */
	public boolean isEmpty() { return size == 0; }

	/**
	 * Añade un elemento al principio de la lista enlazada
	 * @param element
	 */
	public void addFirst(E element) {
		Node tmp = new Node(element, head, null);
		if(head != null ) {head.prev = tmp;}
		head = tmp;
		if(tail == null) { tail = tmp;}
		size++;
		System.out.println("adding: "+element);
	}

	/**
	 * Añade un elemento al final de la lista enlazada
	 * @param element
	 */
	public void addLast(E element) {

		Node tmp = new Node(element, null, tail);
		if(tail != null) {tail.next = tmp;}
		tail = tmp;
		if(head == null) { head = tmp;}
		size++;
		System.out.println("adding: "+element);
	}

	/**
	 * Este metodo recorre hacia delante la lista enlazada
	 */
	public void iterateForward(){

		System.out.println("iterating forward..");
		Node tmp = head;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.next;
		}
	}

	/**
	 * Este metodo recorre hacia atrás la lista enlazada
	 */
	public void iterateBackward(){

		System.out.println("iterating backword..");
		Node tmp = tail;
		while(tmp != null){
			System.out.println(tmp.element);
			tmp = tmp.prev;
		}
	}

	/**
	 * Este metodo elimina los elementos del prinicipio de la lista enlazada
	 * @return
	 */
	public E removeFirst() {
		if (size == 0) throw new NoSuchElementException();
		Node tmp = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("deleted: "+tmp.element);
		return tmp.element;
	}

	/**
	 * Este metodo elimina los elementos del final de la lista enlazada
	 * @return
	 */
	public E removeLast() {
		if (size == 0) throw new NoSuchElementException();
		Node tmp = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		System.out.println("deleted: "+tmp.element);
		return tmp.element;
	}

	public static void main(String a[]){

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addLast(56);
		dll.addLast(364);
		dll.iterateForward();
		dll.removeFirst();
		dll.removeLast();
		dll.iterateBackward();
	}
}
