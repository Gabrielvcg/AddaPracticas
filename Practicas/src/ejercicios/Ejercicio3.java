package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {

	public static List<String> ejercicio3Iterativo(List<String> a,List<String> b) {
		List<String> ac= new ArrayList<>();
		Integer i=0;
		Integer j=0;
		while(i<a.size() -1 || j<b.size()-1) {
		    if (i <= a.size()-2 && j <= b.size() -2 ) {
		    	
		        ac.add(a.get(i));
		        ac.add(a.get(i + 1));
		        ac.add(b.get(j));
		        ac.add(b.get(j + 1));
		        i += 2;
		        j += 2;
		    }else if (i > a.size()-1) {
		    
		    	ac.addAll(b.subList(j, b.size()));
		    	j+=b.size()-j;
		    }else if (j> b.size()-1){
		    	ac.addAll(a.subList(i, a.size()));
		    	i+=a.size()-i;
		    	
		    }else if(i == a.size()-1){
		    	ac.add(a.get(i));
		    	ac.addAll(b.subList(j, b.size()));

		    }else if(j == b.size()-1){
		    	ac.add(b.get(j));
		    	ac.addAll(a.subList(j, a.size()));

		    }
			
	}
		return ac;
	
}
	//otra opcion que parece menos engorrosa, pero para el recursivo no se pasa directamente
	/*
	public static List<String> ejercicio3Iterativo2(List<String> a, List<String> b) {
	    List<String> ac = new ArrayList<>();
	    int i = 0;
	    int j = 0;

	    while (i < a.size() && j < b.size()) {
	    	ac.add(a.get(i));
	        ac.add(a.get(i + 1));
	        ac.add(b.get(j));
	        ac.add(b.get(j + 1));
	        i += 2;
	        j += 2;
	    }

	    while (i < a.size()) {
	        ac.add(a.get(i));
	        i++;
	    }

	    while (j < b.size()) {
	        ac.add(b.get(j));
	        j++;
	    }

	    return ac;
	}
*/

}
