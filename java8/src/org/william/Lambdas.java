package org.william;

import java.util.ArrayList;
import java.util.List;

public class Lambdas {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		palavras.sort((String o1, String o2)  -> o1.length() - o2.length());

		palavras.forEach(t -> System.out.println(t));
		
		new Thread(() -> System.out.println("Hello lambda and thread")).start();

	}
}
