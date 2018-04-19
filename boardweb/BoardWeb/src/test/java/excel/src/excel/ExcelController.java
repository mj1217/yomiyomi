

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.app.emp.DeptSearchVO;
import com.company.app.emp.DeptService;
import com.yedam.app.board.BoardService;
import com.yedam.app.board.BoardVO;

@Controller
public class ExcelController {
	
	@Autowired BoardService boardService;

	//엑셀출력
	@RequestMapping("/deptExcelCreate.do")
	public void excelCreate(BoardVO vo, HttpServletResponse response) throws IOException{
		
		//엑셀 wookbook 생성
		Workbook wb = new HSSFWorkbook(); // xls 버전
		
		CellStyle cs = wb.createCellStyle();
		Font f2 = wb.createFont();
		f2.setFontName("궁서체");
		f2.setItalic(true);
		cs.setFont(f2);
		
		//시트 추가
		wb.createSheet("first sheet");
		wb.createSheet();
		
		//부서목록 출력
		List<Map<String, Object>> list = boardService.getBoardListMap();
		Row row;
		Cell cell;
		Map<String,Object> map;
		Sheet sheet = wb.getSheetAt(0);
		for(int i=0; i<list.size(); i++) {
			row = sheet.createRow(i);
			map = list.get(i);
			Iterator<String> iter = map.keySet().iterator();
			int j=0;
			while(iter.hasNext()) {
				cell = row.createCell(j++);
				Object field = map.get(iter.next());
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof BigDecimal) {
					cell.setCellValue(((BigDecimal) field).doubleValue());
				} else if (field instanceof Date) {
					cell.setCellValue((Date) field);
				} else {
					cell.setCellValue(field.toString());
				}
			} 			
		}
		
		// 엑셀 파일 저장
		String filename = "c:/Temp/excel_"+System.currentTimeMillis()+".xls";
		FileOutputStream fos = new FileOutputStream(filename);
		wb.write(fos);
		fos.close();	

		//다운로드
		File uFile= new File(filename);
		String downFileName = uFile.getName();
		int fSize = (int)uFile.length();     // 파일크기 
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(uFile));
		//String mimetype = "text/html";
		String mimetype = "application/x-msdownload";
		response.setBufferSize(fSize);
		response.setContentType(mimetype);
		response.setHeader("Content-Disposition", "attachment; filename=\""	+ downFileName + "\"");
		response.setContentLength(fSize);

		FileCopyUtils.copy(in, response.getOutputStream());
		in.close();
		uFile.delete();  //엑셀파일삭제
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	//엑셀출력
	@RequestMapping("/deptExcelView.do")
	public ModelAndView excelView(BoardVO vo, HttpServletResponse response) throws IOException{
		List<Map<String, Object>> list = boardService.getBoardListMap();
		HashMap<String, Object> map = new HashMap<String, Object>();
		String[] header = {"departmentId","departmentName","managerId"};
		map.put("headers", header);
		map.put("filename", "excel_dept");
		map.put("datas", list);
		return new ModelAndView("commonExcelView", map);
	}
			
}
