class ThreadBean{
	public static void main(String args[]){

		private int thrId;
		private String thrName;
		private String thrCreateUser;
		private ArrayList resBean;
		private String thrCreateDate;
		private String thrUpdateDate;
		private int resCount;



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
		
		public String getCreateUser(){
			return thrCreateUser;
		}
		public void setCreateUser(String _CreateUser){
			this.thrCreateUser = _CreateUser;
		}
		
		public ArrayList getResBean(){
			return resBean;
		}
		public void setResBean(ArrayList _resBean){
			this.resBean = _resBean;
		}
		
		public String getCreateDate(){
			return thrCreateDate;
		}
		public void setCreateDate(String _CreateDate){
			this.thrCreateDate = _CreateDaate;
		}
		
		public String getUpdateDate(){
			return thrUpdateDate;
		}
		public void setCreateDate(String _UpdateDate){
			this.thrUpdateDate = _UpdateDate;
		}
		
		public int getResCount(){
			return resCount;
		}
		public void setResCount(int _resCount){
			this.resCount = _resCount;
		}



	}
}