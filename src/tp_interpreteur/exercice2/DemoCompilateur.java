package tp_interpreteur.exercice2;

import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Classe representant le programme de demonstration de l'analyseur syntaxique.
 */
class DemoCompilateur {

    /**
     * Point d'entree de la JVM.
     *
     * @param args - les arguments de la ligne de commandes.
     */
    public static void main(String[] args) {

	// La ligne de commandes est vide : l'utilisateur demande de l'aide.
	if (args.length == 0) {
	    System.out.println("Usage: java DemoLexical nomdefichier");
	    return;
	}

	// Plus d'un argument sur la ligne de commandes : l'utilisateur fait
	// n'importe quoi.
	if (args.length != 1) {
	    System.err.println("Nombre d'arguments incorrect.");
	    return;
	}

	// Tentative de connexion d'un flot d'entree au fichier.
	LineNumberReader lecteur = null;
	try {
	    lecteur = new LineNumberReader(new FileReader(args[0]));
	}
	catch(FileNotFoundException e) {
	    System.err.println("Le fichier [" + args[0] + "] n'existe pas.");
	    return;
	}

	// Instanciation de l'analyseur lexical.
	Lexical lexical = new Lexical(lecteur);

	// Instanciation de l'analyseur syntaxique.
	Compilateur compilateur = new Compilateur(lexical);

	// Compilation de l'expression : il s'agit d'une operation a risque
	// qui doit etre encagee dans un traite-exception.
	try {
		PrintStream os = new PrintStream("src/a.thug");
	    // Compilation.
	    if (compilateur.compiler(os)) {
	    	os.close();
	    	return;
	    }

	    // L'expression est incorrecte : il faut afficher ce qui pose
	    // probleme.
	    final String ligne = lexical.lireLigne();
	    final int position = lexical.lirePosition();
	    final String message = "Erreur (entre crochets) en ligne : " + 
		lecteur.getLineNumber() + 
		"\n" +
		ligne.substring(0, position - 1) + 
		"[" +
		ligne.charAt(position - 1) +
		"]" +
		ligne.substring(position, ligne.length()) +
		"\n";
	    System.err.println(message);

	}
	catch(IOException e) {
	    System.err.println("Impossible de lire [" + args[0] + "]");
	    return;
	}

    }

}