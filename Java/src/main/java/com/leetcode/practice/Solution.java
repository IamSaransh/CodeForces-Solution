package com.leetcode.practice;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    private double calcDistanceFromOrigin(int x, int y) {
        double squaredSum = Math.pow(x, 2) + Math.pow(y, 2);
        return Math.sqrt(squaredSum);
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> pq = new PriorityQueue<>();
        //build heap
        for (int[] point : points) {
            int x = point[0], y = point[1];
            double dist = calcDistanceFromOrigin(x, y);
            pq.add(new Point(x, y, dist));
        }
        //poll and fill next k elements in the answer
        int[][] ans = new int[k][2];
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            Point polledPoint = pq.poll();
            ans[i][0] = polledPoint.x;
            ans[i][1] = polledPoint.y;
        }
        return ans;


    }

    static class Point implements Comparable<Point> {
        private int x;
        private int y;
        private double dist;

        public Point(int x, int y, double dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point that) {
            if (this.dist > that.dist) return 1;
            if (this.dist < that.dist) return -1;
            else return 0;
        }
    }
}