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

//HttpServlet���p������JstlTestServlet�N���X�̍쐬
public class MainServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//�����R�[�h�ݒ�
		req.setCharacterEncoding("Windows-31J");
		ArrayList users = new ArrayList();

        ThreadBean threadBean = new ThreadBean();

        MainExecute mainExecute = new MainExecute();

		threadBean.setThName(req.getParameter("name"));
		threadBean.setThCreateUser(req.getParameter("user"));

		mainExecute.addThread(threadBean);

		users = mainExecute.getThread();


		req.setAttribute("users",users);

		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dis=
		req.getRequestDispatcher("ThreadOut");

		//��Őݒ肵�������req��res��]������
		dis.forward(req,res);

	}

	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//�����R�[�h�ݒ�
		req.setCharacterEncoding("Windows-31J");

		//�����Ă����l��ResBean�ɃZ�b�g
		ResBean rb = new ResBean();
		rb.setResUserName(req.getParameter("User"));
		rb.setResContent(req.getParameter("Content"));

		//ResBean��������addRes�����s
		ResExecute rx = new ResExecute();
		rx.addRes(rb);

		DBAccess dba = new DBAccess();
		ArrayList<ResBean> users = dba.ThreadRead();

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
