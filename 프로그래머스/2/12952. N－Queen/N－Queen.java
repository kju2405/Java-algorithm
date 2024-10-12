import java.util.*;

class Solution {
    
    private static boolean[] down, rightTop, rightBottom;
    private static int answer=0;
    private static int N;
    
    public int solution(int n) {
        N=n;
        
        down=new boolean[n];
        rightTop=new boolean[2*n-1];
        rightBottom=new boolean[2*n-1];
        
        backtracking(0);
        
        return answer;
    }
    
    private void backtracking(int row) {
        if(row==N) {
            answer++;
            return;
        }
        
        for(int col=0;col<N;col++) {
            if(!down[col] && !rightTop[row+col] && !rightBottom[row-col+N-1]) {
                down[col]=true;
                rightTop[row+col]=true;
                rightBottom[row-col+N-1]=true;
                backtracking(row+1);
                down[col]=false;
                rightTop[row+col]=false;
                rightBottom[row-col+N-1]=false;
            }   
        }
    }
}