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

public class MostWantedDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crimefinal","root","");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	   
	public static int register(MostWanted u){    
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
	public static List<MostWanted> getAllRecords(){  
	    List<MostWanted> list=new ArrayList<MostWanted>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from mostwanted");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            MostWanted mw=new MostWanted();  
	           mw.setId(rs.getInt("id"));  
	            mw.setPolicestationname(rs.getString("Policestationname"));  
	           mw.setImage(rs.getBlob("Image"));  
	           mw.setFullname(rs.getString("Fullname"));  
                mw.setNickname(rs.getString("Nickname")); 
	            mw.setIdproof(rs.getBlob("Idproof")); 
	            mw.setGender(rs.getString("Gender"));
	            mw.setDateofbirth(rs.getString("Dateofbirth"));  
	            mw.setAddress(rs.getString("Address"));
	            mw.setIdentifyingmark(rs.getString("Identifyingmark"));
	            mw.setDescription(rs.getString("Description"));
	            list.add(mw);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}
	
	public static MostWanted getRecordById(int id){  
	    MostWanted u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from MostWanted where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new MostWanted();  
	            u.setId(rs.getInt("id"));  
	            u.setPolicestationname(rs.getString("Policestationname"));  
	            u.setImage(rs.getBlob("Image"));  
	            u.setFullname(rs.getString("Fullname"));
	            u.setNickname(rs.getString("Nickname")); 
	            u.setIdproof(rs.getBlob("Idproof"));  
	            u.setGender(rs.getString("Gender"));
	            u.setDateofbirth(rs.getString("Dateofbirth"));
	            u.setAddress(rs.getString("Address"));
	            u.setIdentifyingmark(rs.getString("Identifyingmark"));
	            u.setDescription(rs.getString("Description"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}  
}
