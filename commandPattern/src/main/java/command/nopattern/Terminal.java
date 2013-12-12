package command;

import java.nio.charset.Charset;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import com.googlecode.lanterna.TerminalFacade;

public class Terminal {
	private final com.googlecode.lanterna.terminal.Terminal terminal;
	
	public Terminal() {
		terminal = TerminalFacade.createTerminal(Charset.forName("UTF8"));
	}
	
	public void clear() {
		terminal.clearScreen();
	}
	
	public Key leeOpcion() {
		Scanner scanner = new Scanner(System.in);
		String get;
		
		do {
			get = scanner.nextLine();
		} while (get.isEmpty());
		return new Key(get);
	}
	
	private void leeOpcionPause()  {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	
	public void pause() {
		System.out.println("---- Pulse enter para continuar ----");
		leeOpcionPause();		
	}

	public void title(String msg) {
		lines(1);
		System.out.println(StringUtils.repeat("-", msg.length()));
		System.out.println(msg);
		System.out.println(StringUtils.repeat("-", msg.length()));
		lines(2);
	}
	
	public void out(String msg) {
		System.out.println(msg);
	}

	public void lines(int num) {
		for (int i=1; i <= num; ++i) {
			System.out.println();
		}
	}
}
