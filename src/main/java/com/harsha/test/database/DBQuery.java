package com.harsha.test.database;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class DBQuery {
	
	public static int testingrest(String regd, DBManager dbManager) {

		System.out.println("testingrest");
		
		int counter = 0;
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call testingrest(?,?)");
			
			pstm.setString(1, regd);
			pstm.registerOutParameter(2, Types.INTEGER);
			
			pstm.executeQuery();
			
			counter = pstm.getInt(2);
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return counter;
		
	}

}
