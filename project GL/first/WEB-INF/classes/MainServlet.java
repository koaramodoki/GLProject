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
		threadBean.setThName(req.getParameter("name"));
		threadBean.setThCreateUser(req.getParameter("user"));
		//String型の変数を生成
		String Thname = req.getParameter("name");

		//変数の中身がnullなら読み込みだけ、中身がある場合は書き込んで読み込み
		if(Thname.equals("")){
			//セットされたBeanのインスタンスをaddThreadに送る
			users = mainExecute.getThread();
		}else{
			//セットされたBeanのインスタンスをaddThreadに送る
			mainExecute.addThread(threadBean);
			//ExecuteからThread全体のリストを受け取りArrayList型に格納。
			users = mainExecute.getThread();
		}

		//ArrayListをsetAttributeに格納
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

		// //文字コード設定
		// req.setCharacterEncoding("Windows-31J");
		//
		// //送られてきた値をResBeanにセット
		// ResBean rb = new ResBean();
		// rb.setResUserName(req.getParameter("User"));
		// rb.setResContent(req.getParameter("Content"));
		//
		// //ResBeanを引数にaddResを実行
		// ResExecute rx = new ResExecute();
		// rx.addRes(rb);
		// 
		// DBAccess dba = new DBAccess();
		// ArrayList<ResBean> users = dba.ThreadRead();
		//
		// //HttpServletRequetの実装クラスのインスタンスに
		// //usersという名前でデータを登録する
		//
		// req.setAttribute("users",users);
		//
		// //RequestDispatcherインターフェイスを実装するクラスの
		// //インスタンスを取得する
		// //引数は転送先のURL
		// RequestDispatcher dis=
		// req.getRequestDispatcher("testout");
		//
		// //上で設定した宛先にreqとresを転送する
		// dis.forward(req,res);

	}
}
