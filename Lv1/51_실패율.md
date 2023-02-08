### [나의 답]

```java
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		double arr[][] = new double[N][2];

		// arr에 각 스테이지 번호와 실패율 초기화
		for (int i = 1; i < N + 1; i++) {
			double reach = 0;
			double present = 0;

			for (int j = 0; j < stages.length; j++) {
				if (stages[j] >= i) reach++;
				if (stages[j] == i) present++;
			}

			arr[i - 1][0] = i;
			arr[i - 1][1] = present / reach;
		}

		// 선택 정렬방식으로 내림차순 정렬
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i][1] < arr[j][1]) {
					double temp0 = arr[i][0];
					arr[i][0] = arr[j][0];
					arr[j][0] = temp0;

					double temp1 = arr[i][1];
					arr[i][1] = arr[j][1];
					arr[j][1] = temp1;
				}
				
				// 실패율이 같을 때 스테이지 번호 오름차순
				if (arr[i][1] == arr[j][1] && arr[i][0] > arr[j][0]) {
					double temp0 = arr[i][0];
					arr[i][0] = arr[j][0];
					arr[j][0] = temp0;

					double temp1 = arr[i][1];
					arr[i][1] = arr[j][1];
					arr[j][1] = temp1;
				}
			}
		}
        
    for (int i = 0; i < N; i++) {
			answer[i] = (int) arr[i][0];
		}

		return answer;
	}
}

=> 2차원 배열 사용. 선택정렬을 사용하여 성능이 좋지 않음.
```

### [다른 답]

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] lastStages) {
        int nPlayers = lastStages.length;
        int[] nStagePlayers = new int[N + 2];
        for (int stage : lastStages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<>();
        for (int id = 1 ; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        Collections.sort(stages, Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }

    class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id_, double failure_) {
            id = id_;
            failure = failure_;
        }

        @Override
        public int compareTo(Stage o) {
            if (failure < o.failure ) {
                return -1;
            }
            if (failure > o.failure ) {
                return 1;
            }
            return 0;
        }
    }
}

=> Comparable 클래스를 직접 커스텀하여 구현함.
```
