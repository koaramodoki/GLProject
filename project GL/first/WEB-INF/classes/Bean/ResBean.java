package Bean;

public class ResBean{
	private int resId;
	private String resUserName;
	private String resCreateDate;
	private String resContent;
	private int resDeleteFlag;
	private int resStamp;
	
	public ResBean(){}
	
	public int getResId(){
		return resId;
	}
	public String getResUserName(){
		return resUserName;
	}
	public String getResCreateDate(){
		return resDate;
	}
	public String getResContent(){
		return resContent;
	}
	public int getResDeleteFlag(){
		return resDeleteFlag;
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
	public void setResCreateDate(String resDate){
		this.resCreateDate=resCreateDate;
	}
	public void setResContent(String resContent){
		this.resContent=resContent;
	}
	public void setResDeleteFlag(int resDeleteFlag){
		this.resDeleteFlag=resDeleteFlag;
	}
	public void setResStamp(int resStamp){
		this.resStamp=resStamp;
	}
}