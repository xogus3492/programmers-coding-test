class Solution {
    long dp[];
    
    public long solution(int n) {
        dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        /*for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }*/
        
        return recurse(n);
    }
    
    public long recurse(int n) {
        if (n <= 0) {
            return 0;
        }
        
        if (dp[n] == 0) {
            dp[n] = (recurse(n-1) + recurse(n-2)) % 1000000007;
        }
        
        return dp[n];
    }
    
}

// Top-Down 방식에서 메모제이션 변수 객체를 Long 으로 생성하고
// dp[n]이 null인지 확인하는 방식으로 구현하면
// 효율성 테스트에서 시간 초과가 발생함
