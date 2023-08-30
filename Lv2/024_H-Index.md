### [나의 답]

```java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int counting[] = new int[citations[citations.length-1] + 1];
        
        for (int i = 0; i < citations.length; i++) {
            int n = citations[i];
            
            for (int j = n; j >= 0; j--) {
                counting[j]++;
            }
        }
        
        for (int i = counting.length - 1; i >= 0; i--) {
            if (counting[i] >= i) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
```
