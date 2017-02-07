import Bean.ResBean;
import DBAccess.DBAccess;

import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServletを継承したJstlTestServletクラスの作成
public class DBATestServlet extends HttpServlet{
	
	//ArrayListを使用
	private ArrayList<ResBean> users;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		//文字コード設定
		req.setCharacterEncoding("Windows-31J");
		
		ResBean rb = new ResBean();
		rb.setResId(Integer.parseInt(req.getParameter("Id")));
		rb.setResUserName(req.getParameter("User"));
		rb.setResContent(req.getParameter("Content"));
		
		DBAccess dba = new DBAccess();
		dba.write(rb);
		users = dba.read();
		
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
