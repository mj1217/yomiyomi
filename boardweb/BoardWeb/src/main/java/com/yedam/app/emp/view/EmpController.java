package com.yedam.app.emp.view;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.app.board.BoardVO;
import com.yedam.app.common.Paging;
import com.yedam.app.emp.EmpService;
import com.yedam.app.emp.EmployeeVO;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String, String>();
		conditionMap.put("이름", "last_name");
		conditionMap.put("연봉", "salary");
		return conditionMap;
	}

	@RequestMapping("/getEmpList")
	public String getEmpList(Model model, EmployeeVO vo, Paging paging){
	
		paging.setTotalRecord(empService.getCount(vo));
		
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		
		model.addAttribute("empList",empService.getEmpList(vo));
		model.addAttribute("paging",paging);	
		
		return "emp/getEmpList";
		
	}

	@RequestMapping("report.do")
	public void report(HttpServletRequest request, HttpServletResponse response) throws
		Exception
		{
			try{
				HashMap<String, Object> map = new HashMap<String, Object>();
				JasperReport report = JasperCompileManager.compileReport(request.getSession().getServletContext().getRealPath("reports/empDeptReport.jrxml"));
				JRDataSource JRdataSource = new JRBeanCollectionDataSource(empService.getEmployeeAll());
				JasperPrint print = JasperFillManager.fillReport(report,map,JRdataSource);
				JRExporter exporter = new JRPdfExporter();
				OutputStream out;
				response.reset();
				out = response.getOutputStream();
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "report3.pdf");
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
				exporter.exportReport();
				out.flush();
				out.close();
			}
			catch(Exception e) {
					e.printStackTrace();
				}
			}

	
}
