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
	ArrayList<ResBean> resbean = new ArrayList<ResBean>();
	ArrayList<ThreadBean> thrbean = new ArrayList<ThreadBean>();

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
	public ArrayList resRead(){
		try{
			String sql="SELECT resId,UserName,CreateDate,Content FROM GLRes ORDER BY CreateDate DESC";

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
	public ArrayList thrRead(){
		try{
			String sql="SELECT thName,thCreateDate FROM GLThread";

			getConnection();

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery(sql);

			while(rs.next()){
				ThreadBean tb = new ThreadBean();

				tb.setThrName(rs.getString(1));
				tb.setThrCreateDate(rs.getString(2));

				thrbean.add(tb);

				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(tb.getThrCreateDate());
				System.out.println(tb.getThrCreateDate());
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

		return thrbean;
	}
	public void write(String sql){
		try{
			getConnection();

			Statement st=cn.createStatement();

			int result = st.executeUpdate(sql);
			System.out.println(result+"��insert������B");

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
