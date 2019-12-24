/* Write your PL/SQL query statement below */
select t.request_at "Day", round(sum(decode(t.status, 'completed', 0, 1)) / count(1), 2) "Cancellation Rate" from trips t, users c, users d
where t.client_id = c.users_id and t.driver_id = d.users_id
and c.banned = 'No' and d.banned = 'No'
and t.request_at >= '2013-10-01' and t.request_at <= '2013-10-03'
group by t.request_at
order by t.request_at