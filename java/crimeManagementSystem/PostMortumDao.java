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

public class PostMortumDao {

	
		public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crimefinal", "root", "");
			} catch (Exception e) {
				System.out.println(e);
			}
			return con;
		}
	
	
		public static int register(PostMortum u) {
			int i = 0;

			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

			SessionFactory factory = meta.getSessionFactoryBuilder().build();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();

			i = (Integer) session.save(u);

			t.commit();
			session.close();

			return i;

		}

		public static List<PostMortum> getAllRecords(){  
		    List<PostMortum> list=new ArrayList<PostMortum>();  
		      
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("select * from postmortum");  
		        ResultSet rs=ps.executeQuery();  
		        while(rs.next()){  
		            PostMortum pm=new PostMortum();  
		            pm.setId(rs.getInt("Id"));  
		            pm.setFullname(rs.getString("Fullname"));  
		            pm.setImage(rs.getBlob("Image"));  
		            pm.setGender(rs.getString("Gender"));
		           pm.setDateofbirth(rs.getString("Dateofbirth")); 
		            pm.setIdproof(rs.getBlob("Idproof")); 
		            pm.setAddress(rs.getString("Address"));
		            pm.setFirid(rs.getInt("Firid"));
		           pm.setPostmortum(rs.getBlob("Postmortum"));  
		          pm.setDateofpostmortum(rs.getString("Dateofpostmortum"));
		           pm.setDoctorsname(rs.getString("Doctorsname"));
		           pm.setHospitaladdress(rs.getString("Hospitaladdress"));
		           pm.setDescriptionofcase(rs.getString("Descriptionofcase"));
		            list.add(pm);  
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return list;  
		}
		
		public static PostMortum getRecordById(int id){  
		    PostMortum u=null;  
		    try{  
		        Connection con=getConnection();  
		        PreparedStatement ps=con.prepareStatement("select * from postmortum where id=?");  
		        ps.setInt(1,id);  
		        ResultSet rs=ps.executeQuery();  
		            while(rs.next()){  
		            u=new PostMortum();  
		            u.setId(rs.getInt("Id"));  
		            u.setFullname(rs.getString("Fullname"));  
		            u.setImage(rs.getBlob("Image"));  
		            u.setGender(rs.getString("Gender"));  
		           u.setDateofbirth(rs.getString("Dateofbirth"));  
		            u.setIdproof(rs.getBlob("Idproof")); 
		            u.setAddress(rs.getString("Address"));
		            u.setFirid(rs.getInt("Firid"));
		            u.setPostmortum(rs.getBlob("Postmortum")); 
		           u.setDateofpostmortum(rs.getString("Dateofpostmortum")); 
		            u.setDoctorsname(rs.getString("Doctorsname"));
		            u.setHospitaladdress(rs.getString("Hospitaladdress"));
		            u.setDescriptionofcase(rs.getString("Descriptionofcase"));
		            
		        }  
		    }catch(Exception e){System.out.println(e);}  
		    return u;  
		}  

		
	
}
