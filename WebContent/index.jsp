<%@ page language="java" import="java.util.*,beans.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>  


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<base href="<%=basePath%>">  
        
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
<title>登录页面</title>
<link href="style/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="style/js/canvas-particle.js"></script>
</head>
  
<body>
<div class="login_box">
      <div class="login_l_img"><img src="style/images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><img src="style/images/login_logo.png" /></div>
          <div class="login_name">
               <p>工资管理系统</p>
          </div>
          <form id="Login" name="Login" method="post" onsubmit="" action="Login">
              <input name="ID" type="text"  value="ID" onfocus="this.value=''" onblur="if(this.value==''){this.value='ID'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
<input name="STPassword" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
              <input style="text-align:center" type="radio" name="STRank" value="1"/><span style="font-size:15px">领导</span>          
              <input style="text-align:center" type="radio" name="STRank" value="2"/><span style="font-size:15px">员工</span><br><br>
                    验证码：  
    <img src="Number.jsp"/>  
    <input type="text" name="code"/>  
			  <input type="button" name="Button" value="登录" onClick="Check()" style="width:100%;" ><br>
			  <span ><a href="Forget1.jsp">找回密码</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span ><a href="Insert.jsp">创建账号</a></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  <span ><a href="Sign.jsp">数字签名</a></span>
          </form>
      </div>
</div>

 

<script type="text/javascript">

		function Check()
		{
			var ID=document.forms[0].ID.value;
			var STPassword=document.forms[0].STPassword.value;
			var STRank=document.forms[0].STRank.value; 		
			if(ID.length<=0)
				alert("账号不能为空！");
			else if(STPassword.length<=0)
				alert("密码不能为空！");
			else if(STRank.length<=0)
				alert("身份不能为空！");
			else {
				document.forms[0].submit();
			}
		}	
	</script>

</body>
</html>
