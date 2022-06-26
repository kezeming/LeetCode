分数排名

Select Score, DENSE_RANK() OVER(Order By Score DESC) `rank`
From Scores
Order By Score DESC