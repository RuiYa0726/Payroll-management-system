package servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import beans.Staff;
import beans.StaffDAO;

public class ResponseForget extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8"); //设置输出编码格式
PrintWriter out=response.getWriter();

Staff STUser=new Staff();
StaffDAO STUserDAO=new StaffDAO();

String ID;
String Answer1;
String Answer2;
String Answer3;
String SQL;
ArrayList<Staff> result=new ArrayList<Staff>();

ID=request.getParameter("ID");
Answer1=request.getParameter("Answer1");
Answer2=request.getParameter("Answer2");
Answer3=request.getParameter("Answer3");

try {
SQL="select * from Staff where ID='"+ID+"';";
result=STUserDAO.select(SQL);
STUser=result.get(0);

if(STUser.getAnswer1().trim().equals(Answer1)&&STUser.getAnswer2().trim().equals(Answer2)&&STUser.getAnswer3().trim().equals(Answer3))
	{
	response.sendRedirect("NewPassword.jsp");
}
else
	{
		response.sendRedirect("FailNewPassword.jsp");
	}
}catch(Exception e) {
	e.printStackTrace();
}

out.flush();
out.close();
}
}

