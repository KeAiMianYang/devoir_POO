package tp_interpreteur.exercice2;

/**
 * Classe representant un jeton de la grammaire.
 */
class Jeton {

    /**
     * Type de ce jeton.
     */
    protected final Type type;

    /**
     * Representation de ce jeton sous forme d'une chaine de caractere.
     */
    protected final String representation;

    /**
     * Type enumere fortement type representant les differentes types de
     * jetons.
     */
    public enum Type {
	ParentheseOuvrante,
	ParentheseFermante,
	OperateurPlus,
	OperateurMoins,
	OperateurMultiplie,
	OperateurDivise,
	Entier,
	FinExpression,
	Inconnu
     }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Jeton#type}.
     */
    public Type lireType() {
	return type;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Jeton#representation}.
     */
    public String lireRepresentation() {
	return representation;
    }

    /**
     * Indique si ce jeton est associe a la parenthese ouvrante.
     *
     * @return true si ce jeton est associe a la parenthese ouvrante sinon 
     *   false.
     */
    public boolean estParentheseOuvrante() {
	return type == Jeton.Type.ParentheseOuvrante;
    }

    /**
     * Indique si ce jeton est associe a la parenthese fermante.
     *
     * @return true si ce jeton est associe a la parenthese fermante sinon 
     *   false.
     */
    public boolean estParentheseFermante() {
	return type == Jeton.Type.ParentheseFermante;
    }

    /**
     * Indique si ce jeton est associe a l'operateur d'addition.
     *
     * @return true si ce jeton est associe a l'operateur d'addition sinon 
     *   false.
     */
    public boolean estOperateurPlus() {
	return type == Jeton.Type.OperateurPlus;
    }

    /**
     * Indique si ce jeton est associe a l'operateur de soustraction.
     *
     * @return true si ce jeton est associe a l'operateur de soustraction sinon
     *   false.
     */
    public boolean estOperateurMoins() {
	return type == Jeton.Type.OperateurMoins;
    }

    /**
     * Indique si ce jeton est associe à l'operateur de multiplication.
     *
     * @return true si ce jeton est associe a l'operateur de multiplication 
     *   sinon false.
     */
    public boolean estOperateurMultiplie() {
	return type == Jeton.Type.OperateurMultiplie;
    }

    /**
     * Indique si ce jeton est associe a l'operateur de division.
     *
     * @return true si ce jeton est associe a l'operateur de division sinon 
     *   false.
     */
    public boolean estOperateurDivise() {
	return type == Jeton.Type.OperateurDivise;
    }

    /**
     * Indique si ce jeton est associe a un entier.
     *
     * @return true si ce jeton est associe a un entier sinon false.
     */
    public boolean estEntier() {
	return type == Jeton.Type.Entier;
    }

    /**
     * Indique si ce jeton est associe a la fin d'expression.
     *
     * @return true si ce jeton est associe a la fin d'expression sinon false.
     */
    public boolean estFinExpression() {
	return type == Jeton.Type.FinExpression;
    }

    /**
     * Indique si ce jeton est associe a une representation inconnue.
     *
     * @return true si ce jeton est associe a une representation inconnue sinon
     *   false.
     */
    public boolean estInconnu() {
	return type == Jeton.Type.Inconnu;
    }

    /**
     * Constructeur logique.
     *
     * @param type la valeur de {@link Jeton#type}.
     * @param representation la valeur de {@link Jeton#representation}.
     */
    protected Jeton(Type type, String representation) {
	this.type = type;
	this.representation = representation;
    }

}