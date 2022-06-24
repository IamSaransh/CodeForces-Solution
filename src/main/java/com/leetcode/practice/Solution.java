package com.leetcode.practice;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        final int TOTAL_BUILDINGS = heights.length;
        int currBricks = bricks;
        int currLadders = ladders;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        //small one;s use bricks and big ones use ladder
        int maxiBuilding = 0;
        for(int i=0; i< heights.length-1; i++){
            pQueue.add(heights[i+1] - heights[i]);
        }
        for(int building = 1; building < TOTAL_BUILDINGS; building++){
            int currBuildingHeight = heights[building];
            int prevBuildingHeight = heights[building-1];
            int reqBrick =  currBuildingHeight - prevBuildingHeight ;
            int maxHeap;
            if(pQueue.isEmpty())
                maxHeap = -1;
            else
                maxHeap = pQueue.peek();
            if(reqBrick < 0 ){ // jump down
                maxiBuilding++;
            }
            else{ // go up
                if(currBuildingHeight!= maxHeap && currBricks > reqBrick ){
                    currBricks -= reqBrick;
                    maxiBuilding++;
                }
                if(currBuildingHeight== maxHeap && currLadders > 0){
                    currLadders--;
                    maxiBuilding++;
                    pQueue.poll();
                }
                if(currBuildingHeight!= maxHeap && (currLadders > 0)){
                    currLadders--;
                    maxiBuilding++;
                }
                else{
                    break;
                }
            }
        }
        return maxiBuilding;

    }
}