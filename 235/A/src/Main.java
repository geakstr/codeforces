import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	void solve() throws IOException {
		int n = ni(), x = ni();
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += ni();
		}
		
		out.println((int) Math.ceil(Math.abs(sum * 1.0 / x * 1.0)));
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
