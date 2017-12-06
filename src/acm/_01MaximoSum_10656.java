package acm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01MaximoSum_10656 {
	public static void main(String[] args) throws IOException {
		//leo de consola gracias a BuffereadReader (memoria en vez del disco) del InputStreamReader(System.in)
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		//Leo la primera linea
		String st = buffer.readLine();
		//Pregunto si es cero
		while (!st.equals("0")) {
			double inicio=System.currentTimeMillis();
			//en caso de no ser cero capturo el primer n�mero
			int n = Integer.parseInt(st);
			//creo un arreglo de ese tama�o
			int[] arr = new int[n];
			//paso los valores al arreglo con la cantidad del arreglo
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(buffer.readLine());
			}
			//creo variables sum y ans, ini. fin, init
			int sum = 0, ans = 0;
			int ini = 0, fin = 10001, init = 0;
			for (int j = 0; j < n; j++) {
				//calculo la suma total
				sum += arr[j];
				//pregunto si ans (suma acumulativa auxiliar) es menor que la suma 
				//o el auxiliar es igual y j-init menor fin-ini
				if (ans < sum || (ans == sum && j - init < fin - ini)) {
					//para tener un nuevo inicio
					ans = sum;
					fin = j;
					ini = init;
				}
				//verifico si la suma es negativa para volver a empezar
				if (sum <= 0) {
					sum = 0;
					init = j + 1;
				}
			}
			for (int i = ini; i < fin; i++) {
				if (arr[i] != 0) {
					//System.out.print(arr[i] + " ");
				}
			}
			//System.out.println(arr[fin]);
			
			
			double fini=System.currentTimeMillis();
			System.out.print((fini-inicio)/1000+" ");
			//imprimir(arr);
			System.out.println();
			st = buffer.readLine();

		}
	}
}

