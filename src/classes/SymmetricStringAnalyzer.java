package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}

	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 

		SLLStack<Character> stack = new SLLStack<Character>(); 
		for (int i=0; i < s.length(); i++) { 
			char c = s.charAt(i);
			if (Character.isLetter(c))
				if (Character.isUpperCase(c))
					stack.push(c);
				else if (stack.isEmpty())
					return false; 
				else {
					char t = stack.top();
					if (t == Character.toUpperCase(c))
						stack.pop();  
					else 
						return false; 
				}
			else 
				return false; 
		} 
		
		if(!stack.isEmpty())
			return false;
		
		return true; 
	}


	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() throws StringIsNotSymmetricException {

		SLLStack<Character> stack = new SLLStack<Character>(); 
		String sParen = "";
		
		if(!(this.isValidContent()))
			throw new StringIsNotSymmetricException("S is not symmetric." + s);
		
		for (int i=0; i < s.length(); i++) { 
			char c = s.charAt(i);
			if (Character.isLetter(c))
				if (Character.isUpperCase(c))
					sParen += " < " + c + " ";
			else 
			   sParen += " " + c + " > "; 
		} 
		return sParen;  
	}

}
