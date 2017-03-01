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
		//jsp�ɑ��邽�߂�ArrayList�𐶐�
		ArrayList users = new ArrayList();
		//ThreadBean�̃C���X�^���X�𐶐�
        ThreadBean threadBean = new ThreadBean();
		//Execute�N���X�̃��\�b�h���g�����߂�Execute���C���X�^���X��
        MainExecute mainExecute = new MainExecute();

		//jsp���瑗��ꂽ�v�f��Bean�̃Z�b�^�[�Œl���i�[�B
		threadBean.setThrName(req.getParameter("name"));
		threadBean.setThrCreateUser(req.getParameter("user"));
		//String�^�̕ϐ��𐶐�

			//�Z�b�g���ꂽBean�̃C���X�^���X��addThread�ɑ���
		mainExecute.addThread(threadBean);
		//Execute����Thread�S�̂̃��X�g���󂯎��ArrayList�^�Ɋi�[�B
		users = mainExecute.getThread();

		//ArrayList��setAttribute�Ɋi�[
		req.setAttribute("users",users);

		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dis=
		req.getRequestDispatcher("ThrList");

		//��Őݒ肵�������req��res��]������
		dis.forward(req,res);

	}

	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{

		//�����R�[�h�ݒ�
		req.setCharacterEncoding("Windows-31J");

		DBAccess dba = new DBAccess();
		ArrayList<ThreadBean> users = dba.ThreadRead();

		//HttpServletRequet�̎����N���X�̃C���X�^���X��
		//users�Ƃ������O�Ńf�[�^��o�^����

		req.setAttribute("users",users);

		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dis=
		req.getRequestDispatcher("ThrList");

		//��Őݒ肵�������req��res��]������
		dis.forward(req,res);

	}
}
