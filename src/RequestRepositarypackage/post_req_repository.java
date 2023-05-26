package RequestRepositarypackage;

import java.io.IOException;
import java.util.ArrayList;

import Commonfunctionpackage.Utility_commonfunction;


public class post_req_repository {
public static String base_URI() {
	String base_URI="https://reqres.in/";
    return base_URI;	
}

public static String post_resource() {
String resource="/api/users"	;
return resource;
}

	
public static String post_req_Tc_1() throws IOException{
ArrayList<String> data=Utility_commonfunction.readDataExcel("Post_Test_Data","post_Tc_1");
String req_name = data.get(1);
String req_job =data.get(2);
String requestBody="{\r\n"
		+ "    \"name\": \""+req_name+"\",\r\n"
		+ "    \"job\": \""+req_job+"\"\r\n"
		+ "}";	
  return requestBody;
  
  

}


}



