public class EllysSubstringSorter {

    public String getMin(String S, int L) {
        
        String res = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
        int N = S.length();
        for (int i = 0; i <= N - L; i++) {
           	char[] T = S.toCharArray();
            while (true) {
                boolean update = false;
                for (int j = 0; j < L - 1; j++) {
                    int p = i + j;
                    if (T[p + 1] < T[p]) {
                        char t = T[p];
                        T[p] = T[p + 1];
                        T[p + 1] = t;
                        update = true;
                    }
                }
                if (!update) break;
            }
            String sorted = new String(T);
            if (sorted.compareTo(res) < 0) res = sorted;    
        }
        
        return res;
    }
}
