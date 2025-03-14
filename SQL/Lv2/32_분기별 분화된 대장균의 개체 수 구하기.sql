SELECT CONCAT(A.Q, 'Q') AS QUARTER, COUNT(*) AS ECOLI_COUNT
FROM (SELECT (CAST(DATE_FORMAT(DIFFERENTIATION_DATE, '%m') AS UNSIGNED) + 2) DIV 3 AS Q
        FROM ECOLI_DATA) A
GROUP BY A.Q
ORDER BY A.Q

-- CAST(문자형 as UNSIGNED) : 문자형을 숫자형으로 반환
