import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	void solve() throws IOException {
		int x = ni(), k = ni();
		boolean[] used = new boolean[x];
		
		used[x - 1] = true;
		for (int i = 0; i < k; i++) {
			int type = ni();
			used[ni() - 1] = true;
			if (type == 1) {
				used[ni() - 1] = true;
			}			
		}
		
		int min = 0, max = 0;
		for (int right = 0; right < x; right++) {
			int left = right;
			while (right < x && !used[right]) right++;
			int diff = right - left;
			if (diff > 0) {
				max += diff;
				min += (int) Math.ceil(diff * 1.0 / 2.0);
				//if (left != right) right--;
			}
		}
		out.println(min + " " + max);
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
