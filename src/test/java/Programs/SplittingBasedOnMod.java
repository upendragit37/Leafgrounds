package Programs;

public class SplittingBasedOnMod {
	public static void main(String args[]) {
		String Num[] = { "100%", "200%", "30%", "10%" };
		String Temp1[] = new String[2];
		int numLength = Num.length;
		int  minNum=1000;
		String Number[] = new String[numLength];
		
		for (int j = 0; j < numLength; j++) {
			
			 Temp1 = Num[j].split("%");
			 Number[j] = Temp1[0];
		}
		
		
		
		for(String print: Number) {
			System.out.println(print);
			int temp = Integer.parseInt(print);	
			//System.out.println(temp);
			if(minNum >temp)
				minNum=temp;
				
		}
		System.out.println("Minimum Number="+minNum);
	}
}