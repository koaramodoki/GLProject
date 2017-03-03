package Execute;

import Bean.ResBean;
import DBAccess.DBAccess;

import java.util.ArrayList;

public class ResExecute{

	DBAccess dba = new DBAccess();

	public void addRes(ResBean rb){
		String sql;

		String resUserName = rb.getResUserName();
		System.out.println("¡‚©‚çƒŒƒX‚Ì‘}“ü‚·‚é‚æ"+rb.getThrName());
		if(resUserName==""){
			sql="insert into GLRes(thrId,resId,CreateDate,Content) values ('"+rb.getThrId()+"',ressequence"+rb.getThrId()+".nextval,sysdate,'"+rb.getResContent()+"')";
		}else{
			sql="insert into GLRes(thrId,resId,UserName,CreateDate,Content) values ('"+rb.getThrId()+"',ressequence"+rb.getThrId()+".nextval,'"+resUserName+"',sysdate,'"+rb.getResContent()+"')";
		}
		System.out.println("¡‚©‚çƒŒƒX‚Ì‘}“ü‚µ‚½‚æ");

		dba.write(sql);
	}

	public ArrayList getRes(String _id){
		String id = _id;

		return dba.resRead(id);
	}
}
