#include<bits/stdc++.h>
#include<iostream>
using namespace std;

int main() {
// #ifndef ONLINE_JUDGE
	freopen("lostcow.in", "r", stdin);
	freopen("lostcow.out", "w", stdout);
// #endif
    int x, y; 
    cin>>x>>y;
    int walk =1;
    int totalDist = 0;
    int original = x;
    int oldPos=x;
    while(true){
        oldPos=x;
        x=original;
        x+=walk;
        walk*=-2;//simulate +ve and -ve walk
        //cheak if we found bessie
        if(oldPos<=y && y<=x || x<=y && y<=oldPos){
            totalDist+=abs(y-oldPos);
            break;
        }
        totalDist+=abs(x-oldPos);
    }
    cout<<totalDist<<endl;
}