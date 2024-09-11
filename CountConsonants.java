import java.util.Scanner;

public class CountConsonants {
	static boolean[] usedConsonants;
	static Constant constant = new Constant();
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println(constant.ENTER_INPUT);
		String mainString = input.nextLine();
		char[] characterArray = new char[mainString.length()];
		characterArray = mainString.toLowerCase().toCharArray();
		usedConsonants = new boolean[26];
		countTotalConsonants(characterArray,0,0,0);
		input.close();
	}
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
