package Server;


import java.io.Serializable;

public class CSMessage implements Task,Serializable{

	private static final long serialVersionUID = 2576054630188886037L;
	private String finalResult;
	
	@Override
	public void executeTask() {
	}
	
	
	//Setting message when required to inform client about error.
	public void setMessage(String msg){
		finalResult = msg;
	}

	@Override
	public Object getResult() {
		return finalResult;
	}

}
