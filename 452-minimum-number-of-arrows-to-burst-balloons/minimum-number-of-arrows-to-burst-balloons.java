
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));//sorting acc to wo ballon khtm kha horha
        int arrows=1;//phle wla burst hogya aur ek use hogya arrow
        int enddia=points[0][1];
        for(int i=1;i<points.length;i++){//dusre ballons e
             if(enddia<points[i][0]){//agr jo ballon abhi burst hua uske badd dusra start horha toh uske liye dusra arrow chaiye hoga toh arrow++ and ab current end wla point jo current burst hua uska hoga 
                 arrows++;
                 enddia=points[i][1];
             }
        }
        return arrows;
    }
}