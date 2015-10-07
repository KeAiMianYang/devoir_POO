package devoir_POO;



/**
 * 
 * @author khorgn
 *
 */
public class Jeton {
	protected final Type a_type;
	protected final String a_representation;
	
	/**
	 * @author khorgn
	 *
	 */
	protected enum Type{
		Egal,
		PointVirgule,
		Chiffre,
		Lettre,
		Underscore,
		Virgule,
		FinExpression,
		Inconnu;
	}
	
	/**
	 * @param i_type
	 * @param i_representation
	 */
	protected Jeton(Type i_type, String i_representation){
		a_type = i_type;
		a_representation = i_representation;
	}
	
    /**
     * @return
     */
    public Type lire_type() {
	return a_type;
    }
    
    /**
     * @return
     */
    public String lire_representation() {
	return a_representation;
    }
    
    /**
     * @return
     */
    public boolean est_egal() {
	return a_type == Jeton.Type.Egal;
    }
    
    /**
     * @return
     */
    public boolean est_pointVirgule() {
	return a_type == Jeton.Type.PointVirgule;
    }
    
    /**
     * @return
     */
    public boolean est_chiffre() {
	return a_type == Jeton.Type.Chiffre;
    }
    
    /**
     * @return
     */
    public boolean est_lettre() {
	return a_type == Jeton.Type.Lettre;
    }
    
    /**
     * @return
     */
    public boolean est_underscore() {
	return a_type == Jeton.Type.Underscore;
    }
    
    /**
     * @return
     */
    public boolean est_virgule() {
	return a_type == Jeton.Type.Virgule;
    }
    
    /**
     * @return
     */
    public boolean est_finExpression() {
	return a_type == Jeton.Type.FinExpression;
    }
    
    /**
     * @return
     */
    public boolean est_inconnu() {
	return a_type == Jeton.Type.Inconnu;
    }
}
