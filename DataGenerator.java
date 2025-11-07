package sorter;

import java.util.Random;
import java.util.Scanner;

public class DataGenerator {
	public static int[] getData() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Enter a list Of Integer Number:");
         int size = scan.nextInt();
		
        
        int[] array = new int[size];
        
        System.out.println("\nChoose option:");
        System.out.println("1. Enter numbers manually");
        System.out.println("2. Generate random numbers");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        
        if (choice == 1) {
        	 for (int i = 0; i < size; i++) {
        		 System.out.print("Enter number " + (i+1) + ": ");
        		 array[i] = scan.nextInt();
        	 }
        	 System.out.println("\nYou entered:");
        	
        }
        
        else if (choice == 2) {
        	 for (int i = 0; i < size; i++) {
        			 array[i] = rand.nextInt(100);
        		 
        	}
        		 System.out.println("\nRandomly generated numbers:");
        	
        }
        
        else {
                System.out.println("Invalid choice! Defaulting to random numbers.");
                for (int i = 0; i < size; i++) {
                     array[i] = rand.nextInt(100);
                 }
    
        }

        
        for (int num : array) {
        	System.out.print(" " +num);
        }
        System.out.println("\n");
    
        return array;
	}
        
}

