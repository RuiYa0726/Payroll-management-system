package servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;

import beans.StaffDAO;
import beans.Staff;



public class ResponseNewPassword extends HttpServlet{
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
String STPassword;
ID=request.getParameter("ID");
STPassword=request.getParameter("STPassword");
String SQL;
ArrayList<Staff> result=new ArrayList<Staff>();

try {
	SQL="select * from Staff where ID='"+ID+"'";
	result=STUserDAO.select(SQL);
	STUser=result.get(0);
	STUser.setSTPassword(STPassword);
	STUserDAO.updatePassword(STUser);
	response.sendRedirect("SuccessNewPassword.jsp");
}catch(Exception e) {
	e.printStackTrace();
}


out.flush();
out.close();
}
}


