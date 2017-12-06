package acm2;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class _02BusDriver_11389 {
	public static int NumberOfBusDrivers, Distance, Over;
	public static int[] Morning;
	public static int[] Evening;

	public static void main(String args[]) throws NumberFormatException, IOException{
		Scanner Input = new Scanner(System.in);
		//capturo valores para el bucle
		while(true){
			NumberOfBusDrivers = Input.nextInt();
			Distance		   = Input.nextInt();
			Over			   = Input.nextInt();
			//si son los tres cero se acaba el bucle
			if(NumberOfBusDrivers == 0 && Distance == 0 && Over == 0)	break;
			
			//se crea dos arreglos para ma�ana y tarde
			Morning = new int[NumberOfBusDrivers];
			Evening = new int[NumberOfBusDrivers];
			//se captura los valores de ma�ana y los de tarde
			for(int i = 0; i < NumberOfBusDrivers; i++)		Morning[i] = Input.nextInt();
			for(int i = 0; i < NumberOfBusDrivers; i++)		Evening[i] = Input.nextInt();
			//los ordeno
			//Arrays.sort(Morning);	Arrays.sort(Evening);
			//recorro y al resltado le sumo lo de ma�ana y tarde
			//si el resultado es mayor que la distancia el valor incrementa el (resultado - distancia)*over
			int Value = 0;
			for(int i = 0; i < NumberOfBusDrivers; i++){
				int Result = Morning[i] + (Evening[i]);
				if(Result > Distance)
					Value += (Result - Distance) * Over;
			}
			System.out.println(Value);
		}
	}
}

