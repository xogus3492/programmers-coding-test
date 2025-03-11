import java.util.*;

class Solution {
    LinkedList<String> blocks[];
    int moveN[] = {1, 0, 1};
    int moveM[] = {0, 1, 1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        blocks = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = new LinkedList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                blocks[i].addFirst(String.valueOf(board[j].charAt(i)));
            }
        }
        
        int prevAns = -1;
        while (answer > prevAns) {
            prevAns = answer;
            answer += search(n, m);
        }
        
        return answer;
    }
    
    public int search(int n, int m) {
        boolean removalCandidate[][] = new boolean[n][m];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < blocks[i].size() - 1; j++) {
                String block = blocks[i].get(j);
                if (block != null && check(i, j, block)) {
                    markRemoval(removalCandidate, i, j);
                }
            }
        }
        
        int count = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (removalCandidate[j][i]) {
                    blocks[j].remove(i);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public boolean check(int n, int m, String block) {
        for (int a = 0; a < 3; a++) {
            int nextN = n + moveN[a];
            int nextM = m + moveM[a];
            
            if (nextM >= blocks[nextN].size()) return false;
            
            String nextBlock = blocks[nextN].get(nextM);
            
            if (nextBlock == null || !block.equals(nextBlock)) return false;
        }
        return true;
    }
    
    public void markRemoval(boolean[][] removalCandidate, int n, int m) {
        removalCandidate[n][m] = true;
        for (int a = 0; a < 3; a++) {
            int nextN = n + moveN[a];
            int nextM = m + moveM[a];
            removalCandidate[nextN][nextM] = true;
        }
    }
    
}
