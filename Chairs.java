// Matt Mensher & Jodell Morency
// April 1, 2013

// Chairs class
// Constructs an array-based queue to simulate a waiting line.
// Contains the opperations for adding/removing to the queue, seeing if the queue is empty, and seeing who is at the front. 

import java.util.Scanner;
import java.io.*;

public class Chairs
{
	// Instance variables
	
	private int front, back, count, size;
	private Customer [] queue;
	
	// constructor
	 
	 public Chairs (int queueSize)
	 {
	 	queue = new Customer[queueSize];
	 	size = queueSize;
	 	front = 0;
	 	back = size - 1;
	 	count = 0;
	 }
	 
	 // methods
	  
	  // checks to see if the queue is empty
	  public boolean isEmpty()
	  {
	  	return count == 0;
	  }
	  
	  // checks to see if the queue is full
	  public boolean isFull()
	  {
	  	return count == size;
	  }
	  
	  // adds a specified customer to the queue
	  public void add (Customer customer){
	  	if (!isFull()){
	  		back = (back + 1) % size;
	  		queue[back] = customer;	
	  		count++; 		
	  	}
	  	else{
	  		System.out.println("Queue is full");
	  	}
	  }
	  
	  // removes the customer at the front of the queue
	  public Customer remove()
	  {
	  	Customer frontCustomer = queue[front];
	  	front = (front + 1) % size;
	  	count--;
	  	return frontCustomer;	  			
	  }
	  
	  // retrieves the customer at the front of queue
	  public Customer peek()
	  {
	  	return queue[front];	  		
	  }
	  
	  // prints the customers in the chairs queue and there characteristics
	   public void displayCustomers()
	   {
	   	System.out.println(count + " people are in chairs"); //print how many people are in chairs
	  	if (!isEmpty())
	  	{
	  		for (int x=0; x<count; x++)
	  		{
	  			System.out.print("\t");
	  			queue[(front + x) % size].printCustomer();
	  		}
	  	}
	  	else
	  	{
	  		System.out.println("\tChairs are empty");
	  	}
	  }
	  
	  // prints a statement notifying whether chairs are empty and available
	  public void displayChairsEmpty()
	  {
	  	if(isEmpty())
	  		System.out.println("Chairs are Empty");
	  	else
	  		System.out.println("Chairs are Available");
	  }
}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
