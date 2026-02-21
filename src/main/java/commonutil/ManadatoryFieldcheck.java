package commonutil;

public class ManadatoryFieldcheck {

	public static String  manadatorymessage(String fieldname) {
		String manadatoryfield=fieldname+" is required.";
		return manadatoryfield;
	}
//	public static String getManadatoryFieldMessage(String fieldname) {
//		RegisterPage registerPage = new RegisterPage();
////		String actualmessage=(String) registerPage.getManadatoryFieldErrorMessage(fieldname);
////		return actualmessage;
//	}



}
