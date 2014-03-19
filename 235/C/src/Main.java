import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	void solve() throws IOException {
		int n = ni(), m = ni();
		int[] a = new int[n * 2 + m * 2 + 1];
		
		if (n == m && n == 1) {
			out.println("10");
			return;
		}
		
		if ((n > m && n - m == 1) || n == m) {
			for (int i = 0; i < n; i++) {
				out.print(0);
				if (i < n - 1) {
					out.print(1);
				}
			}
			if (n == m) {
				out.print(1);
			}
			return;
		}
		

		
		int mcnt = 0;
		for (int i = 0; i < n * 2; i++) {
			if (i % 2 == 1) {
				a[i] = 0;
			} else {
				if (mcnt == m) {
					out.println("-1");
					return;
				}
				a[i] = 1;
				mcnt++;
			}
		}
		
		for (int i = 0; i < n * 2; i++) {
			if (i % 2 == 0) {
				a[i]++;
				mcnt++;
			}
			
			if (mcnt == m) {
				break;
			}
		}
		
		if (mcnt + 2 < m) {
			out.println("-1");
			return;
		}
		
		for (int i = 0; i < n * 2; i++) {
			if (a[i] == 0) {
				out.print(0);
			} else {
				for (int j = 0; j < a[i]; j++) {
					out.print(1);
				}
			}
		}
		
		if (mcnt + 1 == m) {
			out.print("1");
		}
		if (mcnt + 2 == m) {
			out.print("11");
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
