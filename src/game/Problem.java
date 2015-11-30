package game;

import java.util.LinkedList;

public class Problem {
	LinkedList<Fraction> problem;
	ProblemType type;
	
	public Problem(ProblemType type){
		this.type = type;
	}
	
	public ProblemType getType(){
		return type;
	}
}
