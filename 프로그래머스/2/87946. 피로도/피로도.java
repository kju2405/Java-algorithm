import java.util.*;

class Solution {
    
    int answer=0;
    boolean[] visited;
    int count;
    int[][] Dungeons;
    
    public int solution(int k, int[][] dungeons) {
        count=dungeons.length;
        visited=new boolean[count];
        Dungeons=dungeons;
        
        backtracking(k,0);
        
        return answer;
    }
    
    private void backtracking(int k, int visitedCount) {
        if(answer<visitedCount) {
            answer=visitedCount;
        }
        
        for(int i=0;i<count;i++) {
            if(!visited[i] && k>=Dungeons[i][0]) {
                visited[i]=true;
                k-=Dungeons[i][1];
                backtracking(k, visitedCount+1);
                visited[i]=false;
                k+=Dungeons[i][1];
            }
        }
    }
}