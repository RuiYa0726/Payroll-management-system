<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
           <div style="text-align:center"><span style="font-size:20px">密码找回</span></div>
            <form action="ResponseForget" name="form" method="post">
				<p style="font-size:16px;">ID:<input type="text"  name="ID" ></p>
                <p style="font-size:16px;">问题一：<%=session.getAttribute("Question1")%> <input type="text"  name="Answer1" ></p>
                <p style="font-size:16px;">问题二：<%=session.getAttribute("Question2")%> <input type="text"  name="Answer2" ></p>
                <p style="font-size:16px;">问题三：<%=session.getAttribute("Question3")%><input type="text"  name="Answer3" ></p>
			<input type="button" name="Button" value="提交" onClick="Check()"style="width:100%;">     
            </form>
<script type="text/javascript">
function Check()
{
	var Answer1=document.forms[0].Answer1.value;
	var Answer2=document.forms[0].Answer2.value;
	var Answer3=document.forms[0].Answer3.value;
	var ID=document.forms[0].ID.value;
	
	if(Answer1.length<=0)
		alert("答案一不能为空！");
	else if(Answer2.length<=0)
		alert("答案二不能为空！");
	else if(ID.length<=0)
		alert("ID不能为空！");
	else if(Answer3.length<=0)
		alert("答案三不能为空！");
	else {
		document.forms[0].submit();
	}
}	
</script>
          
</body>
</html>
   