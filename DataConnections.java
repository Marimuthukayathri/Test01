package frameworkCore;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataConnections {
	
	static Connection connection = null;
	static Recordset recordset = null;
	
	//To read the data from the Excel
	public static Recordset qry_DataFile(String strQuery)
	{
		
		try {
			Fillo fillo=new Fillo();
			//connection=fillo.getConnection("./test_data/JMS_Framework.xlsx");
			connection=fillo.getConnection("./test_Data/JMS_Longbow_Frameworks.xlsm");
			//connection=fillo.getConnection("./test_Data/MCS.xlsm");
//			String strQuery="Select * from API_Business_Flow where Exec_Flag='YES'";
			recordset=connection.executeQuery(strQuery);
			//recordset.close();
			connection.close();
		}catch (Exception e){
		 System.out.println(e);
		}
		return recordset;
	}
	
	
	//To Write the data to the Excel
	public static void update_DataFile(String strQuery)
	{
		
		try {
			Fillo fillo=new Fillo();
			//connection=fillo.getConnection("./test_data/JMS_Framework.xlsx");
			connection=fillo.getConnection("./test_Data/JMS_Longbow_Frameworks.xlsm");
			//connection=fillo.getConnection("./test_Data/MCS.xlsm");
//			String strQuery="Select * from API_Business_Flow where Exec_Flag='YES'";
			connection.executeUpdate(strQuery);
			//recordset.close();
			connection.close();
		}catch (Exception e){
		 System.out.println(e);
		}
	}
}
