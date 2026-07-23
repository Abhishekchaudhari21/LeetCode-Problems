SELECT w1.id
FROM Weather w1
JOIN Weather w2
ON w2.recordDate = SUBDATE(w1.recordDate, 1)
AND w1.temperature > w2.temperature;