package br.com.alura.estrutura.dados.labs;

import br.com.alura.estrutura.dados.stack.Stack;

public class calcBinaria {
	public static void main(String[] args) {
		String value = "25";
		String result = exchangeBinary(value);
		System.out.println("--------------Conversão de decimal para binário----------------");
		System.out.print("Decimal - " + value + " Binário - ");
		System.out.println(result);
//		int result = exchangeDecimal(value);
//		System.out.println(result);
	}
	
	
	public static String exchangeBinary(String value) {
		Stack<Integer> stack = new Stack<>();
		int decimal = Integer.parseInt(value);
		while(decimal > 0) {
			stack.push(decimal % 2);
			decimal /= 2;
		}
		StringBuilder builder = new StringBuilder(""); 
		while(!stack.isEmpty())
			builder.append(stack.pop());
		return builder.toString();
	}
	
	public static int exchangeDecimal(String binary) {
		Stack<Integer> stack = new Stack<>();
		for(int i = binary.length() - 1; i >= 0; i--) {
			stack.push(Integer.valueOf(String.valueOf(binary.charAt(i))));
		}
		int result = 0;
		int multiplicador = stack.size() - 1;
		int multiplicando = 2;
		
		while(!stack.isEmpty()) {
			result += ((Math.pow(multiplicando, multiplicador)) * stack.pop().intValue());
			multiplicador--;
		}
		return result;
	}
}
