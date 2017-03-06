import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet���p������JstlTestServlet�N���X�̍쐬
public class SeqDeleteServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		int result=0;
		
		//�����R�[�h�ݒ�
		req.setCharacterEncoding("Windows-31J");
		
		System.out.println("(�L�E�ցE`)");
		//POST�v���ɂ���đ��M���ꂽ�p�����[�^�[���擾����
		String in = req.getParameter("deleteCount");
		System.out.println(in);
		int deleteCount = Integer.parseInt(in);
		System.out.println(deleteCount);
			
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");//JDBC�h���C�o�̐錾
				//Oracle�ɐڑ�����
			Connection cn =
			DriverManager.getConnection
	 	 	 ("jdbc:oracle:thin:@localhost:1521:orcl",	"info","pro");
			
			//�����R�~�b�g��OFF�ɂ���
			cn.setAutoCommit(false);
			
			System.out.println("�ڑ�����");
			
			Statement st=cn.createStatement();
			
			for(int i=1;i < deleteCount;i++){
				String sql ="drop sequence ResSequence"+i+" ";
				
				int j = st.executeUpdate(sql);
				result += j;
				System.out.println(result);
				System.out.println("for��");
			}
		
			cn.commit();
			
			st.close();
			
			cn.close();
			System.out.println("�ؒf����");
				
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�ڑ����s");
		}
	
		
		//HttpServletRequet�̎����N���X�̃C���X�^���X��
		//users�Ƃ������O�Ńf�[�^��o�^����
		
		req.setAttribute("result",result);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dis=
		req.getRequestDispatcher("seqout");
		
		//��Őݒ肵�������req��res��]������
		dis.forward(req,res);
		
	}
}
