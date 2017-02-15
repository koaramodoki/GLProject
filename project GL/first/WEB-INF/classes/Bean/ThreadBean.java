package Bean;

public class ThreadBean{

		private int thId;
		private String thName;
		private String thCreateUser;
		private String thCreateDate;
		private String thUpdateDate;
		private int resCount;
		private ResBean resBean;

		public ThreadBean(){}



		public int getThId(){
			return thId;
		}
		public void setThId(int _thId){
			this.thId = _thId;
		}

		public String getThName(){
			return thName;
		}
		public void setThName(String _thName){
			this.thName = _thName;
		}

		public String getThCreateUser(){
			return thCreateUser;
		}
		public void setThCreateUser(String _CreateUser){
			this.thCreateUser = _CreateUser;

		}
		public String getThCreateDate(){
			return thCreateDate;
		}
		public void setThCreateDate(String _CreateDate){
			this.thCreateDate = _CreateDate;
		}

		public String getThUpdateDate(){
			return thUpdateDate;
		}
		public void setThUpdateDate(String _UpdateDate){
			this.thUpdateDate = _UpdateDate;
		}

		public int getResCount(){
			return resCount;
		}
		public void setResCount(int _resCount){
			this.resCount = _resCount;
		}
}
