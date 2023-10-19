package crimeManagementSystem;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OfficerDao {
	
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crimefinal","root","");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	   
	public static int register(Officers u){    
	 int i=0;    
	  
	 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	Session session = factory.openSession();  
	Transaction t = session.beginTransaction();   
	  
	i=(Integer)session.save(u);    
	  
	t.commit();    
	session.close();    
	    
	return i;    
	   
	 }
	
	
	
	public static List<Officers> getAllRecords(){  
	    List<Officers> list=new ArrayList<Officers>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from officers");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Officers officer=new Officers();  
	            officer.setId(rs.getInt("id"));  
	            officer.setFullname(rs.getString("fullname"));  
	            officer.setEmail(rs.getString("email"));  
	            officer.setAddress(rs.getString("address"));  

	            officer.setPassword(rs.getString("password")); 
	            officer.setPhone(rs.getString("phone")); 
	            officer.setPennumber(rs.getInt("pennumber"));
	              
	            officer.setGender(rs.getString("gender"));  

	            
	            list.add(officer);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	
	public static Officers getRecordById(int id){  
	    Officers u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from officers where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new Officers();  
	            u.setId(rs.getInt("id"));  
	            u.setFullname(rs.getString("fullname")); 
	            u.setPennumber(rs.getInt("pennumber"));
	            u.setGender(rs.getString("gender"));
	            u.setEmail(rs.getString("email"));
	            u.setPhone(rs.getString("phone"));
	            u.setAddress(rs.getString("address"));
	            u.setPassword(rs.getString("password"));  
	             u.setCpassword(rs.getString("cpassword"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}  
	public static int update(Officers u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update officers set fullname=?,pennumber=?,gender=?,email=?,phone=?,address=?,password=?,cpassword=? where id=?");  
	        ps.setString(1,u.getFullname());  
	        ps.setInt(2,u.getPennumber());  
	        ps.setString(3,u.getGender());
	        ps.setString(4,u.getEmail());
	        ps.setString(5,u.getPhone());
	        ps.setString(6, u.getAddress());
	         ps.setString(7,u.getPassword());
	        ps.setString(8, u.getCpassword());
	        ps.setInt(9,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	} 
	
	public static int delete(Officers u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from officers where id=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	
	
	
	}  
	
	
	
	
	
	
	
	


