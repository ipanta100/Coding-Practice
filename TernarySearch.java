import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TernarySearch {  
    public static int search(int[] a, int key, int Low, int High) {
        int One_Third = ((High+1)-Low)/3;
        int Two_Thirds = ((2*((High+1)-1))/3);

        if (key > a[Two_Thirds]) {
        	System.out.println("The key is in the top thirds");
        	return search(a, key, Two_Thirds +1, High);
        } 
    	else if (key > a[One_Third]) {
            System.out.println("The key is in the top thirds");
            return search(a, key, One_Third +1, Two_Thirds);
        } 
        else if (key < a[One_Third]) {
            System.out.println("The key is in the second thirds");
            return search(a, key, Low, One_Third -1);
        } 
        else {
        	System.out.println("Key "+ key +" was not found");
            return -1;
        }
    }

    public static void main(String[] args) {
    	
    	System.out.println("How big do you want the array to be: ");
    	Scanner keyboard = new Scanner(System.in);
    	int size = keyboard.nextInt();
    	int[] array= new int[size];
    	System.out.println("Array before sorting");
    	for (int i = 0; i < size; i++){
    		Random rand = new Random();
    		array[i] = rand.nextInt(100);
    		System.out.print(array[i] + " ");
    	}
    	System.out.println("\nArray after sorting");
    	Arrays.sort(array);
        System.out.print(Arrays.toString(array));
        
        System.out.println("\nEnter a key to find: ");
        Scanner kb = new Scanner(System.in);
    	int key = kb.nextInt();
        
        int keyIndex = search(array, key, 0, array.length-1);
        if (keyIndex != -1) {
            System.out.println("Key " + key + " was found");
        }
    }

}