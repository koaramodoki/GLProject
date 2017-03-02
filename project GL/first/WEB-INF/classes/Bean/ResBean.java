package Bean;

public class ResBean{
	private String thrId;
	private int resId;
	private String resUserName;
	private String resCreateDate;
	private String resContent;
	private int resStamp;

	public ResBean(){}

	public int getResId(){
		return resId;
	}
	public String getResUserName(){
		return resUserName;
	}
	public String getResCreateDate(){
		return resCreateDate;
	}
	public String getResContent(){
		return resContent;
	}
	public int getResStamp(){
		return resStamp;
	}

	public void setResId(int resId){
		this.resId=resId;
	}
	public void setResUserName(String resUserName){
		this.resUserName=resUserName;
	}
	public void setResCreateDate(String resCreateDate){
		this.resCreateDate=resCreateDate;
	}
	public void setResContent(String resContent){
		this.resContent=resContent;
	}
	public void setResStamp(int resStamp){
		this.resStamp=resStamp;
	}
	//================================================
		public String getThrId(){
			return thrId;
		}
		public void setThrId(String _thrId){
			this.thrId = _thrId;
		}
}
