package acm3;
import java.util.Random;

//Lab ADA: CARLOS ATENCIO TORRES
//Teoria: CRISTIAN
/**
 * Carlos Atencio Torres
 * catencio@episunsa.edu.pe
 * Reglas:
 * -Cuenta GIT
 * -Cualquier lenguaje de programación
 * -Cualquier trabajo es individual a no ser
 * que se diga lo contrario.
 * Forma de trabajo
 * -Traducir algoritmos vistos en clase.
 * -Ejercicios ACM
 * Hoy:
 * -Implementar un generador de arreglos
 * -Implementar insertsort, mergesort y user quicksort
 * -Creciente		A
 * -Decreciente		B
 * -Desordenada		C
 * -GENERADOR 		A 10
 * InserSort
 * Coleccion.sort---QuickSort
 */
public class Generador_02 {
	public static void main(String[] args) {
		String opcion=args[0];
		int cantidad=Integer.parseInt(args[1]);
		int ind=0;
		if("A".equals(opcion)){
			//orden creciente
			for(int f=0;f<cantidad;f++){
				for(int c=0;c<=ind;c++){
					System.out.print(c+" ");
				}
				ind++;
				System.out.println();
			}
			
		}
		else if("B".equals(opcion)){
			//orden decreciente
			ind=0;
			int num=cantidad;
			for(int f=0;f<cantidad;f++){
				for(int c=0;c<=ind;c++){
					System.out.print(num+" ");
					num--;
				}
				num=cantidad;
				ind++;
				
				System.out.println();
			}
		}	
		else if("C".equals(opcion)){
			//orden random
			ind=0;
			System.out.println(cantidad);
			Random rd=new Random();
			for(int i=1;i<=cantidad;i++){
				
				for(int j=0;j<i;j++){
					int random = rd.nextInt(100);
					System.out.println(random);
				}
			}
			System.out.print(0);
			
		}
	}
		/*
			ind=cantidad-1;
			for(int f=0;f<cantidad;f++){
				for(int c=ind;c>=0;c--){
					System.out.print(c+" ");
				}
				ind--;
				System.out.println();
			}
		*/



	
	/*
	public static void creciente(int cantidad){
		for(int i=0;i<cantidad;i++)
			System.out.println(i);
	}
	public static void decreciente(int cantidad){
		for(int i=cantidad;i>0;i--)
			System.out.println(i);
	}
	public static void desordenado(int cantidad){
		Random rd=new Random();
		for(int i=0;i<cantidad;i++){
			int random = rd.nextInt();
			System.out.print(random);
		}
	}
	*/
	
}
/*javac generador.java
 * java generador A 1000 > A1000.txt
 * javac InserSort.java
 * time java InsertSort < A1000.txt
 * 
 */
/**
 * system.out.print === (>) A1000.txt /// volcar datos
 * en el caso del menor (<) es como el scanner
 * en windows se usan clock una variable y otra al final se resta y calcular el tiempo.
 * Se usa el string primero para usar equals y no bota bound exception
**/

/**
 * Random rd=new Random();
 * rd=new Random(System.currentMilisecs())
 * rd.nextInt();
 */


/**
 * bash
 * #!/bin/sh
 * java generador A 10> A10.txt
 * java generador A 100
 * java generador A 200
 * time java insersirt < A10.txt
 * 1>resultado.txt
 * time java insersort < A100.txt
 * 1>>resultado.txt (ajunta resultados para graficar)
 * 
 * linux.sh
 * windows.bat
 * 
 * automatizar proyectos
 */

/**
 * Pueden usar gnuplot
 * QuickSort:
 * int[]a
 * Collection.Sort(mew ArrayList(Array.asList(a)) - volatil para volcarlo a new para instanciarlo
 * el new es importante para pasar de primtivios a objetos
 * 
 */
