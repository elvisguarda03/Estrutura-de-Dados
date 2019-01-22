package br.com.alura.estrutura.dados.labs;

public class Potencia {
	public static void main(String[] args) {
		int valor = 8;
		int potencia = 3;

		if (valor == 2) {
			for (int i = 0; i < potencia - 1; i++) {
				valor += valor;
			}
		} else {
			int limitador = verifyAndSum(potencia, valor);
			int value = valor;

			for (int i = 0; i < limitador; i++) {
				valor += value;
			}
		}
		System.out.println(valor);
	}

	public static int verifyAndSum(int potencia, int valor) {
		if (potencia == 2)
			return valor;
//		int value = valor;
//		for (int i = 0; i < ; i++) {
//			valor += value;
//		}
		return 8 * potencia;
	}
}
