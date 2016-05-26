// Matt Mensher & Jodell Morency
// April 1, 2013

// Arrivals class
// Constructs a reference-based queue to simulate a waiting line.
// Reads a text file containing a list of customers: their names, arrival time, and service time.
// Contains the opperations for adding/removing to the line, seeing if the line is empty, seeing who is at the front. 

import java.util.Scanner;
import java.io.*;

public class Arrivals
{
	// Instance variables
	
	private Customer front;
	private Customer back;
	
	// Constructor(s)
	
	public Arrivals()
	{
		front=null;
		back=null;
	}
	
	// Methods
	
	// Checks to see if the the line/queue is empty
	public boolean isEmpty()
	{
		return(front==null);
	}
	
	// Adds a customer to the back of the line/queue
	public void add(Customer customer)
	{
		// If the line is empty, the added customer is now at the front.
		if (front == null)
		{
			front = customer;
			back= front;
		}
		// if the line is not empty, traverse untill you reach the end of the line and then add the customer to the queue.
		else
		{
			Customer c = front;
			while (c.getNext() != null)
				c = c.getNext();
			c.setNext(customer);
			back=customer;
		
		}
	}
	// removes the customer at the front of the line/queue
	public Customer remove()
	{  
			Customer c=front;
			front=front.getNext();
			return c;
	}
	
	// retuns the customer at the front of the line/queue	
	public Customer peek()
	{	
			if (!isEmpty())
				return front;
			else // creates a dummy customer that allows the system to remain running when the arrival queue is empty
				 // avoids a null pointer exception when there are no real customers left to peek at 
			{
				Customer dummy= new Customer(1, 1, "dummy");
				return dummy;
			}
	} 	
	
	// prints the customers' 3 characterisitics of each customer in the arrival queue
	public void display()
	{	// checks to see if the line/queue has customers
		if (front!=null)
		{
			Customer c=front;
			while (c != null)
			{
				c.printCustomer();
				c = c.getNext();	
			}
		}
		else
			System.out.println("No one is in line");
	}
	
	// reads data from a text file that must be in the format: int int String on each line.
	// the data is then used to add create customers in the arrival queue
	public void readCustFile()
	{
		//opens and reads text file
		Scanner fileInput;
		File inFile=new File("customers.txt");

		System.out.println("Opening and reading file");

		try
		{
			// creates a scanner for file input
			fileInput=new Scanner(inFile);
			
			// creates customer objects by passing in values from the text file as parameters
			Customer c;
			while (fileInput.hasNext())
			{
				c= new Customer(fileInput.nextInt(), fileInput.nextInt(), fileInput.next());
				add(c);
				fileInput.nextLine();
			}
			
			fileInput.close();				   // closes file 
		} //end try
	    catch (FileNotFoundException e)
	    {
			System.out.println(e);
			System.exit(1);		// i/o error, exit program
		} // end catch
		
	} // end readCustFile()
}
				
		
		
	
	
