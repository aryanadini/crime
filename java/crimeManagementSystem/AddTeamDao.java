package crimeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.Database;

public class AddTeamDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crimefinal","root","");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	   
	public static int register(AddTeam u){    
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
	public static List<AddTeam> getAllRecords(){  
	    List<AddTeam> list=new ArrayList<AddTeam>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from addteam");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            AddTeam addteam=new AddTeam();  
	            addteam.setId(rs.getInt("id"));  
	            addteam.setNameofteam(rs.getString("nameofteam"));  
	            addteam.setLeadingofficername(rs.getString("leadingofficername"));  
	            addteam.setOfficeaddress(rs.getString("officeaddress"));  

	            addteam.setEmail(rs.getString("email")); 
	            addteam.setSelectteammembers(rs.getString("Selectteammembers")); 
	             

	            
	            list.add(addteam);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	
	public static AddTeam getRecordById(int id){  
	    AddTeam u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from addteam where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new AddTeam();  
	            u.setId(rs.getInt("id"));  
	            u.setNameofteam(rs.getString("nameofteam"));  
	            u.setLeadingofficername(rs.getString("leadingofficername"));  
	            u.setOfficeaddress(rs.getString("officeaddress"));  
	            u.setEmail(rs.getString("email"));  
	             
	            u.setSelectteammembers(rs.getString("selectteammembers"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}  
	public static int update(AddTeam u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update addteam set nameofteam=?,leadingofficername=?,officeaddress=?,email=?,selectteammembers=? where id=?");  
	        ps.setString(1,u.getNameofteam());  
	        ps.setString(2,u.getLeadingofficername());  
	        ps.setString(3,u.getOfficeaddress()); 
	        ps.setString(4,u.getEmail()); 
	        ps.setString(5,u.getSelectteammembers()); 
	        ps.setInt(6,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	} 
	
	public static int delete(AddTeam u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from addteam where id=?");  
	        ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	
	
	
	}  
	
	
	
	





