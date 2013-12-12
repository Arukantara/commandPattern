package command;

import java.io.IOException;

import com.google.common.collect.ImmutableList;

public class MenuPrincipal {
	
	public static void printSubMenu() throws IOException {
		Key option;
		
		do {
			Terminal term = new Terminal();
			term.clear();	
			term.title("Submenu");
			term.out("A.- Nombre");
			term.out("B.- Apellido");
			term.out("Q- Salir");
			ImmutableList<String> options = ImmutableList.of("A", "B"); 
			term.lines(3);
			
			do {
				option = term.leeOpcion();
			} while (!option.isQuit() && !options.contains(option.toString()));
			
			String value = option.toString();
			term.lines(3);
			
			if (value.equalsIgnoreCase("A")) {
				term.out("Daniel");
			}
			else if (value.equalsIgnoreCase("B")) {
				term.out("Molina");
			}
			
		} while (!option.isQuit());
	}

	public static void printMenu() throws IOException {
		Key option;
		
		do {
		Terminal term = new Terminal();
		term.clear();	
		term.title("Opciones chorras");
		term.out("1.- HelloWord");
		term.out("2.- 2+2?");
		term.out("3.- Answer to most important question");
		term.out("4.- Submenu");
		term.out("Q+ Quit");
		ImmutableList<String> options = ImmutableList.of("1", "2", "3", "4"); 
		term.lines(3);
		do {
			option = term.leeOpcion();
		} while (!option.isQuit() && !options.contains(option.toString()));
		
		String value = option.toString();
		term.lines(3);
		
		if (value.equals("1")) {
			term.out("Hello, World!");
		}
		else if (value.equals("2")) {
			term.out(String.format("2+2 son %d", 4));
		}
		else if (value.equals("3")){
			term.out("42");
		}
		else if(value.equals("4")) {
			printSubMenu();
		}
		
		if (!option.isQuit()) {
			term.lines(2);
			term.pause();
		}
		
		} while (!option.isQuit());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			printMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
