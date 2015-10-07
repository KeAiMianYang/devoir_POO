package devoir_POO;

public class Jeton {
	protected final Type a_type;
	protected final String a_representation;
	
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
	
	protected Jeton(Type i_type, String i_representation){
		a_type = i_type;
		a_representation = i_representation;
	}
}
