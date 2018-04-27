package com.yedam.app.view.att;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.sampledata.SampleList;
import com.yedam.app.sampledata.SampleService;

@Controller
public class SampleController {

	
	@Autowired
	SampleService sampleService;
	
	@RequestMapping("/getSampleList")
	public String getSubjectTimeList(Model model,
								Locale locale) {
		
		SampleList sampleList = new SampleList();
		List<Map<String,Object>> vo = sampleList.getSampleList("dd");
		
		for(Map<String,Object> test : vo) {
		
			System.out.println("샘플 테스트 : "+sampleService.getSampleData(test));
			Map<String,Object> att = new HashMap<String,Object>();
			if(!(sampleService.getSampleData(test)).isEmpty()) {
			
			for(int i=0;i<(sampleService.getSampleData(test)).size();i++) {	 
				String code_name = (String)(sampleService.getCodeName((sampleService.getSampleData(test)).get(i))).get("code_name");
				int index = code_name.indexOf("~");
				String start = code_name.substring(0,index);
				String end = code_name.substring(index+1);
				
				if(i==0) {
					//10분까지는 출석인정
					start = Integer.toString((Integer.parseInt(start)+10));
				}
				//test.get("name"),(sampleService.getSampleData(test)).get(i).get("t_id");
				if(Integer.parseInt(((String)(test.get("in"))).replaceAll(" ",""))<Integer.parseInt(start) && Integer.parseInt(((String)(test.get("out"))).replaceAll(" ",""))>Integer.parseInt(end)) {
					att.put("t_id", (sampleService.getSampleData(test)).get(i).get("t_id"));
					att.put("name", ((String)test.get("name")).replaceAll(" ",""));
					System.out.println(att.get("t_id"));
					System.out.println(att.get("name"));
					sampleService.updateAtt(att);
					System.out.println("in : "+test.get("in")+" start : "+start);
					System.out.println("출석");
				}else {
					System.out.println("in : "+test.get("in")+" start : "+start);
					System.out.println("결석");
				}
				
			}
				
			model.addAttribute("sampleList",sampleService.getSampleData(test));
			System.out.println(test.get("in"));
			System.out.println(test.get("out"));
			if(((String)test.get("in")).compareTo( (String)test.get("out"))<0) {
				System.out.println("true");
			}
			}
		}
		//System.out.println(sampleService.getSampleData(vo));
		
		
		return "sample/getSampleList";
		
	}
}
