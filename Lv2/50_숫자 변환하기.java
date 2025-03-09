import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    public int bfs(int x, int y, int n) {
        int ans = -1;
        Queue<I> q = new LinkedList<>();
        boolean[] visited = new boolean[y+1];
        q.offer(new I(x, 0));
        visited[x] = true;
        
        while (!q.isEmpty()) {
            I i = q.poll();
            if (i.x == y) {
                ans = i.cnt;
                break;
            }
            
            int[] nextXValues = {i.x+n, i.x*2, i.x*3};
            int idx = 0;
            while (idx < nextXValues.length) {
                int nextXVal = nextXValues[idx++];
                if (nextXVal <= y && !visited[nextXVal]) {
                    q.offer(new I(nextXVal, i.cnt+1));
                    visited[nextXVal] = true;
                }
            }
        }
        
        return ans;
    }
    
    class I {
        int x;
        int cnt;
        
        I(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
    
}
