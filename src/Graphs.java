import java.util.LinkedList;
import java.util.Queue;

public class Graphs {


    public static void main(String[] args) {



    }

    class Pair{

        int i;
        int j;
        public Pair(int i,int j){
            this.i=i;this.j=j;
        }

    }


    public int maxAreaOfIsland(int[][] grid) {

        int h = grid.length;
        int w = grid[0].length;

        int[][] visited = new int[h][w];

        Queue<Pair> q = new LinkedList();
        int max=0;
        for(int i =0;i<h;i++){
            for(int j=0;j<w;j++){
                if(grid[i][j]==1&&visited[i][j]!=1){
                    //do bfs
                    q.add(new Pair(i, j));
                    int sum=1;
                    visited[i][j]=1;
                    while(!q.isEmpty()){

                        Pair p = q.remove();
                        //left
                        if(p.j-1>=0 && grid[p.i][p.j-1]==1 && visited[p.i][p.j-1]!=1){
                            q.add(new Pair(p.i, p.j-1));
                            sum++;
                            visited[p.i][p.j-1]=1;
                        }
                        //right
                        if(p.j+1<w&&grid[p.i][p.j+1]==1&& visited[p.i][p.j+1]!=1){
                            q.add(new Pair(p.i, p.j+1));
                            sum++;
                            visited[p.i][p.j+1]=1;
                        }
                        //down
                        if(p.i+1<h&&grid[p.i+1][p.j]==1&& visited[p.i+1][p.j]!=1){
                            q.add(new Pair(p.i+1, p.j));
                            sum++;
                            visited[p.i+1][p.j]=1;
                        }
                        //up
                        if(p.i-1>=0&&grid[p.i-1][p.j]==1&& visited[p.i-1][p.j]!=1){
                            q.add(new Pair(p.i-1, p.j));
                            sum++;
                            visited[p.i-1][p.j]=1;
                        }
                    }
                    max=Math.max(sum,max);
                }
            }
        }
        return max;
    }
}
