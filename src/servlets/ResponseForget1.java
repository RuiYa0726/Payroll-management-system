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



public class ResponseForget1 extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

Staff STUser=new Staff();
StaffDAO STUserDAO=new StaffDAO();



String ID;
String Question1;
String Question2;
String Question3;
ID=request.getParameter("ID");
String SQL;
ArrayList<Staff> result=new ArrayList<Staff>();
HttpSession session=request.getSession(true);
session.setAttribute("ID",""+ID+"");

try {
	SQL="select * from Staff where ID='"+ID+"'";
	result=STUserDAO.select(SQL);
	STUser=result.get(0);
	Question1=STUser.getQuestion1();
	Question2=STUser.getQuestion2();
	Question3=STUser.getQuestion3();
	session.setAttribute("Question1",""+Question1+"");
	session.setAttribute("Question2",""+Question2+"");
	session.setAttribute("Question3",""+Question3+"");
	response.sendRedirect("Forget.jsp");
}catch(Exception e) {
	e.printStackTrace();
}


out.flush();
out.close();
}
}


