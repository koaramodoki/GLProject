import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.math.BigDecimal;
import Bean.ResBean;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;



public class testServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{

		List<ResBean> ririri = new ArrayList<ResBean>();


		String AAA = req.getParameter("resId");
		String BBB = req.getParameter("userName");
		String CCC = req.getParameter("createDate");
		String DDD = req.getParameter("content");
		String EEE = req.getParameter("deleteFlag");
		String FFF = req.getParameter("resStamp");
		int GGG = Integer.parseInt(AAA);
		int HHH = Integer.parseInt(EEE);
		int III = Integer.parseInt(FFF);

		ResBean JJJ = new ResBean();
		JJJ.setResId(GGG);
		JJJ.setResUserName(BBB);
		JJJ.setResCreateDate(CCC);
		JJJ.setResContent(DDD);
		JJJ.setResDeleteFlag(HHH);
		JJJ.setResStamp(III);

		ririri.add(JJJ);


		req.setAttribute("P",ririri);

		RequestDispatcher dispatcher=req.getRequestDispatcher("BBB");
		dispatcher.forward(req,res);

	}
}
