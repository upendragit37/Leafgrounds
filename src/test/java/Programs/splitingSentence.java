package Programs;

public class splitingSentence {

	public static void main(String arg[]) {
		String sentence = "Primary_Key,Product Code,Category of Transaction,RSGSTIN,RSGST_State,Name of the Customer,INVOICENUMBER,Invoice Date for GST Return,Customer_State,Reverse Charge Applicable,Group_Code,Group_Code_Description,High Value Transaction,Qty,Exempted - Subsidy,Taxable_Premium_Inc_TRF_DUP,Diff_Tax_value,State_flag,"
				+ "State_Flag_Desc,Type_of_Tax,Total_Manual_GST,Total Invoice Value,Master_CS_State_Desc,Master_RS_State_Desc,INTER/INTRA,Place of Supply,Rate of Tax,Entry Date Remarks,GSTR 1 Remarks,Final Remarks are empty";
		String splitted[] = sentence.split(",");
		String newSplitted[] = new String[splitted.length];
		System.out.println(splitted.length);
		/*
		 * for (String print : splitted) System.out.println(print);
		 */
		
		for (int i = 0; i < splitted.length; i++) {
			
			if (splitted[i].contains("are empty")) {
				String split1[] = splitted[i].split("are empty");
				newSplitted[i] = split1[0];
				
			} else {
				newSplitted[i] = splitted[i];
			}
		}

		  System.out.println(newSplitted.length);
		  for (String print : newSplitted) { System.out.println(print); }		
	}
}








