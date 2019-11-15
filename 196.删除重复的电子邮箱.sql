# Write your MySQL query statement below
delete from Person where Id not in (select id from (select min(Id) id from Person group by Email) t);