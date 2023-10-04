package tests;

import java.util.List;

import ejercicios.Ejercicio2;
import us.lsi.common.Files2;

public class TestEjercicio2 {
	public static void main(String[] args) {
		
        // Ruta del archivo de entrada
        String archivoEntrada = "../Practicas/ficheros/PI1Ej2DatosEntrada.txt";

        List<String> lineas = Files2.linesFromFile(archivoEntrada);
		for (String linea: lineas) {
		String[] valores =linea.split(",");
		Integer a = Integer.parseInt(valores[0]);
		Integer b = Integer.parseInt(valores[1]);   
		
        System.out.println("Test con valores " + linea );
        
		// Llamar a tus métodos con los valores leídos
       // String resultadoFuncional = Ejercicio2.ejercicio1(varA, varB);
      //  String resultadoIterativo = Ejercicio2.ejercicio1Iterativo(varA, varB);
        List<Integer> resultadoRecursivoNoFinal = Ejercicio2.ejercicio2RecursivoNoFinal(a, b);
        List<Integer> resultadoRecursivoFinal = Ejercicio2.ejercicio2RecursivoFinal(a, b);
        List<Integer> resultadoIterativo = Ejercicio2.ejercicio2Iterativo(a, b);

        // Imprimir los resultados
       // System.out.println("Resultado Funcional: " + resultadoFuncional);
        //System.out.println("Resultado Iterativo: " + resultadoIterativo);
        System.out.println("Resultado Recursivo no final: " + resultadoRecursivoNoFinal);
        System.out.println("Resultado Recursivo final: " + resultadoRecursivoFinal);
        System.out.println("Resultado Iterativo: " + resultadoIterativo);
 
        System.out.println();
		}
       
   
}
}