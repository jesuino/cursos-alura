package org.william;

import java.util.ArrayList;
import static java.util.Comparator.comparing;
import java.util.List;

public class ReferenciaMetodo {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		palavras.sort(comparing(String::length));
		// palavras.sort(comparing(s -> s.charAt(2)));

		palavras.forEach(System.out::println);
		
	}
}
