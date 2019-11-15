/* Write your PL/SQL query statement below */
select a.id "Id" from weather a, weather b where a.recordDate = b.recordDate + 1 and a.temperature > b.temperature;