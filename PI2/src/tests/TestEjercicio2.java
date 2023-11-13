package tests;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import us.lsi.common.Pair;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;
import us.lsi.streams.Collectors2;


public class TestEjercicio2 {
	
	private static Integer nMin = 100; // n mínimo para el cálculo 
	private static Integer nMax = 10000; // n máximo para el cálculo 
	private static Integer nIncr = 100; // incremento en los valores de n del cálculo 
	private static Integer nIter = 50; // número de iteraciones para cada medición de tiempo
	private static Integer nIterWarmup = 1000; // número de iteraciones para warmup
	

	public static void genDataE2() {
		String file = "ficheros_generados/E2.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Collectors2.mergeSort(new ArrayList<Integer>(),Comparator.naturalOrder(),t));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
	}
	public static void showE2() {
		String file = "ficheros_generados/E2.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of(List.of(Pair.of(2, 0.),Pair.of(3, 0.)));
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	 private static List<Integer> generarListaAleatoria(int tamano) {
	        return new Random().ints(tamano).boxed().collect(Collectors.toList());
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		genDataE2();
		showE2();

}
	}
