import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	void solve() throws IOException {
		int n = ni(), m = ni();
		
		Set<Integer> ans = new HashSet<Integer>();
		for (int i = 0, jg = 0, js = 0; i < n; i++) {
			char[] c = in.readLine().toCharArray();
			
			for (int j = 0; j < m; j++) {
				if (c[j] == 'G') jg = j;
				else if (c[j] == 'S') js = j;
			}
			
			if (jg > js) {
				out.println("-1");
				return;
			}
			ans.add(jg - js);
		}
		out.println(ans.size());
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