/*
 * Name : Rahul Ganeshwar Patil
 * Date : 12/09/2024
 * Description : [Make a program that gives total count of consonants present in the given string]
 */

import java.util.Scanner;

public class CountConsonants {
	static boolean[] usedConsonants;
	final static Constant constant = new Constant();
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println(constant.ENTER_INPUT);
		String mainString = input.nextLine();
		if (mainString == null || mainString.isEmpty()) {
            System.out.println(constant.EMPTY_STRING);
            input.close();
            return;
        }
		char[] characterArray = new char[mainString.length()];
		characterArray = mainString.toLowerCase().toCharArray();
		usedConsonants = new boolean[26];
		countTotalConsonants(characterArray,0,0,0);
		input.close();
	}
	
	//count total consonants function is used to count total number of consonants and unique consonants as well
	public static void countTotalConsonants(char[] array, int  index,int countTotalConsonants,int uniqueConsonantsCount) {
		if(index >= array.length) {
			System.out.println(constant.TOTAL_CONSONANTS);
			System.out.println(countTotalConsonants);
			System.out.println(constant.UNIQUE_CONSONANTS);
			System.out.println(uniqueConsonantsCount);
			return; 
		}
		char character = array[index];
		if((character >= 'a'&& character <= 'z') && !(character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')) {
			countTotalConsonants++;	
			if(usedConsonants[(int)array[index] - 97] == false) {
				usedConsonants[(int)array[index] - 97] = true;
				uniqueConsonantsCount++;
			}
			index++;
			countTotalConsonants(array,index,countTotalConsonants,uniqueConsonantsCount);			
		}
		else {
			index++;
			countTotalConsonants(array,index,countTotalConsonants,uniqueConsonantsCount);
		}
		
	}
	
}
