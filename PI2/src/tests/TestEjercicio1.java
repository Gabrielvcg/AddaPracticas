package tests;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import ejercicios.Ejercicio1;
import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class TestEjercicio1 {
	 
	private static Integer nMin = 1000; // n mínimo para el cálculo de potencia
	private static Integer nMax = 100000; // n máximo para el cálculo de potencia
//	private static Integer nIncr = 1000; // incremento en los valores de n del cálculo de potencia
	private static Integer nIncr = 3330; // incremento en los valores de n del cálculo de potencia
	private static Integer nIter = 50; // número de iteraciones para cada medición de tiempo
//	private static Integer nIterWarmup = 100; // número de iteraciones para warmup
	private static Integer nIterWarmup = 10000; // número de iteraciones para warmup
	

	private static Double RD = 1000.;
	private static BigInteger RBI = new BigInteger("1000");
	
	public static void genDataE1RD() {
		String file = "ficheros_generados/E1_RD.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Ejercicio1.ejercicio1RecursivoD(RD));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
	}
	public static void genDataE1RBI() {
		String file = "ficheros_generados/E1_RBI.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Ejercicio1.ejercicio1RecursivoBI(RBI));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
	}
	public static void genDataE1ITD() {
		String file = "ficheros_generados/E1_ITD.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Ejercicio1.ejercicio1IterativoD(RD));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
	}
	public static void genDataE1ITBI() {
		String file = "ficheros_generados/E1_ITBI.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Ejercicio1.ejercicio1IterativoBI(RBI));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
	}
	public static void showE1RD() {
		String file = "ficheros_generados/E1_RD.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void showE1RBI() {
		String file = "ficheros_generados/E1_RBI.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}

	public static void showE1ITD() {
		String file = "ficheros_generados/E1_ITD.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void showE1ITBI() {
		String file = "ficheros_generados/E1_ITBI.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}

	
	public static void showCombined() {
		MatPlotLib.showCombined("Tiempos",
				List.of("ficheros_generados/E1_RD.txt","ficheros_generados/E1_RBI.txt","ficheros_generados/E1_ITD.txt","ficheros_generados/E1_ITBI.txt"), 
				List.of("Recursiva Doble","Recursiva Big Integer","Iterativo Double","Iterativo Big Integer"));
//		List.of("ficheros_generados/pr.txt","ficheros_generados/lin.txt"), 
//		List.of("Recursiva","Iterativa"));
	}
	
	public static void main(String[] args) {
		genDataE1RD();
		genDataE1RBI();
		genDataE1ITD();
		genDataE1ITBI();
	
		showE1RD();
		showE1RBI();
		showE1ITD();
		showE1ITBI();
		
		showCombined();
		
	}

}


