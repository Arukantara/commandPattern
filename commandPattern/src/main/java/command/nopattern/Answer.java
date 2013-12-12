package main.java.command.nopattern;

public class Answer implements Command {
	private Terminal terminal;
	
	public Answer(Terminal term){
		terminal = term;
	}
	
	@Override
	public String mostrar() {
		return "Answer to most important question";
	}
	
	@Override
	public void execute() {
		terminal.out("42");
	}

}
