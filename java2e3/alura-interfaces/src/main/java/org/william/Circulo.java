package org.william;

public class Circulo implements AreaCalculavel {

	private double raio;

	public Circulo(double raio) {
		this.raio = raio;
	}

	public double calculaArea() {
		return Math.pow(raio, 2) * Math.PI;
	}

}
