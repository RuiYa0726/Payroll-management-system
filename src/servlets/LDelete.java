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
import beans.Staff;
import beans.StaffDAO;
import beans.Salary;

public class LDelete extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8"); //设置输出编码格式
	PrintWriter out=response.getWriter();
	
	Staff S=new Staff();
	StaffDAO SDAO=new StaffDAO();
	Salary S1=new Salary();
	SalaryDAO S1DAO=new SalaryDAO();
	String ID;
	ID=request.getParameter("ID");
	String SQL;
	String SQL1;
	ArrayList<Staff> result=new ArrayList<Staff>();
	ArrayList<Salary> result1=new ArrayList<Salary>();

	try {
		SQL="select * from Staff where ID='"+ID+"'";
		SQL1="select * from Salary where ID='"+ID+"'";
		result=SDAO.select(SQL);
		S=result.get(0);
		SDAO.delete(S);
		result1=S1DAO.select(SQL1);
		for(int i=0;i<result1.size();i++)
		{
			S1=result1.get(i);
			S1DAO.delete(S1);
		}
		
		
				
		response.sendRedirect("SuccessDelete.jsp");
		
	}catch(Exception e) {
		e.printStackTrace();
	}


	out.flush();
	out.close();
	}
	}



