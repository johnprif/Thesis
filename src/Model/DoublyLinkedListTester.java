package Model;

import java.io.IOException;

import com.opencsv.exceptions.CsvException;

public class DoublyLinkedListTester 
{
	public DoublyLinkedListTester() throws IOException, CsvException
	{
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtFirst(1);
		list.displayFirstToLast();
		System.out.println("size :" + list.getSize());
		list.displayFirstToLast();
		list.insertAtFirst(2);
		list.displayFirstToLast();
		System.out.println("size :" + list.getSize());
		list.insertAtLast(3);
		list.displayFirstToLast();
		System.out.println("size :" + list.getSize());
		list.displayFirstToLast();
		list.insertAtLast(4);
		System.out.println("size :" + list.getSize());
		list.displayFirstToLast();
		list.insertAtIndex(5, 3);
		System.out.println("size :" + list.getSize());
		System.out.println("Linked list backward traversal");
		list.displayLastToFirst();
		System.out.println("Linked list forward traversal");
		list.displayFirstToLast();

		list.deleteAtIndex(2);
		System.out.println("Node at index 2 has been deleted");
		System.out.println("size :" + list.getSize());
		list.displayFirstToLast();

		list.deleteFirstNode();
		System.out.println("First Node  has been deleted");
		System.out.println("size :" + list.getSize());
		list.displayFirstToLast();

		list.deleteLastNode();
		System.out.println("Last Node  has been deleted");
		System.out.println("size :" + list.getSize());
		list.displayFirstToLast();

		list.searchNode(5);
		list.displayFirstToLast();
		
	}
}
