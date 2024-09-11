import java.util.Scanner;

public class BinaryToDecimal {
    static long binaryNumber;
    static Constant constant = new Constant();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println(constant.ENTER_NUMBER);
            binaryNumber = input.nextLong();
            if(binaryNumber < 0) {
            	System.out.println(constant.INVALID_INPUT);
            	input.close();
            	return;
            }
            toDecimal(binaryNumber, 0, 0);
        } catch (Exception e) {
            System.out.println(constant.INVALID_INPUT);
        }

        input.close();
    }

    public static void toDecimal(long binaryNumber, long decimalNumber,int index){
        if (binaryNumber > 0) {
            long lastElement = (binaryNumber % 10);
            if (lastElement != 0 && lastElement != 1 ) {
                System.out.println(constant.INVALID_INPUT);
                return;
            }
            decimalNumber = decimalNumber + lastElement*(int)(Math.pow(2, index));
            binaryNumber = binaryNumber/10;
            toDecimal(binaryNumber, decimalNumber, ++index);
        }else{
            System.out.println(constant.DECIMAL_NUMBER + decimalNumber);
            return;
        }
    }
}