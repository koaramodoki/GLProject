package DBAccess;

import Bean.ResBean;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBAccess{
	
	Connection cn;
	private ArrayList<ResBean> resBean = new ArrayList<ResBean>();
	private ArrayList<threadBean> threadBean = new ArrayList<threadBean>();
	
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
	public ArrayList resRead(){
		try{						
			String sql="SELECT resId,UserName,CreateDate,Content FROM ResTest ORDER BY CreateDate DESC";
			
			getConnection();
			
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
	public void write(String sql){
		try{
			getConnection();
			
			Statement st=cn.createStatement();
			
			int result = st.executeUpdate(sql);
			System.out.println(result+"件insertしたよ。");
			
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