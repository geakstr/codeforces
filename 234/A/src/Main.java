import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	class Segment implements Comparable<Segment> {
		int a, b;

		Segment(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Segment o) {
			return a - o.a;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + a;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Segment other = (Segment) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (a != other.a)
				return false;
			return true;
		}

		private Main getOuterType() {
			return Main.this;
		}
	}
/*
1
X0X0X0X0X0X0

xoooxoo


OOOO
OXOO
OXOO

OOOOOXOOOXOO
 */
	void solve() throws IOException {
		int n = ni();

		for (int i = 0; i < n; i++) {
			char[] s = in.readLine().toCharArray();
			TreeSet<Segment> t = new TreeSet<Segment>();

			int xCnt = 0;
			for (int j = 0; j < 12; j++) {
				if (s[j] == 'X')
					xCnt++;
			}
			if (xCnt > 0) {
				t.add(new Segment(1, 12));
			}
			
			for (int j = 0; j < 6; j++) {
				if (s[j] != 'X') {
					continue;
				}
				
				for (int p = 1; p <= 12; p++) {
					if (12 % p == 0) {
						boolean ans = true;
						for (int k = j; k < 12; k += p) {
							if (k != j && s[k] != 'X') {
								ans = false;
								break;
							}
						}
						if (ans) {
							t.add(new Segment(12 / p, p));
						}
					}
				}
			}		
			out.print(t.size() + " ");
			for (Segment seg : t) {
				out.print(seg.a + "x" + seg.b + " ");
			}
			out.println();
		}
	}

	Main() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		in.close();
		out.close();
	}

	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.valueOf(ns());
	}

	double nd() throws IOException {
		return Double.valueOf(ns());
	}

	long nl() throws IOException {
		return Long.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

}