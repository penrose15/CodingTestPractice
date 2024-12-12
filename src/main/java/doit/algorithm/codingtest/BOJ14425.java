package doit.algorithm.codingtest;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14425 {
    static int N;
    static int M;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        TNode root = new TNode();

        // insert word
        while(N > 0) {
            String word = br.readLine();
            TNode now = root;
            for(int i = 0; i< word.length(); i++) {
                char c = word.charAt(i);
                // 만약 해당 인덱스 존재 x, TNode 추가
                if(now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new TNode();
                }
                // 현재 인덱스로 이동
                now = now.next[c - 'a'];
                // 마지막 단어면 end = true
                if(i == word.length() - 1) {
                    now.setEnd(true);
                }
            }
            N--;
        }

        // word 검색
        while(M > 0) {
            String word = br.readLine();
            TNode now = root;
            for(int i = 0; i<word.length(); i++) {
                char c = word.charAt(i);
                // char 에 해당하는 인덱스 있는지 확인
                if(now.next[c - 'a'] == null) {
                    break;
                }
                // 있으면 해당 TNode로 이동
                now = now.next[c - 'a'];
                if(i == word.length() - 1 && now.isEnd()) {
                    cnt++;
                }
            }
            M--;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static class TNode {
        TNode[] next = new TNode[26];
        boolean isEnd;

        public TNode[] getNext() {
            return next;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}
