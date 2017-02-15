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

		String ThName = tb.getThName();
		String ThCreateUser = tb.getThCreateUser();
		if(ThCreateUser==""){
			sql="insert into GLThread(ThId,ThName,ThCreateDate) values (rtseq.nextval,'"+ThName+"',sysdate)";
		}else{
			sql="insert into GLThread(ThId,ThName,ThUserName,ThCreateDate) values (rtseq.nextval,'"+ThName+"','"+ThCreateUser+"',sysdate)";
		}

		dba.write(sql);
	}
	public ArrayList getThread(){
		ArrayList al = new ArrayList();
		al = dba.ThreadRead();
		return al;
	}


}
