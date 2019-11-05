/* Write your PL/SQL query statement below */
SELECT MAX(salary) "SecondHighestSalary" FROM employee 
WHERE salary < (SELECT MAX(salary) FROM employee);

/* Write your PL/SQL query statement below */
/* SELECT sum(salary) "SecondHighestSalary" FROM (
    SELECT salary, rownum rn FROM (
        SELECT DISTINCT salary FROM employee ORDER BY salary desc
    )
)
WHERE rn = 2; */
