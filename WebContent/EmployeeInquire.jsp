<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>工资查询</title>
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
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 个人信息
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
			<td>属性</td>
			<td>内容</td>
		</tr>
	</thead>
	<tbody>
	<tr>
        <td>ID：</td>        
        <td><%=session.getAttribute("ID")%></td>
    </tr>        
    <tr>
        <td>姓名：</td>         
        <td><%=session.getAttribute("STName")%></td>
    </tr>
    <tr>
        <td>职位：</td>         
        <td><%=session.getAttribute("STRank")%></td>
    </tr>
    <tr>
        <td>部门：</td>         
        <td><%=session.getAttribute("Department")%></td>
    </tr>
	
	<tr>
        <td>邮箱：</td>         
        <td><%=session.getAttribute("Email")%></td>
    </tr>
	</tbody>		
	

</div>
</body>
</html>