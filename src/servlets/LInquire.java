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

public class LInquire extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8"); //设置输出编码格式
	PrintWriter out=response.getWriter();

	Salary S=new Salary();
	SalaryDAO STUserDAO=new SalaryDAO();
	String ID;
	ID=request.getParameter("ID");
	String SQL;
	ArrayList<Salary> result=new ArrayList<Salary>();


	try {
		SQL="select * from Salary where ID='"+ID+"'";
		result=STUserDAO.select(SQL);
		if(result.size()==0)
		{
			response.sendRedirect("FailInquire.jsp");
			}
		else{
			HttpSession session=request.getSession(true);
			session.setAttribute("i",result.size());
			for(int i=0;i<result.size();i++)
			{
				S=result.get(i);
				session.setAttribute("ID"+i+"",S.getID());
				session.setAttribute("STName"+i+"",S.getSTName());
				session.setAttribute("Time1"+i+"",S.getTime1());
				session.setAttribute("Initial"+i+"",S.getInitial());
				session.setAttribute("Department"+i+"",S.getDepartment());
				session.setAttribute("Accumulation"+i+"",S.getAccumulation());
				session.setAttribute("Social"+i+"",S.getSocial());
				session.setAttribute("Tax"+i+"",S.getTax());
				session.setAttribute("Overtime"+i+"",S.getOvertime());
				session.setAttribute("Final"+i+"",S.getFinal());
				session.setAttribute("Yearbonus"+i+"",S.getYearbonus());
				session.setAttribute("Annual"+i+"",S.getAnnual());
			}		
			response.sendRedirect("RespLInquire.jsp");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}


	out.flush();
	out.close();
	}
	}



