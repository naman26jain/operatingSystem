

import java.util.*;


class memoryAllocation 
{ 
	
	static void firstFit(int blockSize[], int m, 
						int processSize[], int n) 
	{ 
		
		int allocation[] = new int[n]; 
	
		// Initially no block is assigned to any process 
		for (int i = 0; i < allocation.length; i++) 
			allocation[i] = -1; 
	
		for (int i = 0; i < n; i++) 
		{ 
			for (int j = 0; j < m; j++) 
			{ 
				if (blockSize[j] >= processSize[i]) 
				{ 
					
					allocation[i] = j; 
	
					
					blockSize[j] -= processSize[i]; 
	
					break; 
				} 
			} 
		} 
	
		System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(" " + (i+1) + "\t\t" + 
							processSize[i] + "\t\t"); 
			if (allocation[i] != -1) 
				System.out.print(allocation[i] + 1); 
			else
				System.out.print("Not Allocated"); 
			System.out.println(); 
		} 
	} 
	static void bestFit(int blockSize[], int m, int processSize[],  
                                                     int n) 
    { 
         
        int allocation[] = new int[n]; 
       
        
        for (int i = 0; i < allocation.length; i++) 
            allocation[i] = -1; 
       
     
        for (int i=0; i<n; i++) 
        { 
            
            int bestIdx = -1; 
            for (int j=0; j<m; j++) 
            { 
                if (blockSize[j] >= processSize[i]) 
                { 
                    if (bestIdx == -1) 
                        bestIdx = j; 
                    else if (blockSize[bestIdx] > blockSize[j]) 
                        bestIdx = j; 
                } 
			} 
			System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i1 = 0; i1 < n; i1++) 
        { 
            System.out.print("   " + (i1+1) + "\t\t" + processSize[i1] + "\t\t"); 
            if (allocation[i1] != -1) 
                System.out.print(allocation[i1] + 1); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } }
    } 
			static void worstFit(int blockSize[], int m, int processSize[],  
                                                     int n) 
    { 
        
        int allocation[] = new int[n]; 
       
  
        for (int i = 0; i < allocation.length; i++) 
            allocation[i] = -1; 
       
      
        for (int i=0; i<n; i++) 
        { 
            
            int wstIdx = -1; 
            for (int j=0; j<m; j++) 
            { 
                if (blockSize[j] >= processSize[i]) 
                { 
                    if (wstIdx == -1) 
                        wstIdx = j; 
                    else if (blockSize[wstIdx] < blockSize[j]) 
                        wstIdx = j; 
                } 
            } 
        
            if (wstIdx != -1) 
            { 
                
                allocation[i] = wstIdx; 
       
                blockSize[wstIdx] -= processSize[i]; 
            } 
        } 
       
        System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print("   " + (i+1) + "\t\t" + processSize[i] + "\t\t"); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i] + 1); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } 
    } 
	
		public static void main(String[] args) 
	{ 
		int blockSize[] = {100, 500, 200, 300, 600}; 
		int processSize[] = {212, 417, 112, 426}; 
		int m = blockSize.length; 
		int n = processSize.length; 
		int num;
		Scanner sc= new Scanner(System.in);
		System.out.println("******MENU*******");
		System.out.println("1.)First Fit");
		System.out.println("1.)Best Fit");
		System.out.println("1.)Worst Fit");
		System.out.print("Enter option:"); 
		num=sc.nextInt();
		switch(num){
		case 1:
		firstFit(blockSize, m, processSize, n); 
		case 2:
		bestFit(blockSize, m, processSize, n); 
		case 3:
		worstFit(blockSize, m, processSize, n);
		default:
		System.out.println("Enter a valid option!");}




		
	} 
} 

