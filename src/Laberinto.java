import java.util.ArrayList;

public class Laberinto{
    
    public char[][] laberinto={ 
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
	    {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
	    {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
	    {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'},
	    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#'},
	    {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'},
	    {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
	    {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
	    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
	    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };
    
    public static ArrayList<Laberinto> soluciones = new ArrayList<Laberinto>();
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
	public static void main(String[] args) {
		Laberinto m = new Laberinto(); 												// construimos un objeto de la clase Laberinto por defecto
		m.laberinto[1][1] = 'X'; 													// introducimos en este caso, la salida (X) en las coordenadas (1,1)
		m.resuelve(8, 1, m); 															// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
		//System.out.println(m.imprimirLaberinto());// imprimimos el laberinto ya resuelto (si tiene soluci�n)
	}

    
    
    
    /* ----------------- IMPLEMENTACI�N DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y, Laberinto m){ 				// permite introducir unas coordenadas (x, y) 
        if (paso(x, y, m)) { 								// intentar� resolver el laberinto en estas coordenadas
            laberinto[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
	    }
	    
    }
    
    private boolean paso(int x, int y, Laberinto m) 
    {

    	 if (laberinto[x][y]=='X'){ // si hemos llegado a X quiere decir que hemos encontrado soluci�n
    		 System.out.println(m.imprimirLaberinto());
    		 return false; // luego, el algoritmo termina
    	 }
    	 
    	 
    	 if (laberinto[x][y]=='#'||laberinto[x][y]=='*' || laberinto[x][y]=='f') { // si llegamos a una pared o al mismo punto,
    		 return false; // entonces el laberinto no puede resolverse y termina.
    	 }
    	 
    	 // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
    	 // caso intermedio, por lo tanto, que empezamos a recorrer o todav�a no hemos llegado a nada
    	 laberinto[x][y]='*'; // marcamos la posici�n como visitada (si es la primera, en las coordenadas x e y 
    	 
    	 boolean result; // se coloca S de START)
    	 
    	 result=paso(x, y+1, m); // intentamos ir hacia la DERECHA. Primera llamada recursiva
    	 if (result)return true; // si el resultado es el final, entonces el algoritmo termina

    	 result=paso(x-1, y, m); // intentamos ir hacia ARRIBA. Segunda llamada recursiva
    	 if (result) return true; // si el resultado es el final, entonces el algoritmo termina

    	 result=paso(x, y-1, m); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva
    	 if (result) return true; // si el resultado es el final, entonces el algoritmo termina

    	 result=paso(x+1, y, m); // intentamos ir hacia ABAJO. Cuarta llamada recursiva
    	 if (result) return true; // si el resultado es el final, entonces el algoritmo termina
    	 
    	 // si no hemos encontrado la soluci�n en estos cuatros movimientos, volvemos atr�s, aunque hay que
    	 // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
    	 // se ha conseguido el �xito, entonces el algoritmo termina y devuelve false.
    	 
    	 // -------------el trucosky---------------------
    	 
    	 laberinto[x][y]=' '; // OJO !! Lo pongo en vacio de nuevo para que borre ese camino
    	 					  // que luego en otra iteracion puede resultar en otra solucion
    	 
    	 
    	 // -------------el trucosky---------------------
    	 
    	 return false; // vuelta atr�s si la soluci�n no se encuentra aqu�

       
    }
	
    private String imprimirLaberinto() { // imprimiremos nuestra soluci�n. Debido a que la clase Arrays no tiene implementado
        String salida = "";    // un m�todo toString para arrays bidimensionales, lo programamos a mano
        for (int x=0; x<laberinto.length; x++) { // recorremos filas
            for (int y=0; y<laberinto[x].length; y++) { // recorremos columnas
                salida += laberinto[x][y] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de l�nea
        }
        return salida;
    }
	
    
}