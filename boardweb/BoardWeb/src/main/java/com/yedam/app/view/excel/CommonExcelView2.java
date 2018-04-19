package com.yedam.app.view.excel;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

@SuppressWarnings("deprecation")
@Component("commonExcelView2")
public class CommonExcelView2 extends AbstractExcelView { //스프링에서 제공하는 엑셀뷰

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonExcelView2.class);
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook wb, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
	
		List<Object> categories =(List<Object>) model.get("category");
		
		HSSFCell cell = null;
		HSSFSheet sheet = wb.createSheet("Board List");
		
		for (int i = 0; i < categories.size(); i++) {
			LOGGER.debug("### buildExcelDocument Map : {} started!!", i);
			Map<String, Object> category = (Map<String, Object>) categories.get(i);
			/*cell = getCell(sheet, 3 + i, 0);
			setText(cell, category.get("SEQ").toString());
			cell = getCell(sheet, 3 + i, 1);
			setText(cell, (String)category.get("TITLE"));
			cell = getCell(sheet, 3 + i, 2);
			setText(cell, category.get("REGDATE").toString());
			cell = getCell(sheet, 3 + i, 3);
			setText(cell, category.get("CNT").toString());*/
		
			Set<String> keySet = category.keySet();
			Iterator<String> iter = keySet.iterator();
			
			int j=0;
			while(iter.hasNext()) {
				cell = getCell(sheet,3+i,j++);
				setText(cell,category.get(iter.next()).toString());  //instanceof 활용가능, key 순서 제어하면 원하는 순서대로 값 받을 수 있ㅇㅁ
			}
			
			LOGGER.debug("### buildExcelDocument Map : {} end!!", i);
			
			
		}
	}

}
