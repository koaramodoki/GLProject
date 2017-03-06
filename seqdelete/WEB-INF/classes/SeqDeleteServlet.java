import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServletを継承したJstlTestServletクラスの作成
public class SeqDeleteServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		int result=0;
		
		//文字コード設定
		req.setCharacterEncoding("Windows-31J");
		
		System.out.println("(´・ω・`)");
		//POST要求によって送信されたパラメーターを取得する
		String in = req.getParameter("deleteCount");
		System.out.println(in);
		int deleteCount = Integer.parseInt(in);
		System.out.println(deleteCount);
			
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");//JDBCドライバの宣言
				//Oracleに接続する
			Connection cn =
			DriverManager.getConnection
	 	 	 ("jdbc:oracle:thin:@localhost:1521:orcl",	"info","pro");
			
			//自動コミットをOFFにする
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");
			
			Statement st=cn.createStatement();
			
			for(int i=1;i < deleteCount;i++){
				String sql ="drop sequence ResSequence"+i+" ";
				
				int j = st.executeUpdate(sql);
				result += j;
				System.out.println(result);
				System.out.println("for中");
			}
		
			cn.commit();
			
			st.close();
			
			cn.close();
			System.out.println("切断完了");
				
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("接続失敗");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("接続失敗");
		}
	
		
		//HttpServletRequetの実装クラスのインスタンスに
		//usersという名前でデータを登録する
		
		req.setAttribute("result",result);
		
		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dis=
		req.getRequestDispatcher("seqout");
		
		//上で設定した宛先にreqとresを転送する
		dis.forward(req,res);
		
	}
}
