/* Write your PL/SQL query statement below */
select d.name "Department", e.name "Employee", e.salary "Salary"
from employee e, (select departmentid, max(salary) salary from employee group by departmentid) m, department d
where e.departmentid = m.departmentid
and e.salary = m.salary
and e.departmentid = d.id