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
	int size=0;
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize(int size)
	{
		this.size=size;
	}
	
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
	
	public void deleteFirstNode()
	{
		Node newNode;
		if(head==null)
		{
			System.out.println("List is empty");
		}
		newNode = head;
		if(head.next==null)
		{
			tail=null;
		}else
		{
			head.next.before=null;
		}
		head=head.next;
		size--;		
	}
	
	public void deleteAtIndex(int index)
	{
		Node current;
		if(index+1>=0 && index+1<=size)
		{
			current=head; 
			
			if(index==0) //remove at the start
			{
				deleteFirstNode();
			}else if(index==size-1) //remove at last
			{
				deleteLastNode();
			}else
			{
				for(int i=0; i<index && current.next!=null; i++)
				{
					current=current.next;
				}
				current.before.next=current.next;
				current.next.before=current.before;
				size--;
			}			
		}else
		{
			System.out.println("Index "+index+" not valid for linked list of size "+size);
		}
	}

	private void deleteLastNode() 
	{
		Node newNode;
		if(tail==null)
		{
			throw new RuntimeException("List is empty");
		}
		newNode=tail;
		if(head.next==null)
		{
			head=null;
		}else
		{
			tail.before.next=null;
		}
		tail=tail.before;
		size--;
	}
	
	public void displayFirstToLast()
	{
		Node current=head;
		System.out.println("The doubly linked list is --> ");
		while(current!=null)
		{
			System.out.println(" "+current.data);
			current=current.next;
		}
		System.out.println("");
	}
	
	public void displayLastToFirst()
	{
		Node current=tail;
		System.out.println("The doubly linked list is --> ");
		while(current!=null)
		{
			System.out.println(" "+current.data);
			current=current.before;
		}
		System.out.println(" ");
	}
	
	public void searchNode(int data)
	{
		Node current=head;
		if(head==null)
		{
			System.out.println("Doubly linked list is empty");
			return;
		}
		System.out.println("Search node with data "+data+" in doubly linked list");
		while(current!=null)
		{
			if(current.data==data)
			{
				System.out.println("node with data "+data+" found");
				break;
			}
			current=current.next;
		}
	}
}
