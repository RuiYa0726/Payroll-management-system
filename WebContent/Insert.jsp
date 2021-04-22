<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="beans.Staff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<meta http-equiv="Pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache"> 
	<meta http-equiv="Expires" content="0"> 
    <title>创建账号页</title>
	<link href="style/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body style="overflow-y:scroll;">
<div style="width:1100px;margin:50px auto 0;">
      <div class="forget3">
            <div style="text-align:center"><span style="font-size:20px">创建账号</span></div><br>
            <form action="RespInsert" method="post">
				<span style="font-size:16px;">ID:<input type="text"  name="ID" ></span>
				<span style="font-size:16px;">姓名:<input type="text"  name="STName" ></span>
				<span style="font-size:16px;">密码:<input type="password"  name="STPassword" ></span>
				<span style="font-size:16px;">身份:</span><input type="radio" name="STRank" value="领导">领导&nbsp;&nbsp;&nbsp;
					<input type="radio" name="STRank" value="员工">员工<br>
				<span style="font-size:16px;">部门: </span><select  name="Department">
					<option value="0">-请选择-</option>
					<option value="行政部">行政部</option>
					<option value="技术部">技术部</option>
					<option value="人力资源部">人力资源部</option>
					<option value="财务部">财务部</option>
					<option value="运维部">运维部</option>
					<option value="营销部">营销部</option>
					<option value="测试部">测试部</option>
					</select>
				<span style="font-size:16px;">Email:<input type="text"  name="Email" ></span>
				<span style="font-size:16px;">Question1:<input type="text"  name="Question1" ></span>
				<span style="font-size:16px;">Answer1:<input type="text"  name="Answer1" ></span>
				<span style="font-size:16px;">Question2:<input type="text"  name="Question2" ></span>
				<span style="font-size:16px;">Answer2:<input type="text"  name="Answer2" ></span>
				<span style="font-size:16px;">Question3:<input type="text"  name="Question3" ></span>
				<span style="font-size:16px;">Answer3:<input type="text"  name="Answer3" ></span>
                <br>
			<input type="button" name="Button" value="提交" onClick="Check()"style="width:100%;">     
            </form>
	  </div>
	  </div>
<script type="text/javascript">
function Check()
{
	
	var ID=document.forms[0].ID.value;
 if(ID.length<=0)
		alert("ID不能为空！");
	else {
		document.forms[0].submit();
	}
}	
</script>
          
</body>
</html>