package main.solution;

// 数学题
public class LeetCode_780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // 因为正向查找会出现很多的中间状态，耗时
        // 所以采用反向查找的方法
        while (tx > sx && ty > sy && tx != ty) {
            if(tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if(tx == sx && ty == sy) {
            return true;
        } else if(tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        } else if(ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }
    }
}