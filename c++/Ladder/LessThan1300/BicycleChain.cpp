#include<bits/stdc++.h>
#define ff first
#define ss second
#define pb push_back
#define mp make_pair
#define mt make_tuple
#define ll long long int
#define dd long double
#define lp(i,a,b) for (long long int i = (a); i < (b); ++i)
#define all(x) x.begin(),x.end()
#include <iostream>
using namespace std;

typedef vector<int> vi;
typedef vector<pair<int,int>> vip;
typedef vector<double> vd;
typedef vector<long long int> vii;
typedef vector<long double> vdd;

void read2DArray(vector<vector<int>>& arr){
            int row = arr.size();
            int col = arr[0].size();
            for(int i=0; i< row; i++){
                for(int j=0; j< col;j++){
                     cin>>arr[i][j];
                }
            }
}
void readVector(vi& arr){
    lp(i,0, arr.size()){
        cin>>arr[i];
    }
}
void readVector(vi& arr, int n){
    lp(i,0, n){
        cin>>arr[i];
    }
}

int main(){
    #ifndef ONLINE_JUDGE 
        freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\input.in", "r", stdin);
	    freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\output.out", "w", stdout);
    #endif
    int n,m;
    cin>>n;
    vi front(n);
    readVector(front, n);
    cin>>m;
    vi back(m);
    readVector(back, m);
    vector<int> ans; //stores the gear ratio
    lp(i,0,n){
        lp(j,0,m){
            int ai = front[i];
            int bj = back[j];
            //gear ratio is bj/ai
            if(bj%ai==0){
                ans.push_back(bj/ai);                
            }
        }
    }
    int maxGearRatio = *max_element(all(ans));
    int timesMaxRatio = count(all(ans), maxGearRatio);
    cout<<timesMaxRatio<<endl;

    



}