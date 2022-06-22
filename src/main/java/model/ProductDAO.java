package model;
import java.sql.*;
public class ProductDAO {
    public static Connection createConnection() {
    	Connection  cn=null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String url="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei&useUnicode=true&characterEncoding=UTF8";
    		String user="root";
    		String password="1234";
    		cn=DriverManager.getConnection(url,user,password);
    	}catch(SQLException | ClassNotFoundException ex) {
    		System.out.println("Connection error:"+ex.getMessage());
    	}    	
    	return cn;
    }
    public static boolean insertMyProduct(MyProduct p) {
    	  boolean flag=false;
    	  try {
    		  Connection cn=createConnection();
    		  CallableStatement st=cn.prepareCall("call insert_myproduct(?,?,?,?)");
    		  st.setString(1,p.getPid());
    		  st.setString(2,p.getPname());
    		  st.setString(3,p.getPlace());
    		  st.setInt(4,p.getPrice());
    		  ResultSet rs=st.executeQuery();
    		  rs.next();
    		  int r=rs.getInt(1);
    		  if(r>0)
    			  flag=true;
    	  }catch(SQLException ex) {
    		  System.out.println("Stored Proc Error:"+ex.getMessage());  
    	  }    	  
    	  
    	  return flag;
    }
    public static String  searchProduct(String sname) {
    	   String temp="No Data";
    	   try {
    		    Connection cn=  createConnection();
    		    Statement st=cn.createStatement();
    		    String sql="select * from classicmodels.myproduct where pname='"+sname+"'";
    		    ResultSet rs=st.executeQuery(sql);
    		    boolean b=rs.next();
    		    if(b) {
    		    	String pid=rs.getString("pid");
    		    	String name=rs.getString("pname");
    		    	String place=rs.getString("place");
    		    	String price=rs.getString("price");
    		    	temp="ID:"+pid+" Name:"+name+" Place:"+place+" Price:"+price;
    		    }
    	   }catch(SQLException ex) {
    		   System.out.println("Search product Error:"+ex.getMessage());
    	   } 	   
    	   
    	   return temp;
    }
}
