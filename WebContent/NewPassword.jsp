<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="beans.Staff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<meta http-equiv="Pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache"> 
	<meta http-equiv="Expires" content="0"> 
    <title>密码找回页</title>
	<link href="style/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="width:1100px;margin:50px auto 0;">
      <div class="forget">
           <div style="text-align:center"><span style="font-size:20px">密码重置</span></div>
            <form action="ResponseNewPassword" method="post">
				<p style="font-size:16px;">ID:<input type="text"  name="ID" ></p>
                <p style="font-size:16px;">密码：<input type="password"  name="STPassword" ></p>
                <p style="font-size:16px;">密码确认： <input type="password"  name="STPassword1" ></p>

			<input type="button" name="Button" value="提交" onClick="Check()"style="width:100%;">     
            </form>
<script type="text/javascript">
function Check()
{
	var ID=document.forms[0].ID.value;
	var STPassword=document.forms[0].STPassword.value;
	var STPassword1=document.forms[0].STPassword1.value;
	if(ID.length<=0)
		alert("ID不能为空！");
	else if(STPassword.length<=0)
		alert("密码不能为空！");
	else if(STPassword1.length<=0)
		alert("密码确认不能为空！");
	else if(STPassword!=STPassword1)
		alert("密码与确认密码不同！");
	else {
		document.forms[0].submit();
	}
}	
</script>
          
</body>
</html>
  