package tp_interpreteur.interpreteur;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Stack;

public class Interpreteur {
	LineNumberReader a_file;
	Stack<Integer> a_stack;
	/**
	 * 
	 * @author kork
	 *
	 */
	public enum Mnemonic{
		print,
		push,
		div,
		add,
		sub,
		mul,
		neg;
	}
	/**
	 * 
	 * @param i_file
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public Interpreteur(String i_file) throws IOException, FileNotFoundException{
		a_file = new LineNumberReader(new FileReader(i_file));
		a_stack = new Stack<Integer>();
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			if(args.length == 0){
				System.out.println("Interpreteur monFichier");
				System.exit(0);
			}
			if(args.length != 1){
				System.err.println("mauvais nombre d'arguments");
				System.exit(0);
			}
			// the real program
			Interpreteur interpreteur = new Interpreteur(args[0]);
			
			interpreteur.interprete();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	private void interprete() throws IOException{
		String[] tokens;
		
		do{
			tokens = this.splitNextLine();
			int v1, v2;
			switch(Mnemonic.valueOf(tokens[0])){
			// Mnemonic.valueOf() transforme le type de l'enum en string
			case print:
				System.out.println(a_stack.pop());
				break;
			case push:
				a_stack.push(Integer.valueOf(tokens[1]));
				break;
			case div:
				v1 = a_stack.pop();
				v2 = a_stack.pop();
				a_stack.push(v2/v1);
				break;
			case add:
				v1 = a_stack.pop();
				v2 = a_stack.pop();
				a_stack.push(v2+v1);
				break;
			case sub:
				v1 = a_stack.pop();
				v2 = a_stack.pop();
				a_stack.push(v2-v1);
				break;
			case mul:
				v1 = a_stack.pop();
				v2 = a_stack.pop();
				a_stack.push(v2*v1);
				break;
			case neg:
				v1 = a_stack.pop();
				a_stack.push(-v1);
			}
		}while(tokens[0] != null);
	}
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	private String[] splitNextLine() throws IOException {
		return a_file.readLine().split(" ");
	}
}
