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
		ArrayList users = new ArrayList();

        ThreadBean threadBean = new ThreadBean();

        MainExecute mainExecute = new MainExecute();

		threadBean.setThName(req.getParameter("name"));
		threadBean.setThCreateUser(req.getParameter("user"));

		mainExecute.addThread(threadBean);

		users = mainExecute.getThread();


		req.setAttribute("users",users);

		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dis=
		req.getRequestDispatcher("ThreadOut");

		//上で設定した宛先にreqとresを転送する
		dis.forward(req,res);

	}

	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//文字コード設定
		req.setCharacterEncoding("Windows-31J");

		//送られてきた値をResBeanにセット
		ResBean rb = new ResBean();
		rb.setResUserName(req.getParameter("User"));
		rb.setResContent(req.getParameter("Content"));

		//ResBeanを引数にaddResを実行
		ResExecute rx = new ResExecute();
		rx.addRes(rb);

		DBAccess dba = new DBAccess();
		ArrayList<ResBean> users = dba.ThreadRead();

		//HttpServletRequetの実装クラスのインスタンスに
		//usersという名前でデータを登録する

		req.setAttribute("users",users);

		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dis=
		req.getRequestDispatcher("testout");

		//上で設定した宛先にreqとresを転送する
		dis.forward(req,res);

	}
}
