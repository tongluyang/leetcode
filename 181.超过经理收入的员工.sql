/* Write your PL/SQL query statement below */
select name "Employee" from employee a where managerid is not null and salary > (select salary from employee b where a.managerid = b.id);

/* Write your PL/SQL query statement below */
select a.name "Employee" from employee a, employee b where a.managerid is not null and a.managerid = b.id and a.salary > b.salary;
