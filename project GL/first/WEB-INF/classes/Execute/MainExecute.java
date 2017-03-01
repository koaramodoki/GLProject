package Execute;

import Bean.ResBean;
import Bean.ThreadBean;
import DBAccess.DBAccess;

import java.util.ArrayList;

public class MainExecute{

	DBAccess dba = new DBAccess();
	int ThreadId;

	public void addThread(ThreadBean tb){
		String sql;

		String ThCreateUser = tb.getThrCreateUser();
		if(ThCreateUser==""){
			sql="insert into GLThread(ThId,ThName,ThCreateDate) values (rtseq.nextval,'"+tb.getThrName()+"',sysdate)";
		}else{
			sql="insert into GLThread(ThId,ThName,ThUserName,ThCreateDate) values (rtseq.nextval,'"+tb.getThrName()+"','"+tb.getThrCreateUser()+"',sysdate)";
		}

		dba.write(sql);
	}
	public ArrayList getThread(){
		ArrayList al = new ArrayList();
		al = dba.ThreadRead();
		return al;
	}


}
