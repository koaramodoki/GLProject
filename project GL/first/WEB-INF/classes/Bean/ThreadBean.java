package Bean;

public class ThreadBean{

		private String thrId;
		private String thrName;
		private String thrCreateUser;
		private String thrCreateDate;
		private ResBean resBean;
		private String resCount;
		private String updateDate;

		public ThreadBean(){}


//================================================
		public String getThrId(){
			return thrId;
		}
		public void setThrId(String _thrId){
			this.thrId = _thrId;
		}
//=================================================
		public String getThrName(){
			return thrName;
		}
		public void setThrName(String _thrName){
			this.thrName = _thrName;
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
			this.thrCreateDate = _CreateDate;
		}
//===================================================
		public void setResCount(String _resCount){
			this.resCount = _resCount;
		}
		public String getResCount(){
			return resCount;
		}
//===================================================
		public ResBean getResBean(){
			return resBean;
		}
		public void setResBean(ResBean _resBean){
			this.resBean = _resBean;
		}
//====================================================
		public String getUpdateDate(){
			return updateDate;
		}
		public void setUpdateDate(String updateDate){
			this.updateDate = updateDate;
		}
}
