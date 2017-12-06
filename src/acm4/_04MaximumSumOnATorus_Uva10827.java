package acm4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _04MaximumSumOnATorus_Uva10827 {
	
	public static int maximumSubmatrixSum(int [][] matrix) {
		for (int i=0;i<matrix.length;i++) {
			for (int i2=0;i2<matrix[i].length;i2++) {
				if (i>0) {
					matrix[i][i2]+=matrix[i-1][i2];
				}
				if (i2>0) {
					matrix[i][i2]+=matrix[i][i2-1];
				}
				if (i>0 && i2>0) {
					matrix[i][i2]-=matrix[i-1][i2-1];
				}
			}
		}
		
		int max=Integer.MIN_VALUE; 
		for (int xStart=0;xStart<matrix.length/2;xStart++) {
			for (int yStart=0;yStart<matrix.length/2;yStart++) {
				for (int xEnd=xStart;xEnd<matrix.length/2+xStart;xEnd++) {
					for (int yEnd=yStart;yEnd<matrix[xEnd].length/2+yStart;yEnd++) {
						int value=matrix[xEnd][yEnd];
						if (xStart>0) {
							value-=matrix[xStart-1][yEnd];
						}
						if (yStart>0) {
							value-=matrix[xEnd][yStart-1];
						}
						if (xStart>0 && yStart>0) {
							value+=matrix[xStart-1][yStart-1];
						}
						max=Math.max(value, max);
					}
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int N=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			int [][] matrix=new int [2*N][2*N];
			for (int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for (int i2=0;i2<N;i2++) {
					matrix[i][i2]=Integer.parseInt(st.nextToken());
					matrix[i][i2+N]=matrix[i][i2];
					matrix[i+N][i2]=matrix[i][i2];
					matrix[i+N][i2+N]=matrix[i][i2];
				}
			}
			System.out.println(maximumSubmatrixSum(matrix));
			
			
		}
	}
}


