<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>员工查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />

</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 工资
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
    <!-- 表头-->
    <thead>
        <tr align="left" valign="middle" id="TableTitle">
			
			<td>ID</td>
			<td>姓名</td>
			<td>部门</td>	
			<td>时间</td>
			<td>应付工资</td>
			<td>公积金</td>
			<td>社保</td>
			<td>税收</td>
			<td>加班费</td>
			<td>实发工资</td>
			<td>年终奖</td>
			<td>年工资</td>
		</tr>
	</thead>
	<tbody>
	 
<% 
	      int j=Integer.parseInt(session.getAttribute("i").toString());
			for(int i=0;i<j;i++)
			{
%>
<tr> 
        <td><%=session.getAttribute("ID"+i+"")%></td>    
        <td><%=session.getAttribute("STName"+i+"")%></td>    
        <td><%=session.getAttribute("Department"+i+"")%></td>   
        <td><%=session.getAttribute("Time1"+i+"")%></td>     
        <td><%=session.getAttribute("Initial"+i+"")%></td>     
        <td><%=session.getAttribute("Accumulation"+i+"")%></td>     
        <td><%=session.getAttribute("Social"+i+"")%></td>      
        <td><%=session.getAttribute("Tax"+i+"")%></td>     
        <td><%=session.getAttribute("Overtime"+i+"")%></td>      
        <td><%=session.getAttribute("Final"+i+"")%></td>     
        <td><%=session.getAttribute("Yearbonus"+i+"")%></td>     
        <td><%=session.getAttribute("Annual"+i+"")%></td>
</tr>
<% 	
			}
%>
   
</tbody>		
	

</div>
</body>
</html>