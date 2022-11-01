//Sources
//https://www.javadevjournal.com/data-structure/doubly-linked-list-in-java/

package Model;

public class DoublyLinkedList 
{
	class Node
	{
		int data;
		Node before;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	Node head, tail = null;
	int size;
	
	public void insertAtFirst(int data)
	{
		Node newNode = new Node(data);
		//For the first element, head and tail both will poit to it
		if(head == null)
		{
			tail = newNode;
		}else
		{
			head.before = newNode;
		}
		
		newNode.next = head;
		head = newNode;
		
		size++;
	}
	
	public void insertAtIndex(int data, int index)
	{			
		if(index>=0 && index<=size)
		{
			Node newNode = new Node(data);
			Node current = head;
			
			if(index==0)
			{
				insertAtFirst(data);
			}else if(index==size)
			{
				insertAtLast(data);
			}else
			{
				for(int i=0; i<index && current.next!=null; i++)
				{
					current=current.next;
				}
				
				newNode.next=current;
				current.before.next=newNode;
				newNode.before=current.before;
				current.before=newNode;
				
				size++;
			}
		}else
		{
			System.out.println("Index "+index+" not valid for linked list of size "+size);
		}
	}
	
	public void insertAtLast(int data)
	{
		Node newNode = new Node(data);
		
		if(head==null)
		{
			head=newNode;
		}else
		{
			tail.next=newNode;
			newNode.before=tail;
		}
		tail=newNode;
		size++;
	}
}
