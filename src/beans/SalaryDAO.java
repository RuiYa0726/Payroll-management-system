package beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SalaryDAO {
	/**
	 * @return
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection()throws SQLException,InstantiationException,IllegalAccessException,ClassNotFoundException{
		
		Connection conn=null;
		Statement stat = null;
		Class.forName(DBConst.CLASSNAME).newInstance();
		String url = DBConst.URL;  
		String user = DBConst.NAME;
		String password = DBConst.PASSWORD;
		conn=DriverManager.getConnection(url, user, password);
		return conn;
		}
	/**
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public ArrayList select(String sql)throws Exception{
		ArrayList<Salary> result=new ArrayList<Salary>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
			Salary S=new Salary();
			S.setID(rs.getString("ID"));
			S.setSTName(rs.getString("STName"));
			S.setDepartment(rs.getString("Department"));
			S.setTime1(rs.getString("Time1"));
			S.setInitial(rs.getFloat("Initial"));
			S.setAccumulation(rs.getFloat("Accumulation"));
			S.setSocial(rs.getFloat("Social"));
			S.setTax(rs.getFloat("Tax"));
			S.setOvertime(rs.getFloat("Overtime"));
			S.setFinal(rs.getFloat("Final"));
			S.setYearbonus(rs.getFloat("Yearbonus"));
			S.setAnnual(rs.getFloat("Annual"));
			result.add(S);
			}
		}catch(SQLException sqle) 
            {
            	throw new SQLException("select data exception:"+sqle.getMessage());
            }catch(Exception e) 
            {
            	throw new Exception("Symtem a exception:"+e.getMessage());
            }finally{
            	try{
            		if(rs!=null) {
            			rs.close();
            		}
            	}catch(Exception e){
            		throw new Exception("statement close exception:"+e.getMessage());
            	}
            	try {
            		if(conn!=null) {
            			conn.close();
            			}
            	}catch(Exception e) {
            		throw new Exception("connection close exception:"+e.getMessage());
            	}
            }
            return result;
            }

    /**
    	*
    	*@Param sql
    	*@throws Exception
    */

public void updateSalary(String sql) throws Exception {
      Connection conn=null;
      PreparedStatement ps=null;
    try {
    conn=getConnection();
    	ps=conn.prepareStatement(sql);
    	ps.executeUpdate();
    }catch (SQLException sqle) {
    	throw new Exception("update exception:"+sqle.getMessage());
    }finally {
    	try {
    if(ps!=null) {
    	ps.close();
    }
      }catch(Exception e) {
    throw new Exception("ps close exception:"+e.getMessage());
    	}
    }
    try {
    if(conn!=null) {
    	conn.close();
    	}
    	}catch(Exception e) {
    throw new Exception("connection close exception:"+e.getMessage());
    }
 }

	public static void insert(Salary salary) throws Exception {
	      Connection conn=null;
	      PreparedStatement ps=null;
	      String sql="insert into Salary(ID,Time1,STName,Department,Initial,Accumulation,Social,Tax,Overtime,Final,Yearbonus,Annual) values('"+salary.getID()+"','"+salary.getTime1()+"','"+salary.getSTName()+"','"+salary.getDepartment()+"','"+salary.getInitial()+"','"+salary.getAccumulation()+"','"+salary.getSocial()+"','"+salary.getTax()+"','"+salary.getOvertime()+"','"+salary.getFinal()+"','"+salary.getYearbonus()+"','"+salary.getAnnual()+"')";
	      try {
	            conn=getConnection();
	            ps=conn.prepareStatement(sql);
	            ps.executeUpdate();
	            }catch(SQLException sqle) {
	            throw new Exception("insert data exception:"+sqle.getMessage());
	            }finally {
	            try {
	              if(ps!=null) 
	              {
	            	  ps.close();
	               }
	            }catch(Exception e) {
	            throw new Exception("ps close exception:"+e.getMessage());
	            }
	            	}
	            try {
	            	if(conn!=null) 
	            	{
	            		conn.close();
	            	}
	            }catch(Exception e) {
	            throw new Exception("connection close exception:"+e.getMessage());
	            }
	            	}
	
	
	  public void delete(Salary salary)throws Exception{
			Connection conn=null;
			PreparedStatement ps=null;
			try{
				conn=getConnection();
				String sql="delete from Salary where ID='"+salary.getID()+"'";
				ps=conn.prepareStatement(sql);
				int count=ps.executeUpdate();
				System.out.println("É¾³ýÁË"+count+"Ìõ¼ÇÂ¼");
			}catch (SQLException sqle){
				throw new Exception("delete data exception: "+sqle.getMessage());
			}finally{
				try{
					if(ps!=null) {
						ps.close();
					}
				}catch(Exception e){
					throw new Exception("ps close exception: "+e.getMessage());
				}
			}
			try{
				if(conn!=null) {
					conn.close();
					}
				}catch(Exception e) {
					throw new Exception("connection close exception: "+e.getMessage());
				}
		}
}
