package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio2 {

	public static List<Integer> ejercicio2RecursivoNoFinal(Integer a, Integer b) {
		List<Integer> ls = new ArrayList<>();
		return ejercicio2RecursivoNoFinalAux(a, b, ls);
	}

	public static List<Integer> ejercicio2RecursivoNoFinalAux(Integer a, Integer b, List<Integer> ls) {
		ls = new ArrayList<>();

		if (a < 2 || b < 2) {
			ls.add(a * b);
		} else if (a > b) {
			ls = ejercicio2RecursivoNoFinalAux(a % b, b - 1, ls);
			ls.add(a);
		} else {
			ls = ejercicio2RecursivoNoFinalAux(a - 2, b / 2, ls);
			ls.add(b);
		}
		return ls;
	}

	public static List<Integer> ejercicio2RecursivoFinal(Integer a, Integer b) {
		List<Integer> ls = new ArrayList<>();
		return ejercicio2RecursivoFinalAux(a, b, ls);
	}

	public static List<Integer> ejercicio2RecursivoFinalAux(Integer a, Integer b, List<Integer> ls) {

		if (a < 2 || b < 2) {
			ls.add(0, a * b);
		} else if (a > b) {
			ls.add(0, a);
			ls = ejercicio2RecursivoFinalAux(a % b, b - 1, ls);
		} else {
			ls.add(0, b);
			ls = ejercicio2RecursivoFinalAux(a - 2, b / 2, ls);

		}

		return ls;
	}

	public static List<Integer> ejercicio2Iterativo(Integer a, Integer b) {
		List<Integer> ls = new ArrayList<>();
		while (!(a < 2 || b < 2)) {
			if (a > b) {
				ls.add(0, a);
				a = a % b;
				b = b - 1;
			} else {
				ls.add(0, b);
				a = a - 2;
				b = b / 2;
			}
		}
		ls.add(0, a * b);
		return ls;
	}
	
	public static List<Integer> ejercicio2Funcional(Integer a, Integer b){
		List<Integer> ls= new ArrayList<>();
		return ls;
				
	}

}
