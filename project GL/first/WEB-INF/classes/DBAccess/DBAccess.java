package DBAccess;

import Bean.ResBean;
import Bean.ThreadBean;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBAccess{

	Connection cn;
	private ArrayList<ResBean> resBean = new ArrayList<ResBean>();
	private ArrayList<ThreadBean> threadBean = new ArrayList<ThreadBean>();

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
	public ArrayList resRead(String id){
		try{
			System.out.println("resReadのメソッドです"+id);
			String sql="SELECT thrId,resId,UserName,CreateDate,Content,(Select ThrName FROM GLThread where thrid = '"+id+"') From GLRes where thrId = '"+id+"' ORDER BY CreateDate DESC";
			getConnection();

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery(sql);

			while(rs.next()){
				ResBean rb = new ResBean();

				rb.setThrId(rs.getString(1));
				rb.setResId(rs.getInt(2));
				rb.setResUserName(rs.getString(3));
				rb.setResCreateDate(rs.getString(4));
				rb.setResContent(rs.getString(5));
				rb.setThrName(rs.getString(6));

				resBean.add(rb);
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

		return resBean;
	}

	public ArrayList ThreadRead(){
		try{
			String sql="SELECT ThrId,ThrName,UserName,CreateDate,(Select count(ResId) from GLRes where thrId = GLThread.thrid),(Select max(createdate) from GLRes where thrId = GLThread.thrid) FROM GLThread ORDER BY Createdate DESC";

			getConnection();

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery(sql);

			while(rs.next()){

				ThreadBean tb = new ThreadBean();

				tb.setThrId(rs.getString(1));

				tb.setThrName(rs.getString(2));

				tb.setThrCreateUser(rs.getString(3));

				tb.setThrCreateDate(rs.getString(4));

				tb.setResCount(rs.getString(5));

				tb.setUpdateDate(rs.getString(6));


				threadBean.add(tb);

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

		return threadBean;
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
	public void seqCreate(){
	try{
			
			ThreadBean tb = new ThreadBean();

			String curr = "Select Max(ThrId) from GLthread";

			getConnection();

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery(curr);

			rs.next();

			tb.setThrId(rs.getString(1));
		
		String seq;

		if(tb.getThrId()==null){
			seq = "create sequence ResSequence1 maxvalue 9999";
			
			System.out.println(seq);

		}else{
			seq = "create sequence ResSequence"+tb.getThrId()+" maxvalue 9999";

			System.out.println(seq);
		}

			int result = st.executeUpdate(seq);
			System.out.println("ResSequence"+seq+"を作成しました。");

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
