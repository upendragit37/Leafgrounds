package Excel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CompareExcelHeader {
	static File GSTR1file = new File("C:\\Users\\fasupport\\Documents\\GSTRINProcess\\GSTR Upload -GSTR1\\Finished files\\GSTR1 Invalid - MandatoryNotFilled_AAA.xlsx");

	static File ISDfile = new File("C:\\Users\\FAsupport19\\Downloads\\20200228171801_GSTR2A_ISD.xlsx");

	static File B2BAfile = new File("C:\\Users\\FAsupport19\\Downloads\\20200228181703_GSTR2A_B2BA.xlsx");

	static File CDNfile = new File("C:\\Users\\FAsupport19\\Downloads\\20200228192048_GSTR2A_CDN.xlsx");

	static File B2Bfile = new File("C:\\Users\\FAsupport19\\Downloads\\20200228200155_GSTR2A_B2B.xlsx");

	static File ITCfile = new File("C:\\Users\\FAsupport19\\Downloads\\20200228162236_ITC.xlsx");

	//static File GSTR2AReconfile = new File("C:\\Users\\FAsupport19\\Downloads\\20200228200155_GSTR2A_B2B.xlsx");

	static File GSTR2AReconfile = new File("C:\\Users\\FAsupport19\\Documents\\GSTRINProcess\\GSTR Upload -GSTR2A Recon\\GSTR2A_Recon Pure_original_fromRequirementDoc.xlsx");
	
	static String notMatched[] = {};
	static int rowNum = 0, count = 0;

	public void HeaderValidationInProcessedFile(File file, String header[], String Name) throws NullPointerException {
		try {
			System.out.println("---------Checking " + Name + "------");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);

			Row r = sheet1.getRow(rowNum);
			int maxCell = r.getLastCellNum();
			System.out.println("Maxcell = " + maxCell);
			for (int i = 0; i < maxCell; i++) {
				String value = sheet1.getRow(0).getCell(i).getStringCellValue();
				if (value.equals(header[i])) {
					System.out.println("Matched----------" + value);
				} else {
					// notMatched[count] = value;
					// count++;
					System.out.println("NotMatched xxxxx " + value + "  ->Correct Format is:" + header[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (notMatched.length != 0) {
			System.out.println("Not matched headers in excel are");
			System.out.println(notMatched);
		}
	}

	static String GSTR1Header[] = { "Policy No", "Endorsement No", "Primary_Key", "Filing_Month", "Product Code",
			"Category of Transaction", "RSGSTIN", "RSGST_State", "CUST_GNTIN", "Name of the Customer", "INVOICENUMBER",
			"Invoice Date for GST Return", "Customer_State", "Reverse Charge Applicable", "Group_Code",
			"Group_Code_Description", "High Value Transaction", "Qty", "Exempted - Subsidy",
			"Taxable_Premium_Inc_TRF_DUP", "Diff_Tax_value", "State_flag", "State_Flag_Desc", "Type_of_Tax",
			"IGST_Tax_Value", "CGST_Tax_Value", "SGST_Tax_Value", "UTGST_Tax_Value", "Total_Manual_GST",
			"Total Invoice Value", "Master_CS_State_Desc", "Master_RS_State_Desc", "INTER/INTRA", "Place of Supply",
			"Rate of Tax", "Entry Date Remarks", "B2B Remarks", "Credit Note Remarks", "OD/TP", "GSTR 1 Remarks",
			"Final Remarks", "Uploaded Date", "Batch No", "Uploaded File Name", "Uploaded By", "Status",
			"Status Remarks", /* "Credit Type", */ "State Id", "Fin year", "Month Id" };

	static String GSTR2A_ISDHeader[] = { "GSTIN", "PERIOD", "GSTIN(CTIN)", "COUNTER_PARTY_FILING_STATUS(CFS)",
			"ISD_DOC_TYPE(ISD_DOCTY)", "DOCUMENT_NUMBER(DOCNUM)", "DOCUMENT_DATE(DOCDT)", "ISD_TYPE(ITC_ELG)",
			"IGST_AMOUNT_AS_ISD(IAMT)", "CGST_AMOUNT_AS_ISD(CAMT)", "SGST_AMOUNT_AS_ISD(SAMT)",
			"CESS_AMOUNT_AS_ISD(CESS)", "Uploaded Date", "Batch No", "Uploaded File Name", "Uploaded By", "Status",
			"Status Remarks", "Credit Type", "State Id", "Fin year", "Month Id" };

	static String GSTR2A_B2BAHeader[] = { "GSTIN", "PERIOD", "COUNTER_PARTY_TIN(CTIN)",
			"COUNTER_PARTY_FILING_STATUS(CFS)", "INVOICE_NUMBER(INUM)", "INVOICE_DATE(IDT)", "INVOICE_VALUE(VAL)",
			"PLACE_OF_SUPPLY(POS)", "REVERSE_CHARGE(RCHRG)", "INVOICE_TYPE(INV_TYP)", "SERIAL_NUM(NUM)",
			"TOTAL_TAX_VALUE(TXVAL)", "IGST_AMOUNT(IAMT)", "CGST_AMOUNT(CAMT)", "SGST_AMOUNT(SAMT)",
			"CESS_AMOUNT(CSAMT)", "RATE(RT)", "ORIGINAL_INVOICE_NUMBER(OINUM)", "ORIGINAL_INVOICE_DATE(OIDT)",
			"Differential-percentage(diff_percent)", "FLAG(FLAG)", "TAXBLE_AMT_CESS(TX_CS)", "TAXBLE_AMT_IGST(TX_I)",
			"TAXBLE_AMT_CGST(TX_C)", "TAXBLE_AMT_SGST(TX_S)", "ELGIBLILTY(ELG)", "UPLOADED_BY(UPDBY)",
			"COUNTER_PARTY_FLAG(CFLAG)", "ORIGINAL_PERIOD(OPD)", "LEGAL_NAME", "Uploaded Date", "Batch No",
			"Uploaded File Name", "Uploaded By", "Status", "Status Remarks", "Credit Type", "State Id", "Fin year",
			"Month Id" };

	static String GSTR2A_CDNHeader[] = { "GSTIN", "PERIOD", "OUNTER_PARTY_TIN(CTIN)",
			"COUNTER_PARTY_FILING_STATUS(CFS)", "NOTE_TYPE(NTTY)", "NOTE_NUM(NT_NUM)", "NOTE_DATE(NT_DT)",
			"Pre GST Regime Dr./ Cr. Notes(P_GST)", "INVOICE_NUMBER(INUM)", "INVOICE_DATE(IDT)", "INVOICE_VALUE(VAL)",
			"SERIAL_NUM(NUM)", "RATE(RT)", "TOTAL_TAX_VALUE(TXVAL)", "IGST_AMOUNT(IAMT)", "CGST_AMOUNT(CAMT)",
			"CESS_AMOUNT(CSAMT)", "SGST_AMOUNT(SAMT)", "Differential-percentage(diff_percent)", "FLAG(FLAG)",
			"TAXBLE_AMT_CESS(TX_CS)", "TAXBLE_AMT_IGST(TX_I)", "TAXBLE_AMT_CGST(TX_C)", "TAXBLE_AMT_SGST(TX_S)",
			"ELGIBLILTY(ELG)", "UPLOADED_BY(UPDBY)", "COUNTER_PARTY_FLAG(CFLAG)", "REASON(RSN)",
			"REVERSE_CHARGE(RCHRG)", "LEGAL_NAME", "Uploaded Date", "Batch No", "Uploaded File Name", "Uploaded By",
			"Status", "Status Remarks", "Credit Type", "State Id", "Fin year", "Month Id" };

	static String GSTR2A_B2BHeader[] = { "GSTIN", "PERIOD", "COUNTER_PARTY_TIN(CTIN)",
			"COUNTER_PARTY_FILING_STATUS(CFS)", "INVOICE_NUMBER(INUM)", "INVOICE_DATE(IDT)", "INVOICE_VALUE(VAL)",
			"PLACE_OF_SUPPLY(POS)", "REVERSE_CHARGE(RCHRG)", "INVOICE_TYPE(INV_TYP)", "SERIAL_NUM(NUM)",
			"TOTAL_TAX_VALUE(TXVAL)", "IGST_AMOUNT(IAMT)", "CGST_AMOUNT(CAMT)", "SGST_AMOUNT(SAMT)",
			"CESS_AMOUNT(CSAMT)", "RATE(RT)", "Differential-percentage(diff_percent)", "FLAG(FLAG)",
			"TAXBLE_AMT_CESS(TX_CS)", "TAXBLE_AMT_IGST(TX_I)", "TAXBLE_AMT_CGST(TX_C)", "TAXBLE_AMT_SGST(TX_S)",
			"ELGIBLILTY(ELG)", "UPLOADED_BY(UPDBY)", "COUNTER_PARTY_FLAG(CFLAG)", "LEGAL_NAME", "Uploaded Date",
			"Batch No", "Uploaded File Name", "Uploaded By", "Status", "Status Remarks", "Credit Type", "State Id",
			"Fin year", "Month Id" };

	static String ITCHeader[] = { "Supplier Name", "Supp Gst No", "Document Type (Invoice/DN/CN)", "Document No.",
			"Document Date", "Voucher Date", "Taxable Value", "Tax Rate", "IGST Amount(ITC)", "SGST Amount(ITC)",
			"CGST Amount(ITC)", "Cess Amount(ITC)", "RCM (Mention Y/N)", "ITC on Import of Goods (Mention Y/N)",
			"Extra Field 1", "Extra Field 2", "RS GSTIN", "RS State", "Uploaded Date", "Batch No", "Uploaded File Name",
			"Uploaded By", "Status", "Status Remarks", /* "Credit Type" */ "State Id", "Fin year", "Month Id" };

	static String GSTR2A_RECONHeader[] = { "Category", "Match Type", "Combined GSTIN", "[2A] Type", "[2A] GSTIN",
			"[BK] GSTIN", "[2A] Name", "[BK] Name", "[2A] Invoice No", "[BK] Invoice No", "[2A] Note No",
			"[2A] Bill Date", "[BK] Bill Date", "[BK] Voucher date", "[2A] Taxable Value", "[2A] CGST", "[2A] SGST",
			"[2A] IGST", "[2A] CESS", "[BK] Taxable Value", "[BK] CGST", "[BK] SGST", "[BK] IGST", "[BK] CESS",
			"[Diff] Taxable Value", "[Diff] CGST", "[Diff] SGST", "[Diff] IGST", "[Diff] CESS", "[2A] Doc Type",
			"[BK] Doc Type", "[2A] RCM", "[BK] RCM", "[BK] Import", "[BK] Eligible", "[2A] Status", "Extra Field 1",
			"Extra Field 2", "Uploaded Date", "Batch No", "Uploaded File Name", "Uploaded By", "Status",
			"Status Remarks", "State Id", "Fin year", "Month Id", "Payment Status" };

	
	public static void main(String arg[]) {

		CompareExcelHeader execute = new CompareExcelHeader();

		execute.HeaderValidationInProcessedFile(GSTR1file, GSTR1Header, "GSTR1");
		execute.HeaderValidationInProcessedFile(ISDfile, GSTR2A_ISDHeader, "GSTR2A-ISD");
		execute.HeaderValidationInProcessedFile(B2BAfile, GSTR2A_B2BAHeader, "GSTR2A-B2BA");
//
		execute.HeaderValidationInProcessedFile(CDNfile, GSTR2A_CDNHeader, "GSTR2A-CDN");
//		execute.HeaderValidationInProcessedFile(B2Bfile, GSTR2A_B2BHeader, "GSTR2A-B2B");
//		execute.HeaderValidationInProcessedFile(ITCfile, ITCHeader, "ITC");
//		execute.HeaderValidationInProcessedFile(GSTR2AReconfile, GSTR2A_RECONHeader, "GSTR2A_Recon");

	}
}