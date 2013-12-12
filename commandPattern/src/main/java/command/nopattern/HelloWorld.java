package main.java.command.nopattern;

public class HelloWorld implements Command {
	private Terminal terminal;
	
	public HelloWorld(Terminal term){
		terminal = term;
	}
	
	@Override
	public String mostrar() {
		return "HelloWorld";
	}
	
	@Override
	public void execute() {
		terminal.out("Hello, World!");
	}

}
