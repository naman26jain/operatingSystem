

import java.util.HashMap;



import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Queue;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator; 


class pageReplacement 
{ 
	
	static int pageFaults(int pages[], int n, int capacity) 
	{ 
		
		HashSet<Integer> s = new HashSet<>(capacity); 
	
		
		Queue<Integer> indexes = new LinkedList<>() ; 
	
		
		int page_faults = 0; 
		for (int i=0; i<n; i++) 
		{ 
			
			if (s.size() < capacity) 
			{ 
				if (!s.contains(pages[i])) 
				{ 
					s.add(pages[i]); 
	
					page_faults++; 
	
					
					indexes.add(pages[i]); 
				} 
			} 
	
		
			else
			{ 
				if (!s.contains(pages[i])) 
				{ 
					
					int val = indexes.peek(); 
	
					indexes.poll(); 
	
					
					s.remove(val); 
	
					
					s.add(pages[i]); 
	
					 
					indexes.add(pages[i]); 
	
					page_faults++; 
				} 
			} 
		} 
	
		return page_faults; 
 } 
 static int pageFaults1(int pages[], int n, int capacity) 
 { 
  
     HashSet<Integer> s = new HashSet<>(capacity); 
    
      
     HashMap<Integer, Integer> indexes = new HashMap<>(); 
    
     
     int page_faults = 0; 
     for (int i=0; i<n; i++) 
     { 
         if (s.size() < capacity) 
         { 
             if (!s.contains(pages[i])) 
             { 
                 s.add(pages[i]); 
    
                 
                 page_faults++; 
             } 
    
              
             indexes.put(pages[i], i); 
         } 
    
     
         else
         { 
             
             if (!s.contains(pages[i])) 
             { 
                 
                 int lru = Integer.MAX_VALUE, val=Integer.MIN_VALUE; 
                   
                 java.util.Iterator<Integer> itr = s.iterator(); 
                   
                 while (itr.hasNext()) { 
                     int temp = itr.next(); 
                     if (indexes.get(temp) < lru) 
                     { 
                         lru = indexes.get(temp); 
                         val = temp; 
                     } 
                 } 
               
                 
                 s.remove(val); 
                
                indexes.remove(val); 
                 
                 s.add(pages[i]); 
    
                 // Increment page faults 
                 page_faults++; 
             } 
    
             
             indexes.put(pages[i], i); 
         } 
     } 
    
     return page_faults; 
 }
	
	// Driver method 
	public static void main(String args[]) 
	{ 
		int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 
						2, 3, 0, 3, 2}; 

		int capacity = 4; 
		int num ;
		Scanner sc= new Scanner(System.in);
		System.out.println("******MENU*******");
		System.out.println("1.)Fifo");
		System.out.println("2.)lru");
		System.out.print("Enter option:");
		num=sc.nextInt();
		switch(num) {
		
		case 1:
			System.out.println(pageFaults(pages, pages.length, capacity)); 
		case 2:
			System.out.println(pageFaults1(pages, pages.length, capacity)); 
		default:
			System.out.println("enter valid");
			
	} 
} }


