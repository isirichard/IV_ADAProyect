package acm7;

import java.util.Scanner;

class _07PageHopping_UVA822Beta {

	public static void main(String[] args) {
		final int NoPath = 65000, limit=101;
		int node1, node2, testCase=0;
		int length[][];

		Scanner sc = new Scanner(System.in);

		while(true)
		{
			//if last test case exit
			node1 = sc.nextInt();
			node2 = sc.nextInt();

			if(node1==0 && node2 ==0)   break;

			//init variables
			testCase++;
			length= new int[limit][limit];

			for(int i=0;i<limit;i++)
					for(int j=0;j<limit;j++)
						length[i][j] = NoPath;

			//read inputs
			do
			{
				length[node1][node2] = 1;
				length[node1][node1] = length[node2][node2] = 0;

				node1 = sc.nextInt();
				node2 = sc.nextInt();

			}while(node1>0 && node2>0);

			//Floyd Warshall algorithm

			for(int k=1; k<limit; k++)
				for(int i=1; i < limit; i++)
					for(int j=1; j<limit; j++)
					{
						if(j==i) continue;

						if(length[i][j] > length[i][k] + length[k][j])
						{
							length[i][j] = length[i][k] + length[k][j];
						}
					}

			int nodes=0;
			float sum=0;

			for(int i=1; i < limit; i++)
			{
				for(int j=1;j<limit;j++)
				{
					if( i==j && length[i][i] == 0) nodes++;
					else if(i!=j && length[i][j] != NoPath)
					{
						sum+=length[i][j];
					}
					//System.out.print(length[i][j]+"  ");
				}
				//System.out.println("\n");
			}

			float pairs = nodes * (nodes - 1);
			//System.out.println(sum + "/" + pairs);
			System.out.format("Case %d: average length between pages = %.3f clicks%n",testCase, (float)(sum/pairs));
		}
	}
}

