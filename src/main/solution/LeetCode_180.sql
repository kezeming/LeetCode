连续出现的数字

Select Distinct
	l1.Num AS ConsecutiveNums
From
	Logs l1,
	Logs l2,
	Logs l3
Where
	l1.Id = l2.Id - 1
	AND l2.Id = l3.Id - 1
	AND l1.Num = l2.Num
	AND l2.Num = l3.Num