package com.nopcommerce.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Excel_util {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static HSSFWorkbook wb;
	public static HSSFSheet sheet;
	public static HSSFRow row;
	public static HSSFCell cell;
	
	public static void setupfile(String xlfile,String xlsheet) throws Exception {
		try {
		FileInputStream file=new FileInputStream(xlfile);
		wb=new HSSFWorkbook(file);
		sheet=wb.getSheet(xlsheet);
	}catch(Exception e) {
		throw e;
		
	}
		}
	public static int getrowcount(String xlfile,String xlsheet) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new HSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		wb.close();fi.close();
		return rowcount;
				
	}
	public static int getcellcount(String xlfile,String xlsheet,int rownum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new HSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int celcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return celcount;
		
		
	}
	public static String getceldata(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new HSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter formattor=new DataFormatter();
			String celldata=formattor.formatCellValue(cell);
			return celldata;
		}
		catch(Exception e) {
			data="";
		}
		return data;
			
	}
	public static void setcelldata(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new HSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write();
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	
}
