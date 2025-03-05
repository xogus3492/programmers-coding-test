SELECT MAX(A.SCORE) OVER(PARTITION BY A.EMP_NO) AS SCORE, 
        B.EMP_NO, B.EMP_NAME, B.POSITION, B.EMAIL
FROM (SELECT EMP_NO, 
        SUM(SCORE) AS SCORE
     FROM HR_GRADE
     GROUP BY EMP_NO) A
INNER JOIN HR_EMPLOYEES B USING(EMP_NO)
ORDER BY SCORE DESC
LIMIT 1;

-- 1140 error : SUM, COUNT, AVG, MIN, MAX 등의 함수와 일반 컬럼을 동시에 사용하기위해서는 GROUP BY 절이 필요합니다.
