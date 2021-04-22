<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="beans.Staff"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<meta http-equiv="Pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache"> 
	<meta http-equiv="Expires" content="0"> 
    <title>修改员工工资</title>
	<link href="style/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="width:1100px;margin:50px auto 0;">
      <div class="forget4">
           <div style="text-align:center"><span style="font-size:20px">修改员工工资</span></div><br>
            <form action="LUpdate" method="post">
				<span style="font-size:16px;">请输入您要修改的ID:<input type="text"  name="ID" ></span>
				<span style="font-size:16px;">请选择您要修改的时间: </span><select  name="Time1">
					<option value="2017-1">2017-1</option>
					<option value="2017-2">2017-2</option>
					<option value="2017-3">2017-3</option>
					<option value="2017-4">2017-4</option>
					<option value="2017-5">2017-5</option>
					<option value="2017-6">2017-6</option>
					<option value="2017-7">2017-7</option>
					<option value="2017-8">2017-8</option>
					<option value="2017-9">2017-9</option>
					<option value="2017-10">2017-10</option>
					<option value="2017-11">2017-11</option>
					<option value="2017-12">2017-12</option>
					</select>
				<span style="font-size:16px;">请选择您要修改的部分: </span><select  name="UpdatePart">
					<option value="Initial">应付工资</option>
					<option value="Accumulation">公积金</option>
					<option value="Social">社保</option>
					<option value="Tax">税收</option>
					<option value="Overtime">加班费</option>
					<option value="Final">实发工资</option>
					<option value="Yearbonus">年终奖</option>
					<option value="Annual">年工资</option>		
					</select>
				<span style="font-size:16px;">请输入您修改后的值:<input type="text"  name="Number" ></span>
                <br>
			<input type="button" name="Button" value="提交" onClick="Check()"style="width:100%;">     
            </form>
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