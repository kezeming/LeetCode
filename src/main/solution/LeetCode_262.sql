# Round 为四舍五入函数
Select T.request_at AS `Day`,
	ROUND(
		SUM(
			IF(T.Status = 'completed', 0, 1)
		)
		/
		COUNT(T.Status),
		2
	) AS `Cancellation Rate`
From Trips AS T
Join Users AS U1 ON (T.client_id = U1.users_id AND U1.banned = 'No')
Join Users AS U2 ON (T.driver_id = U2.users_id AND U2.banned = 'No')
Where T.request_at Between '2013-10-01' AND '2013-10-03'
Group By T.request_at