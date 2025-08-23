package org.programmers.greedy;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출명령어 {
    public String greedySolution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        int diff = get_dist(x, y, r, c);
        int move = k;
        int new_diff=0;
        StringBuilder sb = new StringBuilder();
        boolean possible = false;

        if (move-diff<0 || (move-diff)%2==1) return "impossible";

        while (move > 0) {
            if ((move-diff)==0) {
                if (x < r) {
                    sb.append("d");
                    x += 1;
                }
                else if (y > c) {
                    sb.append("l");
                    y-=1;
                }
                else if (y < c) {
                    sb.append("r");
                    y+=1;
                }
                else if (x > r) {
                    sb.append("u");
                    x -= 1;
                }
                diff--;
                move--;
            } else {
                if (x+1<=n ) {
                    sb.append("d");
                    ++x;
                }
                else if (y-1>=1) {
                    sb.append("l");
                    --y;
                }
                else if (y+1<=m) {
                    sb.append("r");
                    ++y;
                }
                else if (x-1>=1) {
                    sb.append("u");
                    --x;
                }
                diff = get_dist(x, y, r, c);
                move--;
            }
        }

        if (x==r && y==c)
            return sb.toString();
        else
            return "impossible";
    }

    //bfs


    public String failSolutionBFS(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        int[] dy = {0, -1, 1, 0}; // 가로 - m, y, c
        int[] dx = {1, 0, 0,-1}; // 세로 - n, x, r
        String[] ds = {"d", "l", "r", "u"};
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y, ""));

        while (!q.isEmpty()) {
            if (get_dist(x,y,r,c) % 2 != k % 2) break;
            Node node = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                String ns = node.s + ds[i];
                int remain_dist = get_dist(nx,ny,r,c);
                if (nx <= 0 | ny <= 0 | nx > n | ny > m) continue;
                // if (ns.length() > k) continue;
                if (ns.length() >= k && (nx != r || ny != c)) continue;
                if (ns.length() == k && nx == r && ny == c) {
                    return ns;
                } else {
                    q.add(new Node(nx, ny, ns));
                }
            }
        }
        return answer;
    }

    int get_dist(int y1, int x1, int y2, int x2) {
        return Math.abs(y1-y2)+Math.abs(x1-x2);
    }


    private class Node {
        int x;
        int y;
        String s;

        private Node(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
}
