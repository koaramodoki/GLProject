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

		//�����R�[�h�ݒ�
		req.setCharacterEncoding("Windows-31J");
		res.setContentType("text/html; charset=Windows-31J");

		ResExecute rx = new ResExecute();
		//�����Ă����l��ResBean�ɃZ�b�g
		ResBean rb = new ResBean();
		String id = req.getParameter("id");
		//String thrName = rx.gtn();
		String thrName = req.getParameter("thrName");
		//String thrName = new String(URLDecoder.decode(req.getParameter("thrName"), "iso-8859-1").getBytes("iso-8859-1"),"Windows-31J");
		System.out.println("thrName�Q�b�g����"+thrName);
		rb.setThrId(id);
		rb.setThrName(thrName);
		rb.setResUserName(req.getParameter("User"));
		rb.setResContent(req.getParameter("Content"));

		//ResBean��������addRes�����s
		rx.addRes(rb);

		//HttpServletRequet�̎����N���X�̃C���X�^���X��
		//users�Ƃ������O�Ńf�[�^��o�^����
		req.setAttribute("thrName",thrName);
		req.setAttribute("thrId",id);
		req.setAttribute("id",rx.getRes(id));

		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dis=
		req.getRequestDispatcher("ResList");

		//��Őݒ肵�������req��res��]������
		dis.forward(req,res);

	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//�����R�[�h�ݒ�
		req.setCharacterEncoding("Windows-31J");
		res.setContentType("text/html; charset=Windows-31J");

		ResExecute rx = new ResExecute();
		String id = req.getParameter("id");
		//String thrName = req.getParameter("thrName");
		//String thrName = new String (req.getParameter("thrName").getBytes("ISO-8859-1"));
		String thrName = new String(URLDecoder.decode(req.getParameter("thrName"), "iso-8859-1").getBytes("iso-8859-1"),"Windows-31J");


		//HttpServletRequet�̎����N���X�̃C���X�^���X��
		//users�Ƃ������O�Ńf�[�^��o�^����

		req.setAttribute("thrName",thrName);
		req.setAttribute("thrId",id);
		req.setAttribute("id",rx.getRes(id));

		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dis=
		req.getRequestDispatcher("ResList");

		//��Őݒ肵�������req��res��]������
		dis.forward(req,res);

	}
}
