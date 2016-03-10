package org.william;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class NovaAPIData {
	
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalDate futuro = LocalDate.of(2099, Month.JANUARY, 25);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Period hojeAteOFuturo = Period.between(now, futuro);
		
		System.out.println(now.format(formatador));
	}

}
