package org.william;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CursosStream {
	public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(new Curso("Java", 110), new Curso("Python", 40), new Curso("Rede", 50),
				new Curso("Sistemas Operacionais", 40));
		
		cursos.stream().filter(c -> c.getTotalAlunos() > 50).findFirst().ifPresent(System.out::println);;
		
		cursos.stream().mapToInt(Curso::getTotalAlunos).average().ifPresent(System.out::println);
		
		cursos.stream()
		.filter(c -> c.getTotalAlunos() > 50)
		.collect(Collectors.toList());
	}
}
