<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="./scripts/jquery-ui.min.js" />
<link rel="stylesheet" type="text/css" media="screen" href="./resources/jqGrid/css/ui.jqgrid.css" />

 <script src="./resources/jqGrid/js/jquery-1.7.2.min.js" type="text/javascript"></script>
 <script src="./resources/jqGrid/js/jquery.jqGrid.src.js" type="text/javascript"></script>
 <script src="./resources/jqGrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>


<script>

$(function () {
    $("#list").jqGrid({
   
    	url:'getBoardListAjax',
    	datatype:"json",
        colNames: ["seq", "작성자", "제목", "작성일자", "조회수"], 				//필수
        colModel: [															//필수
            { name: "seq", width: 55 },
            { name: "writer", width: 90 },
            { name: "title", width: 80, align: "right" },
            { name: "regDate", width: 80, align: "right" },
            { name: "cnt", width: 80, align: "right" },
        ],
        pager: "#pager", 													//필수
        rowNum: 10, //default 10
        rowList: [10, 20, 30],
        sortname: "invid",
        sortorder: "desc",
        viewrecords: true,
        gridview: true,
        autoencode: true,
        caption: "My first grid"
    }); 
}); 
jQuery("#list").jqGrid('navGrid','#pager2',{edit:false,add:false,del:false});
</script>
</head>
<body>
 	<table id="list"><tr><td></td></tr></table> 
    <div id="pager"></div> 
  
</body>
</html>