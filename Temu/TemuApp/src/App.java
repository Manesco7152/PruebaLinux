 // Make sure this matches your App's actual package

import UI.MainMenu; // <--- ADD THIS LINE: Import your MainMenu class

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando la aplicación de gestión de E-commerce..."); // A more descriptive start message

        // Call the main method of MainMenu to start the interactive menu
        MainMenu.main(args); // <--- ADD THIS LINE

        System.out.println("Aplicación finalizada. ¡Hasta luego!"); // An ending message
    }
}