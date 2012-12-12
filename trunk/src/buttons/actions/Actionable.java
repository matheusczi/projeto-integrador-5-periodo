package buttons.actions;

public class Actionable{
	protected String text;
	
	public Actionable(String text){
		this.text = text;
	}
	
	public void action(){

	}

	public CharSequence getText(){
		return text;
	}

	public void setName(String name){
		text = name;
	}
}
