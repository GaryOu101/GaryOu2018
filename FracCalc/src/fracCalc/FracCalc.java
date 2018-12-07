package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String Fractions = userInput.next();
		System.out.println(produceAnswer(Fractions));




	}









	// TODO: Read the input from the user and call produceAnswer with an equation



	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	//      e.g. input ==> "1/2 + 3/4"
	//        
	// The function should return the result of the fraction after it has been calculated
	//      e.g. return ==> "1_1/4"
	public static String produceAnswer(String input)
	{ 
		// TODO: Implement this function to produce the solution to the input
		String[] number = input.split(" ");  
		String operand1 = number[0];
		String operator = number[1];
		String operand2 = number[2];
		int[] op1 = separate(operand1);
		int[] op2 = separate(operand2);
	
		//return ("whole:"+op2[0] + " numerator:" + op2[1] + " denominator:" + op2[2]); 
	
		int LCM = (op1[2] * op2[2]);     //this accounts for fracs like 1/2 + 1/3
		op1[1] = ((op1[0] * op1[2]) + op1[1]);
		op1[1] = (op1[1] * op2[2]);
		op2[1] = (op2[2] * op1[1]);
		// changes mixed into improper
		op1[2] = (LCM * op1[1]);    // this multiplies by a common multiple. I just multiplied the two denominators to get the multiple.
		op2[2] = (LCM * op2[1]);
	
		
		// string1.equals(string2)
		if (number[1].equals("+")) {
		op1[1] = (op1[1] + op2[2]);
		                                  // addition calculation
		}
		
		else if (number[1].equals("+")) {
			op1[1] = (op1[1] - op2[1]);     // subtraction calculation
			
		}
		else if (number[1].equals("+")) {
			op1[1] = (op1[1] * op2[1]);    // multiplication calculation
			op2[2] = (op2[2] * op1[2]);
		}
		else  {
			op1[1] = op1[1] * op2[2];     //division calculation
			op1[2] = op1[2] * op2[1];
		}
		return (op1[1] + "/" + op1[2]);
			
			
			
			
		}
		
		
		
		

	
	public static int[] separate(String input) {

		
		int[] parsed = {0, 0, 1};
		String [] frac2 = input.split("_");
		if (frac2.length ==2) {
			parsed[0] = Integer.parseInt(frac2[0]);	
			String[] number3 = frac2[1].split("/");
			parsed[1] = Integer.parseInt( number3[0]);
			parsed[2] = Integer.parseInt(number3[1]);
		
		}
		else if (frac2.length == 1) {
			String [] noWhole = input.split("/");
			if(noWhole.length ==2) {
			parsed[1] = Integer.parseInt(noWhole[0]);
			parsed[2] = Integer.parseInt(noWhole[1]);
			
			}
			else {
				parsed[0] = Integer.parseInt(noWhole[0]);
			
			}
		
			
		}
		return parsed;
	}
	
	

}
				
				
			
		

	





