package Execute;

import Bean.ResBean;
import DBAccess.DBAccess;

import java.util.ArrayList;

public class ResExecute{

	DBAccess dba = new DBAccess();

	public void addRes(ResBean rb){
		String sql;

		String resUserName = rb.getResUserName();
		if(resUserName==""){
			sql="insert into ResTest(resId,CreateDate,Content) values (rtseq.nextval,sysdate,'"+rb.getResContent()+"')";
		}else{
			sql="insert into ResTest(resId,UserName,CreateDate,Content) values (rtseq.nextval,'"+resUserName+"',sysdate,'"+rb.getResContent()+"')";
		}

		dba.write(sql);
	}
	public ArrayList getRes(int resId){

	}
}
