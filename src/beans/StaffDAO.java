package beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffDAO {
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
		ArrayList<Staff> result=new ArrayList<Staff>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn =getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
			Staff S=new Staff();
			S.setID(rs.getString("ID"));
			S.setSTPassword(rs.getString("STPassword"));
			S.setSTRank(rs.getString("STRank"));
			S.setSTName(rs.getString("STName"));
			S.setEmail(rs.getString("Email"));
			S.setDepartment(rs.getString("Department"));
			S.setQuestion1(rs.getString("Question1"));
			S.setQuestion2(rs.getString("Question2"));
			S.setQuestion3(rs.getString("Question3"));
			S.setAnswer1(rs.getString("Answer1"));
			S.setAnswer2(rs.getString("Answer2"));
			S.setAnswer3(rs.getString("Answer3"));
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


public void updatePassword(Staff S) throws Exception {
    Connection conn=null;
    PreparedStatement ps=null;
  String sql="update Staff set STPassword='"+S.getSTPassword()+"' where ID ='"+S.getID()+"'";
  System.out.println("sql"+sql);
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
  
  public static void insert(Staff staff) throws Exception {
      Connection conn=null;
      PreparedStatement ps=null;
      String sql="insert into Staff(ID,STPassword,STRank,STName,Email,Department,Question1,Answer1,Question2,Answer2,Question3,Answer3) values('"+staff.getID()+"','"+staff.getSTPassword()+"','"+staff.getSTRank()+"','"+staff.getSTName()+"','"+staff.getEmail()+"','"+staff.getDepartment()+"','"+staff.getQuestion1()+"','"+staff.getAnswer1()+"','"+staff.getQuestion2()+"','"+staff.getAnswer2()+"','"+staff.getQuestion3()+"','"+staff.getAnswer3()+"')";
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
 
           
  public void delete(Staff staff)throws Exception{
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=getConnection();
			String sql="delete from Staff where ID='"+staff.getID()+"'";
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
            			