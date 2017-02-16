package Bean;

public class ThreadBean{

		private int thrId;
		private String thrName;
		private String thrCreateUser;
		private String thrCreateDate;
		private String thrUpdateDate;
		private int resCount;
		private ResBean resBean;

		public ThreadBean(){}


//================================================
		public int getThrId(){
			return thrId;
		}
		public void setThrId(int _thId){
			this.thrId = _thId;
		}
//=================================================
		public String getThrName(){
			return thrName;
		}
		public void setThrName(String _thName){
			this.thrName = _thName;
		}
//=================================================
		public String getThrCreateUser(){
			return thrCreateUser;
		}
		public void setThrCreateUser(String _CreateUser){
			this.thrCreateUser = _CreateUser;
		}
//==================================================
		public String getThrCreateDate(){
			return thrCreateDate;
		}
		public void setThrCreateDate(String _CreateDate){
			this.thCreateDate = _CreateDate;
		}
//===================================================
		public int getResCount(){
			return resCount;
		}
		public void setResCount(int _resCount){
			this.resCount = _resCount;
		}
//===================================================
		public ResBean getresBean(){
			return ResBean;
		}
		public void setresBean(ResBean _resBean){
			this.resBean = _resBean;
		}	
//====================================================
}
