```sql
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, "%Y-%m-%d") AS "날짜"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

=> DATE_FORMAT() -> 날짜 형식 변경
	TIMEDIFF() -> 날짜 차이 계산
```
