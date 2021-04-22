package servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;

import beans.SalaryDAO;
import beans.Salary;

public class LUpdate extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8"); //设置输出编码格式
	PrintWriter out=response.getWriter();
	

	Salary S=new Salary();
	SalaryDAO SDAO=new SalaryDAO();
	String ID;
	String Time1;
	String UpdatePart;
	String Number;
	ID=request.getParameter("ID");
	Time1=request.getParameter("Time1");
	UpdatePart=request.getParameter("UpdatePart");
	Number=request.getParameter("Number");
	String SQL="";

	try {
		if(UpdatePart.equals("Initial"))
		SQL="update Salary set Initial='"+Number+"' where ID ='"+ID+"' AND Time1='"+Time1+"'";
		else if(UpdatePart.equals("Accumulation"))
			SQL="update Salary set Accumulation='"+Number+"' where ID ='"+ID+"' AND Time1='"+Time1+"'";
		else if(UpdatePart.equals("Social"))
			SQL="update Salary set Social='"+Number+"' where ID ='"+ID+"' AND Time1='"+Time1+"'";
		else if(UpdatePart.equals("Tax"))
			SQL="update Salary set Tax='"+Number+"' where ID ='"+ID+"' AND Time1='"+Time1+"'";
		else if(UpdatePart.equals("Overtime"))
			SQL="update Salary set Overtime='"+Number+"' where ID ='"+ID+"' AND Time1='"+Time1+"'";
		else if(UpdatePart.equals("Final"))
			SQL="update Salary set Final='"+Number+"' where ID ='"+ID+"' AND Time1='"+Time1+"'";
		else if(UpdatePart.equals("Yearbonus"))
			SQL="update Salary set Yearbonus='"+Number+"' where ID ='"+ID+"' AND Time1='"+Time1+"'";
		else if(UpdatePart.equals("Annual"))
			SQL="update Salary set Annual='"+Number+"' where ID ='"+ID+"' AND Time1='"+Time1+"'";
		SDAO.updateSalary(SQL);			
		response.sendRedirect("SuccessUpdate.jsp");
		
	}catch(Exception e) {
		e.printStackTrace();
	}


	out.flush();
	out.close();
	}
	}



