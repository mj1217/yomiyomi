package com.yedam.app.sampledata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SampleList {

	
	
	
	
	public List<Map<String,Object>> getSampleList(String filepath){
		
		
		FileInputStream fis;
		HSSFWorkbook workbook = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> val = null;
		try {
			System.out.println(filepath);
			fis = new FileInputStream(filepath);
			try {
				workbook = new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rowindex = 0;
		int columnindex = 2;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		HSSFSheet sheet = workbook.getSheetAt(0);
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = 4; rowindex < rows; rowindex++) {
			// 행을 읽는다
			HSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells(); // 4~9

				// 셀값을 읽는다

				HSSFCell[] cell = new HSSFCell[8];

				for (int i = 0; i < 8; i++) {

					cell[i] = row.getCell((columnindex + i));
				}

				String[] value = new String[8];

				for (int i = 0; i < 8; i++) {
					// 셀이 빈값일경우를 위한 널체크
					if (cell[i] == null) {
						continue;
					} else {
						// 타입별로 내용 읽기
						switch (cell[i].getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							value[i] = cell[i].getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value[i] = cell[i].getNumericCellValue() + "";

							break;
						case HSSFCell.CELL_TYPE_STRING:
							value[i] = cell[i].getStringCellValue() + "";

							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value[i] = cell[i].getBooleanCellValue() + "";

							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value[i] = cell[i].getErrorCellValue() + "";

							break;
						}
					}
				}
				val = new HashMap<String, Object>();
				val.put("day", value[0].trim());
				val.put("card", value[1]);
				val.put("name", value[2]);
				val.put("classs", value[3].trim());
				val.put("start", value[4]);
				val.put("end", value[5]);
				val.put("in", value[6]);
				val.put("out", value[7]);
				list.add(val);
			}
		}
		
		
		
		
		return list;
		
		
	}
	
	
	
	
	
}//end of class

