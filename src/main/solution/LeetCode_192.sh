cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{print $2, $1}'

1. 切割
tr 命令用于转换或删除文件中的字符
-s 缩减连续重复的字符成指定的单个字符
cat words.txt | tr -s ' ' '\n'
-- result '
the
day
is
sunny
the
the
the
sunny
is
is
'

2. 排序单词
sort
-- result '
day
is
is
is
sunny
sunny
the
the
the
the
'

3. 统计单词出现次数
uniq 命令用于检查及删除文本文件中重复出现的行列，一般与sort命令结合使用
-c 在每列旁边显示该行重复出现的次数
uniq -c
-- result '
1 day
3 is
2 sunny
4 the
'

4. 排序单词出现次数
-r 以相反的顺序来排序
sort -r
-- result '
4 the
3 is
2 sunny
1 day
'

5. 打印
awk '{print $2, $1}'
-- result '
the 4
is 3
sunny 2
day 1
'