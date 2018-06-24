select (select * from number group by num having count(*) = 1 order by num desc limit 1) as num;


select p.name
from orders o join company c on (o.com_id = c.com_id and c.name = 'RED')
left join salesperson p on p.sales_id = o.sales_id
where o.sales_id is null

#Students Report By Geography




