package DBAccess;

import Bean.ResBean;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBAccess{
	
	public Connection cn;
	ArrayList<ResBean> resbean = new ArrayList<ResBean>();
	
	public void getConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");//JDBC�h���C�o�̐錾

			//Oracle�ɐڑ�����
			cn =
			DriverManager.getConnection
	 	 	 ("jdbc:oracle:thin:@localhost:1521:orcl",	"info","pro");
			
			//�����R�~�b�g��OFF�ɂ���
			cn.setAutoCommit(false);
			
			System.out.println("�ڑ�����");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}
	}
	public ArrayList read(){
		try{			
			getConnection();
			
			String sql="SELECT resId,UserName,CreateDate,Content FROM ResTest ORDER BY CreateDate DESC";
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				ResBean rb = new ResBean();
				
				rb.setResId(rs.getInt(1));
				rb.setResUserName(rs.getString(2));
				rb.setResCreateDate(rs.getString(3));
				rb.setResContent(rs.getString(4));
				
				resbean.add(rb);
			}
			System.out.println("���X�g�ɒǉ�������B");
			
			cn.commit();
			
			st.close();
			
			cn.close();
		
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}
		
		return resbean;
	}
	public void write(ResBean rb){
		try{
			getConnection();
			
			String sql="insert into ResTest(resId,UserName,CreateDate,Content) values ("+rb.getResId()+",'"+rb.getResUserName()+"',sysdate,'"+rb.getResContent()+"')";
			
			Statement st=cn.createStatement();
			
			int a = st.executeUpdate(sql);
			System.out.println(a+"��insert������B");
			
			cn.commit();
			
			st.close();
			
			cn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}
	}
}