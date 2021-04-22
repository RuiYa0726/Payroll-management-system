<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="beans.Staff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<meta http-equiv="Pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache"> 
	<meta http-equiv="Expires" content="0"> 
    <title>数字签名</title>
	<link href="style/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="width:1100px;margin:50px auto 0;">
      <div class="forget2">
           <div style="text-align:center"><span style="font-size:20px">数字签名</span></div><br>
            <form action="Sign" method="post">
				<span style="font-size:16px;">
				请输入您要签名的内容：<input type="text"  name="Sign" ></span>
                <br>
			<input type="button" name="Button" value="提交" onClick="Check()"style="width:100%;">     
            </form>
<script type="text/javascript">
function Check()
{
	
	var Sign=document.forms[0].Sign.value;

 if(Sign.length<=0)
		alert("内容不能为空！");
	else {
		document.forms[0].submit();
	}
}	
</script>
          
</body>
</html>
