/* Write your PL/SQL query statement below */
select d.name "Department", e.name "Employee", e.salary "Salary"
from employee e, (select distinct departmentid, salary, dense_rank() over (partition by departmentid order by salary desc) rank from employee) t, department d
where e.departmentid = t.departmentid
and e.salary = t.salary
and t.rank <= 3
and e.departmentid = d.id