package com.yedam.app.unit.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.unit.ExcelVO;
import com.yedam.app.unit.UnitService;
import com.yedam.app.unit.UnitVO;


@Service("excelService")
public class ExcelServiceImpl {
	
	@Autowired
	UnitDAO dao;
	
	@Autowired
	UnitService unitService;

	public void getSampleList(String filepath){
	
		FileInputStream fis;
		HSSFWorkbook workbook = null;

		Map<String, Object> val = null;
	
/*		//오늘 날짜 받아오기
		Calendar day = Calendar.getInstance(); 
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String today =  formatter.format(day.getTime());
		*/
		//unitVO 받아오기.
		UnitVO uvo = new UnitVO();
		ExcelVO evo = new ExcelVO();
		List<UnitVO> vo = dao.getUnitList(uvo);
		System.out.println(vo);
		
		//엑셀 파일 입력
		try {
			fis = new FileInputStream(filepath);
			try {
				workbook = new HSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int rowindex = 0; 		//행 번호.
		int columnindex = 2;	//열 번호.
	
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
				int cells = row.getPhysicalNumberOfCells(); //입력된 셀의 수(9), 열번호는 취급안함(-1).
				// 셀값을 읽는다
				HSSFCell[] cell = new HSSFCell[cells];

				for (int i = 0; i < cells; i++) {
					cell[i] = row.getCell((columnindex + i)); //셀 읽기
				}

				String[] value = new String[cells];
				for (int i = 0; i < cells; i++) {
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
							value[i] = cell[i].getStringCellValue();
							value[i] = value[i].replaceAll(" ", ""); //셀의 앞뒤 빈칸제거
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
				
			
				evo.setDay(value[0]);
				evo.setCard(value[1]);
				evo.setName(value[2]); 
				evo.setClasss(value[3]);
				evo.setStart(value[4]);
				evo.setEnd(value[5]);
				evo.setIn(value[6]);
				evo.setOut(value[7]);
				
				dao.insertExcel(evo);  //!!!!!!!!!!status 가 n 인것만 인서트 되도록 조정해야함

			
				
				
				
				
				

			}
		
		}
		dao.caculateAttend();
		
	}
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
