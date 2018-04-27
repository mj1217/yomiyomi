<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%> 
<%@ page import="java.io.*"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<html>  
<head><title>���ε� ����</title></head>
<body>
<%
String up_url = request.getContextPath()+"/upload"; // �⺻ ���ε� URL
String up_dir = "/upload"; // �⺻ ���ε� ����
String save_url = "";
String save_dir = "";
// ���ε� DIALOG ���� ���۵� ��
String funcNum = "" ;
String CKEditor = "" ;
String langCode = "" ;

 funcNum = request.getParameter("CKEditorFuncNum") ;
 CKEditor = request.getParameter("CKEditor") ;
 langCode = request.getParameter("langCode") ;

	// 1. multipart/form-data ���� Ȯ��
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if (isMultipart) {
		// 2. �޸𸮳� ���Ϸ� ���ε� �����͸� �����ϴ� FileItem�� Factory ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024*10);
		factory.setRepository(new File("c:/Tmp"));

		// 3. ���ε� ��û�� ó���ϴ� ServletFileUpload ����
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 4. ���ε� ��û �Ľ��ؼ� FileItem ��� ����
		List<FileItem> items = upload.parseRequest(request);
		
		Iterator<FileItem> iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = iter.next();
			// 5. FileItem�� �� �Է� �׸����� ���ο� ���� �˸��� ó��
			if (!item.isFormField()) {
				//String name = item.getFieldName();
				String fileName = item.getName();
				long sizeInBytes = item.getSize();
				int pos = fileName.lastIndexOf("\\");
				if ( pos >=0 )
					fileName = fileName.substring(pos+1);
				//���� ����
				save_url = up_url +"/" +  fileName;
				save_dir = application.getRealPath(up_dir) + "/" + fileName ; // "C:/workspace_jsp/myproj/WebContent/upload/"
				item.write(new File(save_dir));		
			}
		}
		out.print("<script>window.parent.CKEDITOR.tools.callFunction(" + funcNum + ", '"+save_url+"', '���ε�Ϸ�');</script>");		
	} 
%>
</body>
</html>