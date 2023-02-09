### [나의 답]

```java
import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
		int answer = 0;

		int[] score = new int[3];
		int temp = 0;
		String num = "";
		for (int i = 0, n = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);

			if (c >= '0' && c <= '9') {
				num += String.valueOf(c);
			}
			else if (c == 'S' || c == 'D' || c == 'T') {
				temp = Integer.parseInt(num);
				if (c == 'S') score[n++] = (int) Math.pow(temp, 1);
				 else if (c == 'D') score[n++] = (int) Math.pow(temp, 2);
				 else score[n++] = (int) Math.pow(temp, 3);
                
                num = "";
			}
			else {
				if (c == '*') {
					score[n-1] *= 2;
					if (n-2 >= 0) score[n-2] *= 2;
				}
				else {
					score[n-1] *= -1;
				}
			}
		}

		System.out.println(Arrays.toString(score));

		answer = score[0] + score[1] + score[2];

		return answer;
	}
}

=> if (c == 'S') score[n++] = (int) Math.pow(temp, 1); 이부분에서,
	temp를 score[n]으로 바꾸면 ArrayIndexOutOfBoundsException이 뜸.
```
