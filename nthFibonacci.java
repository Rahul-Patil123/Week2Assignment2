/*
 * Name : Rahul Ganeshwar Patil
 * Date : 12/09/2024
 * Description : [Make a program that prints nth term in fibonacci series]
 */
import java.util.Scanner;
public class nthFibonacci {
	final static Constant constant = new Constant();
	static long nthTermValue;
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int index;
		try {
            System.out.println(constant.ENTER_NTH);
            index = input.nextInt();
            if(index < 0 || index > 45) {
            	System.out.println(constant.INVALID_INPUT);
            	input.close();
            	return;
            }
            nthTermValue = nthTerm(index);
            System.out.println(index + constant.PRINT_NTH + nthTermValue);      
        } catch (Exception e) {
            System.out.println(constant.INVALID_INPUT);
        }
		input.close();
	}
	//nth term function is used to print nth term in fibonacci series where n is given index
	static long nthTerm(int index) {
		if(index == 0) {
			return (long)0;
		}
		else if(index == 1) {
			return (long)1;
		}
		else {
			return nthTerm(index - 1) + nthTerm(index - 2);
		}
	}
}