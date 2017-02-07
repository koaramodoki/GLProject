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
			String sql="SELECT EMPNO,ENAME FROM EMP";
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				ResBean rb = new ResBean();
				
				rb.setResId(rs.getInt(1));
				rb.setResUserName(rs.getString(2));
				//rb.setResCreateDate(rs.getString(3));
				//rb.setResContent(rs.getString(4));
				
				resbean.add(rb);
			}
			
		//}catch(ClassNotFoundException e){
		//	e.printStackTrace();
		//	System.out.println("�ڑ����s");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}
		
		return resbean;
	}
	public void write(){

	}
}