#include<bits/stdc++.h>
#include<iostream>
using namespace std;
// /https://usaco.org/index.php?page=viewproblem2&cpid=568

int main() {
// #ifndef ONLINE_JUDGE
	freopen("speeding.in", "r", stdin);
	freopen("speeding.out", "w", stdout);
// #endif
    int limit_seg, speed_seg;
	cin>>limit_seg>>speed_seg;
    //create a vector for input shape
    vector<int> limitArr (100,0);
    int start = 0;
    for(int i=0; i<limit_seg;i++){
        int tillKm, limit;
        cin>>tillKm>>limit;
        for(int j=start;j<start+tillKm; j++){
            limitArr[j]= limit;
        }
        start+=tillKm;
    }
    //for his speed

    vector<int> speedArr (100,0);
    start = 0;
    for(int i=0; i<speed_seg;i++){
        int tillKm, speed;
        cin>>tillKm>>speed;
        for(int j=start;j<start+tillKm; j++){
            speedArr[j]= speed;
        }
        start+=tillKm;
    }

    int maxOverspeed=0;

   for(int i=0; i<100;i++)
   {
    if(speedArr[i]>limitArr[i])
    {
        maxOverspeed = max(maxOverspeed, speedArr[i]-limitArr[i]);
    }
   }
   cout<<maxOverspeed<<endl;


}