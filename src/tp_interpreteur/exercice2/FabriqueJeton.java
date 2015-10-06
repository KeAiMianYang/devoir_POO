package tp_interpreteur.exercice2;

/**
 * Classe representant une fabrique de jetons de la grammaire. 
 *
 * @note Cette classe etant a usage interne, elle est invisible depuis 
 *   l'exterieur du paquetage.
 */
class FabriqueJeton {

    /**
     * Retourne le jeton associe a la parenthese ouvrante.
     *
     * @return le jeton associe a la parenthese ouvrante.
     */
    public static Jeton parentheseOuvrante() {
	return parentheseOuvrante;
    }

    /**
     * Retourne le jeton associe a la parenthese fermante.
     *
     * @return le jeton associe a la parenthese fermante.
     */
    public static Jeton parentheseFermante() {
	return parentheseFermante;
    }

    /**
     * Retourne le jeton associe a l'operateur d'addition.
     *
     * @return le jeton associe a l'operateur d'addition.
     */
    public static Jeton operateurPlus() {
	return operateurPlus;
    }

    /**
     * Retourne le jeton associe a l'operateur de soustraction.
     *
     * @return le jeton associe a l'operateur de soustraction.
     */
    public static Jeton operateurMoins() {
	return operateurMoins;
    }

    /**
     * Retourne le jeton associe a l'operateur de multiplication.
     *
     * @return le jeton associe a l'operateur de multiplication.
     */
    public static Jeton operateurMultiplie() {
	return operateurMultiplie;
    }

    /**
     * Retourne le jeton associe a l'operateur de division.
     *
     * @return le jeton associe a l'operateur de division.
     */
    public static Jeton operateurDivise() {
	return operateurDivise;
    }

    /**
     * Retourne le jeton associe a la fin d'expression.
     *
     * @return le jeton associe a la fin d'expression.
     */
    public static Jeton finExpression() {
	return finExpression;
    }

    /**
     * Retourne le jeton associe a un entier.
     *
     * @param representation la representation de l'entier.
     * @return le jeton associe a un entier.
     */
    public static Jeton entier(String representation) {
	return new Jeton(Jeton.Type.Entier, representation);
    }

    /**
     * Retourne le jeton associe a une representation inconnue.
     *
     * @param representation la representation inconnue.
     * @return le jeton associe a une representation inconnue.
     */
    public static Jeton inconnu(String representation) {
	return new Jeton(Jeton.Type.Inconnu, representation);
    }

    /**
     * Jeton associe a la parenthese ouvrante.
     */
    protected static final Jeton parentheseOuvrante = 
	new Jeton(Jeton.Type.ParentheseOuvrante, "(");

    /**
     * Jeton associe a la parenthese fermante.
     */
    protected static final Jeton parentheseFermante = 
	new Jeton(Jeton.Type.ParentheseFermante, ")");

    /**
     * Jeton associe a l'operateur d'addition.
     */
    protected static final Jeton operateurPlus = 
	new Jeton(Jeton.Type.OperateurPlus, "+");

    /**
     * Jeton associe a l'operateur de soustraction.
     */
    protected static final Jeton operateurMoins = 
	new Jeton(Jeton.Type.OperateurMoins, "-");

    /**
     * Jeton associe a l'operateur de multiplication.
     */
    protected static final Jeton operateurMultiplie = 
	new Jeton(Jeton.Type.OperateurMultiplie, "*");

    /**
     * Jeton associe a l'operateur de division.
     */
    protected static final Jeton operateurDivise = 
	new Jeton(Jeton.Type.OperateurDivise, "/");

    /**
     * Jeton assoie à la fin d'expression.
     */
    protected static final Jeton finExpression = 
	new Jeton(Jeton.Type.FinExpression, "");    

}