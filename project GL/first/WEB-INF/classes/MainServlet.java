import Bean.ResBean;
import DBAccess.DBAccess;
import Execute.MainExecute;
import Bean.ThreadBean;

import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServletを継承したJstlTestServletクラスの作成
public class MainServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//文字コード設定
		req.setCharacterEncoding("Windows-31J");
		//jspに送るためのArrayListを生成
		ArrayList users = new ArrayList();
		//ThreadBeanのインスタンスを生成
        ThreadBean threadBean = new ThreadBean();
		//Executeクラスのメソッドを使うためにExecuteをインスタンス化
        MainExecute mainExecute = new MainExecute();

		//jspから送られた要素をBeanのセッターで値を格納。
		threadBean.setThrName(req.getParameter("name"));
		threadBean.setThrCreateUser(req.getParameter("user"));
		//String型の変数を生成

			//セットされたBeanのインスタンスをaddThreadに送る
		mainExecute.addThread(threadBean);
		//ExecuteからThread全体のリストを受け取りArrayList型に格納。
		users = mainExecute.getThread();

		//ArrayListをsetAttributeに格納
		req.setAttribute("users",users);

		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dis=
		req.getRequestDispatcher("ThrList");

		//上で設定した宛先にreqとresを転送する
		dis.forward(req,res);

	}

	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//文字コード設定
		req.setCharacterEncoding("Windows-31J");

		DBAccess dba = new DBAccess();
		ArrayList<ThreadBean> users = dba.ThreadRead();

		//HttpServletRequetの実装クラスのインスタンスに
		//usersという名前でデータを登録する

		req.setAttribute("users",users);

		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dis=
		req.getRequestDispatcher("ThrList");

		//上で設定した宛先にreqとresを転送する
		dis.forward(req,res);

	}
}
