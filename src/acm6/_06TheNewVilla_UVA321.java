package acm6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _06TheNewVilla_UVA321 {
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int kase = 1;
		while (true) {
			if (kase > 1)
				b.readLine();

			String[] s = b.readLine().split(" ");
			int rooms = Integer.parseInt(s[0]);
			int connections = Integer.parseInt(s[1]);
			int switches = Integer.parseInt(s[2]);
			if (rooms == 0 && connections == 0 && switches == 0)
				break;
			boolean[][] visited = new boolean[rooms][1 << rooms];
			ArrayList<Integer>[] list = new ArrayList[rooms];
			ArrayList<Integer>[] swits = new ArrayList[rooms];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<Integer>();
				swits[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < connections; i++) {
				s = b.readLine().split(" ");
				int a = Integer.parseInt(s[0]) - 1;
				int c = Integer.parseInt(s[1]) - 1;
				list[a].add(c);
				list[c].add(a);
			}
			for (int i = 0; i < switches; i++) {
				s = b.readLine().split(" ");
				int a = Integer.parseInt(s[0]) - 1;
				int c = Integer.parseInt(s[1]) - 1;
				swits[a].add(c);
			}
			Queue<node> q = new LinkedList<node>();
			int temp = 0;
			node res = null;
			int count = 0;
			ArrayList<String> l1 = new ArrayList<String>();
			for (Integer x : swits[0]) {
				if (x != 0) {
					temp |= 1 << x;
					l1.add("- Switch on light in room " + (x + 1) + ".");
					count++;
				}
			}
			temp |= 1;
			q.add(new node(0, temp, 0, null, ""));
			while (!q.isEmpty()) {
				node tem = q.poll();
				if (visited[tem.i][tem.lighted])
					continue;
				visited[tem.i][tem.lighted] = true;
				if (tem.i == rooms - 1 && tem.lighted == (1 << (rooms - 1))) {
					res = tem;
					break;
				}
				for (Integer x : list[tem.i])
					if ((1 << x & tem.lighted) != 0 && !visited[x][tem.lighted])
						q.add(new node(x, tem.lighted, tem.cost + 1, tem,
								"- Move to room " + (x + 1) + "."));
				for (Integer x : swits[tem.i])
					if (x != tem.i && !visited[x][tem.lighted ^ 1 << x]) {
						String te = "- Switch on light in room " + (x + 1)
								+ ".";
						if ((tem.lighted & 1 << x) != 0)
							te = "- Switch off light in room " + (x + 1) + ".";
						q.add(new node(tem.i, tem.lighted ^ 1 << x,
								tem.cost + 1, tem, te));
					}
			}
			System.out.println("Villa #" + kase);
			if (res == null)
				System.out.println("The problem cannot be solved.");
			else {
				System.out.println("The problem can be solved in "
						+ (res.cost + count) + " steps:");
				node t = res;
				ArrayList<String> l = new ArrayList<String>();
				while (t.parent != null) {
					l.add(t.s);
					t = t.parent;
				}
				for (String x : l1)
					System.out.println(x);
				for (int i = l.size() - 1; i >= 0; i--)
					System.out.println(l.get(i));
			}
			System.out.println();
			kase++;
		}

	}

	static class node {
		int i, lighted, cost;
		String s;
		node parent;

		public node(int i, int lighted, int cost, node parent, String s) {
			this.i = i;
			this.lighted = lighted;
			this.cost = cost;
			this.parent = parent;
			this.s = s;
		}
	}
}
