package main.java.command.nopattern;

public class Suma implements Command {
	private Terminal terminal;
	
	public Suma(Terminal term){
		terminal = term;
	}
	
	@Override
	public String mostrar() {
		return "2+2?";
	}
	
	@Override
	public void execute() {
		terminal.out(String.format("2+2 son %d", 4));
	}

}
