import Bean.ResBean;
import DBAccess.DBAccess;

import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet���p������JstlTestServlet�N���X�̍쐬
public class DBATestServlet extends HttpServlet{
	
	//ArrayList���g�p
	private ArrayList<ResBean> users;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		//�����R�[�h�ݒ�
		req.setCharacterEncoding("Windows-31J");
		
		ResBean rb = new ResBean();
		rb.setResId(Integer.parseInt(req.getParameter("Id")));
		rb.setResUserName(req.getParameter("User"));
		rb.setResContent(req.getParameter("Content"));
		
		DBAccess dba = new DBAccess();
		dba.write(rb);
		users = dba.read();
		
		//HttpServletRequet�̎����N���X�̃C���X�^���X��
		//users�Ƃ������O�Ńf�[�^��o�^����
		
		req.setAttribute("users",users);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dis=
		req.getRequestDispatcher("testout");
		
		//��Őݒ肵�������req��res��]������
		dis.forward(req,res);
		
	}
}
