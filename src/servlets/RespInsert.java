package servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Staff;
import beans.StaffDAO;
import beans.SalaryDAO;
import beans.Salary;

public class RespInsert extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
response.setContentType("text/html");
request.setCharacterEncoding("utf-8");
PrintWriter out=response.getWriter();

Staff S=new Staff();
StaffDAO SDAO=new StaffDAO();
Salary S1=new Salary();
SalaryDAO S1DAO=new SalaryDAO();

S.setID(request.getParameter("ID"));
int c=request.getParameter("STPassword").hashCode();//π˛œ£∫Ø ˝º”√‹√‹¬Î
String STPassword=""+c;
S.setSTPassword(STPassword);
S.setSTRank(request.getParameter("STRank"));
S.setSTName(request.getParameter("STName"));
S.setEmail(request.getParameter("Email"));
S.setDepartment(request.getParameter("Department"));
S.setQuestion1(request.getParameter("Question1"));
S.setAnswer1(request.getParameter("Answer1"));
S.setQuestion2(request.getParameter("Question2"));
S.setAnswer2(request.getParameter("Answer2"));   
S.setQuestion3(request.getParameter("Question3"));
S.setAnswer3(request.getParameter("Answer3"));
S1.setID(request.getParameter("ID"));
S1.setSTName(request.getParameter("STName"));
S1.setDepartment(request.getParameter("Department"));

try {
	StaffDAO.insert(S);
	SalaryDAO.insert(S1);
	response.sendRedirect("SuccessInsert.jsp");
}catch(Exception e) {
	e.printStackTrace();
}

out.flush();
out.close();
}
}

