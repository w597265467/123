package file;

/**

 * @author Administrator

 * @create 2018-03-23 15:57

 * @desc CreatJavaCode

 **/
public class CreatJavaCode {
	public static void main(String[] arg){
	    String str = "conSetNo,firsPartyName,legalPersonName,custName,respCustomerId,certId,addr,phone,email,loanCardName,loanCardNo,loanBankName,extFee,respLoanAmt,respLoanTerm,loanAmtString0,loanAmtString1,loanAmtString2,loanAmtString3,loanAmtString4,loanAmtString5,loanAmtString6,loanAmtString7,loanAmtString8,seqRepayAmt,orgRepayCardName,orgRepayCardNo,orgRepayBankName,repayCardName,repayCardNo,repayBankName,firstRepayDate,repayDate,endRepayDate,advanceReapyDay,year,month,day,firsPartyAnxinUserId,firsPartyLocation,secondPartyAnxinUserId,secondPartyLocation,businessPutoutId,prePayRate";
		String[] split = str.split(",");
		for (String s : split) {
			s = s.replace("\n","").replace(" ","");
			System.out.println("if (StringUtils.isEmpty("+s+")){\n" +
					"\t\t\t\t\t\tlog.debug(\""+s+"为空\");\n" +
					"\t\t\t\t\t}");
		}
	}

}
