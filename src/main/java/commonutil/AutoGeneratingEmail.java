package commonutil;

public class AutoGeneratingEmail {

	public static String  email() {
		String email="user";
		int randomnum=(int)(Math.random()*10000);
		String domain="@gmail.com";
		String autogeneratingemail=email+randomnum+domain;
		return autogeneratingemail;
//		System.out.println("Auto generated email is: "+autogeneratingemail);
	}

}
