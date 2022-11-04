//Sources
//https://www.javadevjournal.com/data-structure/doubly-linked-list-in-java/

package Model;

public class DoublyLinkedList 
{
	class Node
	{
		double data;
		Node before;
		Node next;
		
		public Node(double data)
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
	
	public boolean insertAtFirst(double data)
	{
		Node newNode = new Node(data);
		//For the first element, head and tail both will point to it
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
		
		return true;
	}
	
	public boolean insertAtIndex(double data, int index)
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
				return true;
			}
		}else
		{
			System.out.println("Index "+index+" not valid for linked list of size "+size);
		}
		return false;
	}
	
	public boolean insertAtLast(double data)
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
		
		return true;
	}
	
	public boolean deleteFirstNode()
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
		return true;
	}
	
	public boolean deleteAtIndex(int index)
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
				return true;
			}			
		}else
		{
			System.out.println("Index "+index+" not valid for linked list of size "+size);
		}
		return false;
	}

	public boolean deleteLastNode() 
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
		return true;
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
	
	public boolean searchNode(double data)
	{
		Node current=head;
		if(head==null)
		{
			System.out.println("Doubly linked list is empty");
			return false;
		}
		System.out.println("Search node with data "+data+" in doubly linked list");
		while(current!=null)
		{
			if(current.data==data)
			{
				System.out.println("node with data "+data+" found");
				return true;
			}
			current=current.next;
		}
		return false;
	}
}
