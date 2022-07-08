package javatester;

public class Topic_02_AND_OR {
	public static void main(String[] args) {
		boolean answerPersonA;
		boolean answerPersonB;
		boolean resultC;
		
		//And
		answerPersonA = true;
		answerPersonB = false;		
		System.out.println("1. A && B " + (answerPersonA && answerPersonB));
		System.out.println("1. A || B " + (answerPersonA || answerPersonB));
		
		answerPersonA = false;
		answerPersonB = true;
		System.out.println("2. A && B " + (answerPersonA && answerPersonB));
		System.out.println("2. A || B " + (answerPersonA || answerPersonB));
		
		answerPersonA = false;
		answerPersonB = false;
		System.out.println("3. A && B " + (answerPersonA && answerPersonB));
		System.out.println("3. A || B " + (answerPersonA || answerPersonB));
		
		answerPersonA = true;
		answerPersonB = true;
		System.out.println("4. A && B " + (answerPersonA && answerPersonB));
		System.out.println("4. A || B " + (answerPersonA || answerPersonB));
		
		System.out.println(!answerPersonA);
	}

}
