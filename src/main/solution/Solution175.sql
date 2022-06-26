-- from子句中on条件主要用来连接表，其他不属于连接表的条件可以使用where子句来指定；
-- join连接分为三种，1内连接，2外连接，3交叉连接；
-- 1：inner join ，默认，所以可以省略inner关键字
-- 2：left outer join ，左外连接，结果表中除了匹配行外，还包括左表有而右表中不匹配的行，对于这样的行，右表选择列置为null
--    right outer join ，右外连接，结果表中除了匹配行外，还包括右表有而左表中不匹配的行，对于这样的行，左表选择列置为null
--    natural join，自然连接，分为natural left outer join和natural right outer join，语义定义与inner join相同
-- 3：cross join，交叉连接，实际上就是将两个表进行笛卡尔积运算，结果表的行数等于两表行数之积


Select FirstName, LastName, City, State
From Person left join Address
On Person.PersonId = Address.PersonId;