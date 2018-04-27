package com.yedam.app.sampledata.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yedam.app.sampledata.SampleList;
import com.yedam.app.sampledata.SampleService;
import com.yedam.app.unit.UnitVO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	
	@Autowired
	SampleBybatisDAO dao;

	/* (non-Javadoc)
	 * @see com.yedam.app.sampledata.impl.SampleService#getSampleData(java.util.Map)
	 */
	@Override
	public List<Map<String,Object>> getSampleData(Map<String,Object> vo){
		
		return dao.getSampleData(vo);
	}
	
	@Override
	public Map<String,Object> getCodeName(Map<String,Object> vo){
		return dao.getCodeName(vo);
	}
	
	@Override
	public void updateAtt(Map<String,Object> vo){
		
		dao.updateAtt(vo);
	}
	
	@Override
	public void insertTimeTableAtt(Map<String,Object> vo) {
		dao.insertTimeTableAtt(vo);
	}
	
	@Override
	public List<Map<String,Object>> checkTimeTable(){
		return dao.checkTimeTable();
	}
	
	@Override
	public void getSubjectTimeList(String filepath) {

		SampleList sampleList = new SampleList();
		List<Map<String, Object>> vo = sampleList.getSampleList(filepath);

		for (Map<String, Object> test : vo) {

			System.out.println("샘플 테스트 : " + getSampleData(test));
			Map<String, Object> att = new HashMap<String, Object>();
			if (!(getSampleData(test)).isEmpty()) {

				for (int i = 0; i < (getSampleData(test)).size(); i++) {
					String code_name = (String) (getCodeName((getSampleData(test)).get(i))).get("code_name");
					int index = code_name.indexOf("~");
					String start = code_name.substring(0, index);
					String end = code_name.substring(index + 1);

					if (i == 0) {
						// 10분까지는 출석인정
						start = Integer.toString((Integer.parseInt(start) + 10));
					}
					// test.get("name"),(sampleService.getSampleData(test)).get(i).get("t_id");
					if (Integer.parseInt(((String) (test.get("in"))).replaceAll(" ", "")) < Integer.parseInt(start)
							&& Integer.parseInt(((String) (test.get("out"))).replaceAll(" ", "")) > Integer
									.parseInt(end)) {
						att.put("t_id", (getSampleData(test)).get(i).get("t_id"));
						att.put("name", ((String) test.get("name")).replaceAll(" ", ""));
						System.out.println(att.get("t_id"));
						System.out.println(att.get("name"));
						updateAtt(att);
						System.out.println("in : " + test.get("in") + " start : " + start);
						System.out.println("출석");
					} else {
						System.out.println("in : " + test.get("in") + " start : " + start);
						System.out.println("결석");
					}

				}

				//model.addAttribute("sampleList", getSampleData(test));
				System.out.println(test.get("in"));
				System.out.println(test.get("out"));
				if (((String) test.get("in")).compareTo((String) test.get("out")) < 0) {
					System.out.println("true");
				}
			}
		}
		// System.out.println(sampleService.getSampleData(vo));

		//return "sample/getSampleList";

	}
	
	
	@Override
	public List<Map<String,Object>> getExcelTimeTable(String filepath) {
		
		FileInputStream fis;
		XSSFWorkbook workbook = null;
		
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> val = null;
		try {
			fis = new FileInputStream(filepath);
			try {
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rowindex = 0;
		int columnindex = 1;
		// 시트 수 (첫번째에만 존재하므로 0을 준다)
		// 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		XSSFSheet sheet = workbook.getSheetAt(0);
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = 1; rowindex < rows; rowindex++) {
			// 행을 읽는다
			XSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells(); // 4~9

				// 셀값을 읽는다

				XSSFCell[] cell = new XSSFCell[3];

				for (int i = 0; i < 3; i++) {

					
					cell[i] = row.getCell((columnindex + i));
					
				}

				String[] value = new String[3];
				String strtemp=null;
				for (int i = 0; i < 3; i++) {
					// 셀이 빈값일경우를 위한 널체크
					if (cell[i] == null) {
						continue;
					} else {
						// 타입별로 내용 읽기
					
						switch (cell[i].getCellType()) {
						case XSSFCell.CELL_TYPE_FORMULA:
							value[i] = cell[i].getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							Date date=cell[i].getDateCellValue();
							value[i] = new SimpleDateFormat("yyyy/MM/dd").format(date);
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value[i] = cell[i].getStringCellValue() + "";

							break;
						case XSSFCell.CELL_TYPE_BLANK:
							value[i] = cell[i].getBooleanCellValue() + "";

							break;
						case XSSFCell.CELL_TYPE_ERROR:
							value[i] = cell[i].getErrorCellValue() + "";
							break;
						}
					}
				}
				val = new HashMap<String, Object>();
				val.put("day", value[0]);
				val.put("time", value[1]);
				val.put("subject", value[2]);
				list.add(val);
			}
		
	
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println("일자 : "+list.get(i).get("day"));
			System.out.println("시간 : "+list.get(i).get("time").toString().replaceAll(":", ""));
			System.out.println("과목 : "+list.get(i).get("subject"));
		}
		
		
	
	return list;
		
	}

	@Override
	public Map<String, Object> convertCode(String code_name) {
		// TODO Auto-generated method stub
		return dao.convertCode(code_name);
	}

	@Override
	public Map<String, Object> convertSubject(Map<String,Object> vo) {
		// TODO Auto-generated method stub
		return dao.convertSubject(vo);
	}

	@Override
	public Map<String,Object> getRowNum() {
		// TODO Auto-generated method stub
		return dao.getRowNum();
	}
	
	@Override
	public void insertViewTimeTable(Model model, @RequestParam int sub_no,String filepath){
		//엑셀추가 부분 시작
		
		
		
		//끝
		List<Map<String,Object>> list = getExcelTimeTable(filepath);
		Map<String,Object> input=null;
		Map<String,Object> value=null;
		int count;
		if(checkTimeTable().isEmpty()) {			
			count = 0;
		}else {
			count = ((BigDecimal)(getRowNum().get("rn"))).intValue();
			
		}
		
		for(int i=0;i<list.size();i++) {
			
			input = new HashMap<String,Object>();
			value = new HashMap<String,Object>();
			input.put("subject",list.get(i).get("subject"));
			input.put("cl_no",sub_no );
			
			String code_no= (String)convertCode(list.get(i).get("time").toString().replaceAll(":", "")).get("code_no");
			BigDecimal su_no = (BigDecimal)(convertSubject(input).get("su_no"));
				
			value.put("t_id", "s"+(++count));
			value.put("s_date", list.get(i).get("day"));
			value.put("classtime_cd", code_no);
			value.put("subject", su_no);
			value.put("temp", count);
			value.put("cl_no", sub_no);
			insertTimeTableAtt(value);
			
		}
	}
	@Override
	public void getClassMemberList(@RequestParam int sub_no){
		List<Map<String,Object>> memberlist = dao.getClassMemberList(sub_no);
		List<Map<String,Object>> timetablelist = dao.getTimetableList(sub_no);
		Map<String,Object> value=null;
		
		int count;
		if(dao.checkAttTable().isEmpty()) {			
			count = 0;
		}else {
			count = ((BigDecimal)(dao.getRowNumAtt().get("rn"))).intValue();
			
		}
		
		for(int i=0;i<memberlist.size();i++) {
			
			for(int j=0;j<timetablelist.size();j++) {
				value=new HashMap<String,Object>();
				value.put("a_id", "a"+(++count));
				value.put("s_name", memberlist.get(i).get("name"));
				value.put("attendance", 0);
				value.put("t_id", timetablelist.get(j).get("t_id"));
				dao.insertAttendance(value);
			}
		}
	}
}
