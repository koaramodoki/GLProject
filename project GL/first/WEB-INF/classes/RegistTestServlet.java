import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.math.BigDecimal;
import ip.Oracletest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;



//サブレット RecordServletのクラス宣言
public class RegistTestServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		Oracletest ora = new Oracletest();
		
		
		
		try{//決まり　データベースと接続時に使うもの　Driver インターフェースを実装したクラスをメモリへロード
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する　CONNECTIONインターフェースを実装したクラスのインスタンス化
				Connection cn=
			DriverManager.getConnection //localhost:（ポート番号）:（ファィル）",	"(ID)","（パス）"
	 	 	 ("jdbc:oracle:thin:@localhost:1521:orcl",	"info","pro");
			cn.setAutoCommit(false);
			System.out.println("接続完了");
			
			//SQLを変数に格納
			String sql = "SELECT empno,ename from emp";
			//Statement インターフェイスを実装するクラスのインスタンスを取得
			Statement st = cn.createStatement();
			//SQLを実行しトランザクションが開始される　処理けんすうが返される
			//int count = st.executeUpdate(sql);
			
			
			//SELECT文を実行し ResultSetインターフェイスを実装したクラスのインスタンスが返る
			ResultSet rs=st.executeQuery(sql);
			
			rs.next();
			ora.setName(rs.getString(1));
			ora.setTable(rs.getString(2));
			
			
			//トランザクションをコミット
			cn.commit();
			//ステートメントをclose
			st.close();
			//Oracleから切断する
			cn.close();
			System.out.println("切断完了");
			
			req.setAttribute("ora",ora);
			
			
			RequestDispatcher dispatcher=
			req.getRequestDispatcher("output");
			dispatcher.forward(req,res);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがない");
		//SQLと接続時に問題起きた時
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例がない");
		}catch(Exception e){
			e.printStackTrace();
		}
	
			
	}
}
