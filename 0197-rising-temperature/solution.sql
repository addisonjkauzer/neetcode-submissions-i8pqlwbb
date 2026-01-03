# Write your MySQL query statement below
SELECT day2.id FROM Weather AS day2 JOIN Weather as day1 ON day1.recordDate = day2.recordDate - INTERVAL 1 DAY WHERE day2.temperature > day1.temperature