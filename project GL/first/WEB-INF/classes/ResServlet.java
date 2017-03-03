import Bean.ResBean;
import DBAccess.DBAccess;
import Execute.ResExecute;

import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//文字コード設定
		req.setCharacterEncoding("Windows-31J");

		//送られてきた値をResBeanにセット
		ResBean rb = new ResBean();
		String id = req.getParameter("id");
		rb.setThrId(id);
		rb.setResUserName(req.getParameter("User"));
		rb.setResContent(req.getParameter("Content"));

		//ResBeanを引数にaddResを実行
		ResExecute rx = new ResExecute();
		rx.addRes(rb);

		ArrayList<ResBean> li = rx.getRes(id);
		System.out.println("スレッドねーむ"+li.getThrName());

		//HttpServletRequetの実装クラスのインスタンスに
		//usersという名前でデータを登録する
		req.setAttribute("thrId",id);
		req.setAttribute("id",rx.getRes(id));

		req.setAttribute("thrName",li.getThrName());
		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dis=
		req.getRequestDispatcher("ResList");

		//上で設定した宛先にreqとresを転送する
		dis.forward(req,res);

	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//文字コード設定
		req.setCharacterEncoding("Windows-31J");

		ResExecute rx = new ResExecute();
		String id = req.getParameter("id");



		//HttpServletRequetの実装クラスのインスタンスに
		//usersという名前でデータを登録する
		req.setAttribute("thrId",id);
		req.setAttribute("id",rx.getRes(id));

		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dis=
		req.getRequestDispatcher("ResList");

		//上で設定した宛先にreqとresを転送する
		dis.forward(req,res);

	}
}
