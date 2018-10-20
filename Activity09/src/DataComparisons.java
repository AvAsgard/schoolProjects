import java.util.*;

public class DataComparisons 
{
	public static void main(String[] args)
	{
		double intOne, intTwo;
		intOne = 1.0;
		intTwo = 0.9;
		double intResult = intOne - intTwo;
		if(Math.abs(intResult-0.1)<=intTwo) {
			System.out.println("The result is "+intResult+ " which is equal.");
		} else {
			System.out.println("The result is "+intResult+" which is not equal.");
		}
		Scanner scan = new Scanner(System.in);
		String code = scan.next();
		
		if(code=="nee") {
			System.out.println("Access granted.");
		} else {
			System.out.println("Access denied.");
		}
		
	}
	
	

}
