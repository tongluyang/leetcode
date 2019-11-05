/* Write your PL/SQL query statement below */
select a.score, rn rank from scores a, (select score, rownum rn from (select distinct score from scores order by score desc)) b where a.score = b.score;