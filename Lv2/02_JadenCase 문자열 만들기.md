### [나의 답]

```java
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String strings[] = s.split("");

        boolean isFirst = true;
        for (String str : strings) {
            if (str.equals(" ")) {
                answer.append(" ");
                isFirst = true;
            } else {
                if (isFirst) {
                    answer.append(str.toUpperCase());
                    isFirst = false;
                } else {
                    answer.append(str.toLowerCase());
                }
            }

        }

        return answer.toString();
    }
}
```
