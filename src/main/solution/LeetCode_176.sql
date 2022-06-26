第二高的薪水
Select (
	Select DISTINCT Salary
	From Employee
	Order By Salary DESC
	LIMIT 1 OFFSET 1
	) AS SecondHighestSalary
;


使用 IFNULL 函数版本
Select IFNULL(
	(
	Select DISTINCT Salary
	From Employee
	Order By Salary DESC
	LIMIT 1 OFFSET 1
	), NULL) AS SecondHighestSalary
;