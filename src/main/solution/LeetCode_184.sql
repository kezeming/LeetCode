// 工资最高的
Select 
	Department.name AS 'Department',
	Employee.name AS 'Employee',
	Salary
From 
	Employee
	Join
	Department ON Employee.DepartmentId = Department.Id
Where
	(Employee.DepartmentId, Salary) IN
	(	Select 
			DepartmentId, MAX(Salary)
		From
			Employee
		Group by DepartmentId
	)


// 工资前三高
Select
	d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
From
	Employee e1
	Join
	Department d ON e1.DepartmentId = d.Id
Where
	3 > (Select
			Count(DISTINCT e2.Salary)
		From
			Employee e2
		Where
			e2.Salary > e1.Salary
			AND e1.DepartmentId = e2.DepartmentId
		)