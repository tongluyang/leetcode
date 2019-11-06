/* Write your PL/SQL query statement below */
select name "Customers" from customers a where not exists (select 1 from orders b where customerid = a.id);
