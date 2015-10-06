package tp_interpreteur.exercice2;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Classe representant un compilateur de la grammaire.
 */
public class Compilateur {

    /**
     * Constructeur logique.
     *
     * @param lecteur la valeur de {@link Compilateur#lexical}.
     */
    public Compilateur(Lexical lexical) {
	this.lexical = lexical;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Compilateur#lexical}.
     */
    public Lexical lireLexical() {
	return lexical;
    }

    /**
     * Analyse l'expression connectee a l'analyseur lexical et genere le code
     * correspondant.
     *
     * @return true si l'expression est syntaxiquement correcte sinon false.
     * @param sortie le flot de sortie sur lequel ecrire les instrutions.
     * @throw IOException si l'analyseur lexical ne parvient pas a lire
     *   l'expression.
     */
    public boolean compiler(PrintStream sortie) throws IOException {

	// Pre-chargement du premier jeton.
	precharge = lexical.suivant();

	// Appel de la methode associee a la regle "Expression".
	if (! compilerExpression(sortie)) {
	    return false;
	}

	// Generation de l'instruction d'affichage du sommet de pile.
	sortie.println("print");

	// Il faut verifier que nous avons atteint la fin du texte.
	return precharge.estFinExpression();

    }

    /**
     * Methode associee a la regle "Expression".
     *
     * @return true si la regle est satisfaite sinon false.
     * @param sortie le flot de sortie sur lequel ecrire les instrutions.
     * @throw IOException si l'analyseur lexical ne parvient pas a lire
     *   l'expression.
     */
    protected boolean compilerExpression(PrintStream sortie) 
	throws IOException {
	
	// Il faut se rappeler si l'operateur moins etait present.
	boolean negatif = precharge.estOperateurMoins();

	// Test de l'operateur additif optionnel.
	if (precharge.estOperateurPlus() || negatif) {

	    // L'operateur est present : il faut passer au jeton suivant.
	    precharge = lexical.suivant();

	}

	// Appel de la methode associee a la regle "Terme".
	if (! compilerTerme(sortie)) {
	    return false;
	}

	// Si l'operateur moins etait present, il faut generer l'instruction de
	// changement de signe du sommet de pile.
	if (negatif) {
	    sortie.println("neg");
	}

	// Il faut encore se rappeler si l'operateur moins etait present.
	negatif = precharge.estOperateurMoins();	

	// Sequences eventuelles composees d'un operateur additif suivi d'un
	// terme.
	while (precharge.estOperateurPlus() || negatif) {

	    // Passe l'operateur.
	    precharge = lexical.suivant();

	    // Appel de la methode associee a la regle "Terme".
	    if (! compilerTerme(sortie)) {
		return false;
	    }

	    // Generation de l'instruction d'addition ou de soustraction des 
	    // deux elements en sommet de pile.
	    sortie.println((negatif ? "sub" : "add"));

	    // Se rappeler encore de la presence de l'operateur moins.
	    negatif = precharge.estOperateurMoins();

	}

	// La regle expression est satisfaite.
	return true;

    }

    /**
     * Methode associee a la regle "Terme".
     *
     * @return true si la regle est satisfaite sinon false.
     * @param sortie le flot de sortie sur lequel ecrire les instrutions.
     * @throw IOException si l'analyseur lexical ne parvient pas a lire
     *   l'expression.
     */
    protected boolean compilerTerme(PrintStream sortie) throws IOException {

	// Appel de la methode associee a la regle "Facteur".
	if (! compilerFacteur(sortie)) {
	    return false;
	}

	// Il faut se rappeler si l'operateur multiplie etait present.
	boolean multiplie = precharge.estOperateurMultiplie();

	// Sequences eventuelles composees d'un operateur multiplicatif suivi
	// d'un facteur.
	while (multiplie || precharge.estOperateurDivise()) {

	    // Passer l'operateur.
	    precharge = lexical.suivant();

	    // Appel de la methode associee a la regle "Facteur".
	    if (! compilerFacteur(sortie)) {
		return false;
	    }

	    // Generer l'instruction de multiplication ou de division des deux
	    // elements en sommet de pile.
	    sortie.println((multiplie ? "mul" : "div"));

	    // Se rappeler encore si l'operateur multiplicatif etait present.
	     multiplie = precharge.estOperateurMultiplie();
	    
	}

	// La regle est satisfaite.
	return true;	

    }

    /**
     * Methode associee a la regle "Facteur".
     *
     * @return true si la regle est satisfaite sinon false.
     * @param sortie le flot de sortie sur lequel ecrire les instrutions.
     * @throw IOException si l'analyseur lexical ne parvient pas a lire
     *   l'expression.
     */
    protected boolean compilerFacteur(PrintStream sortie) throws IOException {

	// Si le jeton precharge est une parenthese ouvrante, il s'agit d'une
	// nouvelle expression parenthesee.
	if (precharge.estParentheseOuvrante()) {

	    // Passer la parenthese.
	    precharge = lexical.suivant();

	    // Appel de la methode associee a la regle "Expression".
	    if (! compilerExpression(sortie)) {
		return false;
	    }

	    // Le jeton precharge doit etre une parenthese fermante.
	    if (! precharge.estParentheseFermante()) {
		return false;
	    }

	    // Passer la parenthese fermante.
	    precharge = lexical.suivant();

	    // La regle est satisfaite.
	    return true;

	}

	// Le jeton precharge est un entier.
	if (precharge.estEntier()) {

	    // Generer l'instruction consistant a empiler l'element.
	    sortie.println("push " + precharge.lireRepresentation());

	    // Passer l'entier.
	    precharge = lexical.suivant();

	    // La regle est satisfaite.
	    return true;

	}

	// Le jeton est inconnu.
	return false;

    }

    /**
     * Analyseur lexical.
     */
    protected Lexical lexical;

    /**
     * Dernier jeton precharge.
     */
    protected Jeton precharge;

}