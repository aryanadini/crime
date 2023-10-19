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

public class SuspectedCriminalDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crimefinal","root","");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	   
	   
		public static int register(SuspectedCriminals u){    
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
	
		public static List<SuspectedCriminals> getAllRecords(){  
		    List<SuspectedCriminals> list=new ArrayList<SuspectedCriminals>();  
		      
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("select * from suspectedcriminals");  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		            SuspectedCriminals sc=new SuspectedCriminals();  
		            sc.setId(rs.getInt("id"));  
		            sc.setImage(rs.getBlob("Image"));  
		            sc.setFullname(rs.getString("Fullname"));  
		            sc.setIdproof(rs.getBlob("Idproof"));  

		            sc.setGender(rs.getString("Gender")); 
		            sc.setDateofbirth(rs.getString("Dateofbirth"));
		              
		            sc.setAddress(rs.getString("Address"));  
		            sc.setHeight(rs.getInt("Height")); 
		            sc.setWeight(rs.getInt("Weight")); 
		            sc.setPolicestationname(rs.getString("Policestationname")); 
		            sc.setOfficerincharge(rs.getString("Officerincharge")); 
		        sc.setArrestdate(rs.getString("Arrestdate")); 
		            sc.setRemark(rs.getString("Remark")); 
		            list.add(sc);  
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return list;  
		}
		
		public static SuspectedCriminals getRecordById(int id){  
		    SuspectedCriminals u=null;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("select * from suspectedcriminals where id=?");  
		        ps.setInt(1,id);  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		            u=new SuspectedCriminals();  
		            u.setId(rs.getInt("id"));  
		            u.setImage(rs.getBlob("Image"));    
		            u.setFullname(rs.getString("Fullname")); 
		            u.setIdproof(rs.getBlob("Idproof")); 
		            u.setGender(rs.getString("Gender"));   
		          u.setDateofbirth(rs.getString("Dateofbirth"));  
		            u.setAddress(rs.getString("Address")); 
		             u.setHeight(rs.getInt("Height")); 
		            u.setWeight(rs.getInt("Weight")); 
		            u.setPolicestationname(rs.getString("Policestationname")); 
		            u.setOfficerincharge(rs.getString("Officerincharge")); 
		            u.setArrestdate(rs.getString("Arrestdate")); 
		            u.setRemark(rs.getString("Remark"));        
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return u;  
		}  
}
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

