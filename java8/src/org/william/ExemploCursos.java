package org.william;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(new Curso("Java", 110), new Curso("Python", 37), new Curso("Rede", 43),
				new Curso("Sistemas Operacionais", 66));
		cursos.sort(Comparator.comparingInt(Curso::getTotalAlunos));
		cursos.stream().filter(a -> a.getTotalAlunos() > 50).forEach(System.out::println);
		cursos.stream().map(Curso::getNome).forEach(System.out::println);
	}
}
