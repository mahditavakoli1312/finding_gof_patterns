package cz.cvut.fel.ass.parser;

import java.util.LinkedList;

import java.util.List;
import java.util.LinkedList;

// jen wrap pro list
// Zrušil jsem dědičnost listu, radši jsem to udělal jako složení
public final class Attributes {
	
	private List<String> list;
	
	public Attributes(){
		list = new LinkedList<String>(); // TODO: přidat DI
	}

	public void addAttribute(String attr) {
		list.add(attr);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = 0; i < list.size(); i++)
			sb.append(list.get(i) + ", ");
		if (list.size() > 1)
			sb.delete(sb.length() - 2, sb.length());
		sb.append(")");
		return sb.toString();
	}
	
	public int size(){
		return list.size();

	}
	
	public String get(int index){
		return list.get(index);
	}
}
