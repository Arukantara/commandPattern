package command;

public class Key {
		String option;
		
		public Key(String opcion) {
			option = opcion.toUpperCase().trim();
		}
		
		public boolean isQuit() {
			return option.equalsIgnoreCase("q");
		}
		
		@Override
		public String toString() {
			return option;
		}
		
		public boolean equal(String cad) {
			if (this.isQuit())
				return false;
			else 
				return option.equalsIgnoreCase(cad);
		}

		public boolean isEmpty() {
			if (option == null)
				return true;
			else
				return option.length()==0;
		}
}
