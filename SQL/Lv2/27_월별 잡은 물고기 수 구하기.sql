SELECT COUNT(FISH_TYPE) FISH_COUNT, MONTH(TIME) MONTH
FROM FISH_INFO
GROUP BY MONTH
HAVING FISH_COUNT > 0
ORDER BY MONTH

-- SELECT 절에서 설정한 별칭(alias)을 GROUP BY, HAVING에서 사용 가능
