package Program;

public class Main {

	public static void main(String[] args) {
		// Uruchamiamy interfejs graficzny w bezpieczny sposób (SwingUtilities)
		
        javax.swing.SwingUtilities.invokeLater(() -> { new Program().start(); 
        
            // Tworzymy obiekt klasy Program i uruchamiamy go
        });
	}

}
