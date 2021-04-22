package servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

public class Login extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
response.setContentType("text/html");
PrintWriter out=response.getWriter();



//String ip=request.getRemoteAddr(); 
Staff S=new Staff();
StaffDAO SDAO=new StaffDAO();
Salary Sa=new Salary();
SalaryDAO SalaryDAO=new SalaryDAO();

String ID;
String STPassword;
String STRank;
String STName;
String SQL;
String Email;
String Department;
String Time1;
float Initial;
float Accumulation;
float Social;
float Tax ;
float Overtime ;
float Final;
float Yearbonus;
float Annual;
HttpSession session=request.getSession(true);
String incode = (String)request.getParameter("code");   
String rightcode = (String)session.getAttribute("rCode");  
String password=request.getParameter("password");  

if(incode.equals(rightcode)){    
   ;
    }else{  
    	response.sendRedirect("FailLogin.jsp");
    }  


ArrayList<Staff> result=new ArrayList<Staff>();
ArrayList<Salary> result1=new ArrayList<Salary>();

ID=request.getParameter("ID");
STPassword=request.getParameter("STPassword");

int c=STPassword.hashCode();//哈希函数加密密码
STPassword=""+c;

STRank=request.getParameter("STRank");

if(STRank.equals("1"))
{
	STRank="领导";
}
else if(STRank.equals("2"))
{
	STRank="员工";
}

try {
SQL="select * from Staff where ID='"+ID+"' AND STPassword='"+STPassword+"' AND STRank='"+STRank+"'";
result=SDAO.select(SQL);
S=result.get(0);
STName=S.getSTName();
Email=S.getEmail();
Department=S.getDepartment();

session.setAttribute("STName",STName);
session.setAttribute("ID",ID);
session.setAttribute("Email",Email);
session.setAttribute("Department",Department);
session.setAttribute("STRank",STRank);
SQL="select * from Salary where ID='"+ID+"'";
result1=SalaryDAO.select(SQL);
int i=0;
int j=result1.size();
while(j!=0)
{
	Sa=result1.get(i);
	Time1=Sa.getTime1();
	Initial=Sa.getInitial();
	Accumulation=Sa.getAccumulation();//公积金
	Social=Sa.getSocial();//社会保障
	Tax=Sa.getTax();//个人所得税
	Overtime=Sa.getOvertime();
	Final=Sa.getFinal();
	Yearbonus=Sa.getYearbonus();
	Annual=Sa.getAnnual();
	session.setAttribute("STName"+i+"",STName);
	session.setAttribute("ID"+i+"",ID);
	session.setAttribute("Email"+i+"",Email);
	session.setAttribute("Department"+i+"",Department);
	session.setAttribute("Time1"+i+"",Time1);
	session.setAttribute("Initial"+i+"",Initial);
	session.setAttribute("Accumulation"+i+"",Accumulation);
	session.setAttribute("Social"+i+"",Social);
	session.setAttribute("Tax"+i+"",Tax);
	session.setAttribute("Overtime"+i+"",Overtime);
	session.setAttribute("Final"+i+"",Final);
	session.setAttribute("Yearbonus"+i+"",Yearbonus);
	session.setAttribute("Annual"+i+"",Annual);

	i++;
	j--;
}
session.setAttribute("i",i-1);
if(result.size()!=0)
{
	if(STRank.equals("领导"))
	{
		response.sendRedirect("leader.jsp");
		
	}
	else if(STRank.equals("员工"))
	{
		response.sendRedirect("employee.jsp");
	}
}
else
{
	response.sendRedirect("FailLogin.jsp");
	}

}catch(Exception e) {
	e.printStackTrace();
}

out.flush();
out.close();
}


}


