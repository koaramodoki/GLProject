package Bean;

public class ThreadBean{

		private int thrId;
		private String thrName;
		private String thrCreateUser;
		private String thrCreateDate;
		private String thrUpdateDate;
		private int resCount;

		public ThreadBean(){}



		public int getThrId(){
			return thrId;
		}
		public void setThrId(int _thrId){
			this.thrId = _thrId;
		}

		public String getThrName(){
			return thrName;
		}
		public void setThrName(String _thrName){
			this.thrName = _thrName;
		}

		public String getThrCreateUser(){
			return thrCreateUser;
		}
		public void setThrCreateUser(String _CreateUser){
			this.thrCreateUser = _CreateUser;
		}

		public String getThrUpdateDate(){
			return thrUpdateDate;
		}
		public void setThrCreateDate(String _UpdateDate){
			this.thrUpdateDate = _UpdateDate;
		}

		public int getResCount(){
			return resCount;
		}
		public void setResCount(int _resCount){
			this.resCount = _resCount;
		}
}
