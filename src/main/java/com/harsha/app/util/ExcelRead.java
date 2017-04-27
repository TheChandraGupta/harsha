package com.harsha.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.harsha.app.constant.Constant;
import com.harsha.app.database.DBManager;
import com.harsha.app.database.DataUpload;

public class ExcelRead {
	
	@SuppressWarnings("deprecation")
	private Object getCellValue(Cell cell) {
		System.out.println(cell.getCellStyle());
	    switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
			System.out.println("" + cell.getStringCellValue());
	        return "" + cell.getStringCellValue();	 
	    case Cell.CELL_TYPE_BOOLEAN:
			System.out.println("" + cell.getBooleanCellValue());
	        return "" + cell.getBooleanCellValue();	 
	    case Cell.CELL_TYPE_NUMERIC:
			System.out.println("" + cell.getNumericCellValue());
	        return "" + (int) Double.parseDouble(String.valueOf(cell.getNumericCellValue()));
	    }
	 
	    return null;
	}
	
	public static String generateExcelReport(JSONArray jsonArray, String fileNameGiven) {
		String fileNameAssigned = new Date().getTime()/1000 + ".xls";
		System.out.println(fileNameAssigned);
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
		    HSSFSheet sheet = workbook.createSheet(fileNameGiven);
		    HSSFRow rowhead = sheet.createRow((short) 0);

			System.out.println(fileNameAssigned);
		    JSONObject jObj1 = jsonArray.getJSONObject(0);
			Iterator<String> keys = jObj1.keys();
			int col = 0;
			while(keys.hasNext()) {
				String key = keys.next();
				rowhead.createCell((short) col).setCellValue(key);
				col++;
			}
		    for(int i = 0; i<jsonArray.length(); i++) {
		        HSSFRow row = sheet.createRow((short) i+1);
		    	JSONObject jObj = jsonArray.getJSONObject(i);
		    	Iterator<String> it = jObj.keys();
		    	col = 0;
        		while(it.hasNext()) {
					String key = it.next();
					row.createCell((short) col).setCellValue(jObj.getString(key));
					col++;
        		}		        
		    }
		    String path = Constant.DATA_DRIVE + fileNameAssigned;
			System.out.println(path);
		    FileOutputStream fileOut = new FileOutputStream(path);
		    workbook.write(fileOut);
		    fileOut.close();
	    } catch (FileNotFoundException e1) {
	        e1.printStackTrace();
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    } catch (JSONException e) {
			e.printStackTrace();
		}
		DBManager dbManager = new DBManager();
		DataUpload.insertNewUploadFileDetails(fileNameGiven, fileNameAssigned, dbManager);
		dbManager.close();
		return fileNameAssigned;
	}
	
	public JSONArray readBooksFromExcelFile(String excelFilePath, String excelType) throws IOException {
		JSONArray jArray = new JSONArray();
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	 
	    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	    
	    while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        JSONObject jObj = new JSONObject();
	 
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	            if(excelType.equals("Family")) {
	            	jObj = fetchFamilyDetails(jObj, columnIndex, nextCell);
	            }
	            else if(excelType.equals("Member")) {
	            	jObj = fetchMemberDetails(jObj, columnIndex, nextCell);
	            }
	        }
	        jArray.put(jObj);
	    }
	    workbook.close();
	    inputStream.close();
	    return jArray;
	}
	
	public JSONObject fetchFamilyDetails(JSONObject jObj, int columnIndex, Cell nextCell) {
		System.out.println(jObj.toString() + "-" + columnIndex);
        try {
        	switch (columnIndex) {
            case 0:
            	jObj.put("houseHoldId", getCellValue(nextCell));
                break;
            case 1:
            	jObj.put("villageCode", getCellValue(nextCell)); // Test
                break;
            case 2:
            	jObj.put("income", getCellValue(nextCell)); //
                break;
            case 3:
            	jObj.put("savings", getCellValue(nextCell));
                break;
            case 4:
            	jObj.put("surveyPeriod", getCellValue(nextCell));
                break;
            }
        }
        catch(JSONException e) {
        	e.printStackTrace();
        }
		System.out.println(jObj.toString() + "-" + columnIndex);
		return jObj;
	}
	
	public JSONObject fetchMemberDetails(JSONObject jObj, int columnIndex, Cell nextCell) {
		System.out.println(jObj.toString() + "-" + columnIndex);
        try {
        	switch (columnIndex) {
            case 0:
            	jObj.put("houseHoldId", getCellValue(nextCell));
                break;
            case 1:
            	jObj.put("villageCode", getCellValue(nextCell)); // Test
                break;
            case 2:
            	jObj.put("memberName", getCellValue(nextCell)); //
                break;
            case 3:
            	jObj.put("genderCode", getCellValue(nextCell));
                break;
            case 4:
            	jObj.put("socialCategoryCode", getCellValue(nextCell));
                break;
            case 5:
            	jObj.put("religionCode", getCellValue(nextCell));
                break;
            case 6:
            	jObj.put("relationshipCode", getCellValue(nextCell));
                break;
            case 7:
            	jObj.put("dob", getCellValue(nextCell));
                break;
            case 8:
            	jObj.put("maritalStatusCode", getCellValue(nextCell));
                break;
            case 9:
            	jObj.put("occupationCode", getCellValue(nextCell));
                break;
            case 10:
            	jObj.put("educationCode", getCellValue(nextCell));
                break;
            case 11:
            	jObj.put("educationStatusCode", getCellValue(nextCell));
                break;
            case 12:
            	jObj.put("aadharCard", getCellValue(nextCell));
                break;
            case 13:
            	jObj.put("voterId", getCellValue(nextCell));
                break;
            case 14:
            	jObj.put("jobCard", getCellValue(nextCell));
                break;
            case 15:
            	jObj.put("bplCard", getCellValue(nextCell));
                break;
            case 16:
            	jObj.put("disabilitiesCode", getCellValue(nextCell));
                break;
            case 17:
            	jObj.put("schemeCode", getCellValue(nextCell));
                break;
            case 18:
            	jObj.put("approvalStatus", getCellValue(nextCell));
                break;
            case 19:
            	jObj.put("approvalRemark", getCellValue(nextCell));
                break;
            }
        }
        catch(JSONException e) {
        	e.printStackTrace();
        }
		System.out.println(jObj.toString() + "-" + columnIndex);
		return jObj;
	}
	
}
