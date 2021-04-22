package beans;

public class Staff {
	private String ID;
	private String STPassword;
	private String STRank;
    private String STName;
    private String Email;
    private String Department;
    private String Question1;
	private String Answer1;
	private String Question2;
	private String Answer2;   
	private String Question3;
	private String Answer3;
	public String getQuestion3() {
		return Question3;
	}
	public void setQuestion3(String question3) {
		this.Question3 = question3;
	}
    public String getAnswer3() {
		return Answer3;
	}
	public void setAnswer3(String answer3) {
		this.Answer3 = answer3;
	}
	public String getAnswer2() {
		return Answer2;
	}
	public void setAnswer2(String answer2) {
		this.Answer2 = answer2;
	}
    public String getQuestion2() {
		return Question2;
	}
	public void setQuestion2(String question2) {
		this.Question2 = question2;
	}
    public String getAnswer1() {
		return Answer1;
	}
	public void setAnswer1(String answer1) {
		this.Answer1 = answer1;
	}
	public String getID(){
		return ID;
	}
	public void setID(String ID)
	{
	  this.ID=ID;	
	}
    public String getQuestion1() {
		return Question1;
	}
	public void setQuestion1(String question1) {
		this.Question1 = question1;
	}
	public String getSTPassword() {
		return STPassword;
	}
	public void setSTPassword(String STPassword)
	{
	  this.STPassword=STPassword;	
	}
	public String getSTRank(){
		return STRank;
	}
	public void setSTRank(String STRank)
	{
	  this.STRank=STRank;	
	}
	public String getSTName(){
		return STName;
	}
	public void setSTName(String STName)
	{
	  this.STName=STName;	
	}
	public String getEmail(){
		return Email;
	}
	public void setEmail(String Email)
	{
	  this.Email=Email;	
	}
	public String getDepartment(){
		return Department;
	}
	public void setDepartment(String Department)
	{
	  this.Department=Department;	
	}

}
