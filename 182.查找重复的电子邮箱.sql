/* Write your PL/SQL query statement below */
select email "Email" from person group by email having count(1) > 1;