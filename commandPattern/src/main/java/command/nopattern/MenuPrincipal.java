package main.java.command.nopattern;

import java.io.IOException;
import java.util.ArrayList;
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

		ArrayList<Command> menus = new ArrayList<Command>();
		menus.add(new HelloWorld(term));
		menus.add(new Suma(term));
		menus.add(new Answer(term));
		term.title("Opciones chorras");
		for(int i=0;i<menus.size();i++){
			term.out(i+1 + ".- " + menus.get(i).mostrar());
		}
		term.out("Q+ Quit");
		ImmutableList<String> options = ImmutableList.of("1", "2", "3"); 
		term.lines(3);
		do {
			option = term.leeOpcion();
		} while (!option.isQuit() && !options.contains(option.toString()));
		
		/*
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
		*/
		if (!option.isQuit()) {
			int value = Integer.parseInt(option.toString());
			term.lines(3);
			menus.get(value-1).execute();
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
