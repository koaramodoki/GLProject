import Bean.ResBean;
import DBAccess.DBAccess;
import Execute.ResExecute;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;

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
		res.setContentType("text/html; charset=Windows-31J");

		ResExecute rx = new ResExecute();
		//送られてきた値をResBeanにセット
		ResBean rb = new ResBean();
		String id = req.getParameter("id");
		//String thrName = rx.gtn();
		String thrName = req.getParameter("thrName");
		//String thrName = new String(URLDecoder.decode(req.getParameter("thrName"), "iso-8859-1").getBytes("iso-8859-1"),"Windows-31J");
		System.out.println("thrNameゲットだぜ"+thrName);
		rb.setThrId(id);
		rb.setThrName(thrName);
		rb.setResUserName(req.getParameter("User"));
		rb.setResContent(req.getParameter("Content"));

		//ResBeanを引数にaddResを実行
		rx.addRes(rb);

		//HttpServletRequetの実装クラスのインスタンスに
		//usersという名前でデータを登録する
		req.setAttribute("thrName",thrName);
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
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//文字コード設定
		req.setCharacterEncoding("Windows-31J");
		res.setContentType("text/html; charset=Windows-31J");

		ResExecute rx = new ResExecute();
		String id = req.getParameter("id");
		//String thrName = req.getParameter("thrName");
		//String thrName = new String (req.getParameter("thrName").getBytes("ISO-8859-1"));
		String thrName = new String(URLDecoder.decode(req.getParameter("thrName"), "iso-8859-1").getBytes("iso-8859-1"),"Windows-31J");


		//HttpServletRequetの実装クラスのインスタンスに
		//usersという名前でデータを登録する

		req.setAttribute("thrName",thrName);
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
