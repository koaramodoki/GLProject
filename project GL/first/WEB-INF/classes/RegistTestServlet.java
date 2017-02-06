import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.math.BigDecimal;
import ip.Oracletest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;



//�T�u���b�g RecordServlet�̃N���X�錾
public class RegistTestServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		Oracletest ora = new Oracletest();
		
		
		
		try{//���܂�@�f�[�^�x�[�X�Ɛڑ����Ɏg�����́@Driver �C���^�[�t�F�[�X�����������N���X���������փ��[�h
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����@CONNECTION�C���^�[�t�F�[�X�����������N���X�̃C���X�^���X��
				Connection cn=
			DriverManager.getConnection //localhost:�i�|�[�g�ԍ��j:�i�t�@�B���j",	"(ID)","�i�p�X�j"
	 	 	 ("jdbc:oracle:thin:@localhost:1521:orcl",	"info","pro");
			cn.setAutoCommit(false);
			System.out.println("�ڑ�����");
			
			//SQL��ϐ��Ɋi�[
			String sql = "SELECT empno,ename from emp";
			//Statement �C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾
			Statement st = cn.createStatement();
			//SQL�����s���g�����U�N�V�������J�n�����@�������񂷂����Ԃ����
			//int count = st.executeUpdate(sql);
			
			
			//SELECT�������s�� ResultSet�C���^�[�t�F�C�X�����������N���X�̃C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);
			
			rs.next();
			ora.setName(rs.getString(1));
			ora.setTable(rs.getString(2));
			
			
			//�g�����U�N�V�������R�~�b�g
			cn.commit();
			//�X�e�[�g�����g��close
			st.close();
			//Oracle����ؒf����
			cn.close();
			System.out.println("�ؒf����");
			
			req.setAttribute("ora",ora);
			
			
			RequestDispatcher dispatcher=
			req.getRequestDispatcher("output");
			dispatcher.forward(req,res);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ�");
		//SQL�Ɛڑ����ɖ��N������
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗Ⴊ�Ȃ�");
		}catch(Exception e){
			e.printStackTrace();
		}
	
			
	}
}
