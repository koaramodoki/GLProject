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
	
		String ThrCreateUser = tb.getThrCreateUser();
		if(ThrCreateUser==""){
			//ここでシーケンス作成
			sql="insert into GLThread(ThrId,ThrName,CreateDate) values (threadsequence.nextval,'"+tb.getThrName()+"',sysdate)";
		}else{
			sql="insert into GLThread(ThrId,ThrName,UserName,CreateDate) values (threadsequence.nextval,'"+tb.getThrName()+"','"+tb.getThrCreateUser()+"',sysdate)";
		}


		dba.write(sql);
		dba.seqCreate();

	}
	public ArrayList getThread(){
		ArrayList al = new ArrayList();
		al = dba.ThreadRead();
		return al;
	}
}
