CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    /* Write your PL/SQL query statement below */
    SELECT sum(salary) into result FROM (
    SELECT salary, rownum rn FROM (
        SELECT DISTINCT salary FROM employee ORDER BY salary desc
        )
    )
    WHERE rn = N;
    RETURN result;
END;