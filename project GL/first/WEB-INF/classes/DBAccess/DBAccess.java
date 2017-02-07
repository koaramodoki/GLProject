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
			Class.forName("oracle.jdbc.driver.OracleDriver");//JDBCドライバの宣言

			//Oracleに接続する
			cn =
			DriverManager.getConnection
	 	 	 ("jdbc:oracle:thin:@localhost:1521:orcl",	"info","pro");
			
			//自動コミットをOFFにする
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("接続失敗");
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
			System.out.println("リストに追加したよ。");
			
			cn.commit();
			
			st.close();
			
			cn.close();
		
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("接続失敗");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("接続失敗");
		}
		
		return resbean;
	}
	public void write(ResBean rb){
		try{
			getConnection();
			
			String sql="insert into ResTest(resId,UserName,CreateDate,Content) values ("+rb.getResId()+",'"+rb.getResUserName()+"',sysdate,'"+rb.getResContent()+"')";
			
			Statement st=cn.createStatement();
			
			int a = st.executeUpdate(sql);
			System.out.println(a+"件insertしたよ。");
			
			cn.commit();
			
			st.close();
			
			cn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("接続失敗");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("接続失敗");
		}
	}
}