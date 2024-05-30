#include<bits/stdc++.h>
#define ff first
#define ss second
#define pb push_back
#define mp make_pair
#define mt make_tuple
#define ll long long int
#define dd long double
#define print(x) cout<<x<<endl;
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
vi readVector(int n){
    vector<int> arr(n);
    lp(i,0, n){
        cin>>arr[i];
    }
    return arr;
}
int calculate_happiness(int a, int b, int c, int d, int e, vector<vector<int>>& arr){

    int happy =  (arr[a][b] +arr[b][a] + arr[c][d] +  arr[d][c]) + (arr[b][c] + arr[c][b] + arr[d][e] + arr[e][d]) + arr[c][d] + arr[d][c] + arr[d][e] + arr[e][d];
    // // if(happy==18)
    //     cout<<a<<" "<<b<<" "<<c<<" "<<d<<" "<<e<<"score="<<happy<<endl;
    return happy;
}

int main(){
    #ifndef ONLINE_JUDGE 
        freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\input.in", "r", stdin);
	    freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\output.out", "w", stdout);
    #endif
    
    vector<vector<int>> arr(5, vector<int>(5));
    read2DArray(arr);
    int max_so_far = 0;
    lp(a,0,5){
        lp(b,0,5){
            lp(c,0,5){
                lp(d,0,5){
                    lp(e,0,5){
                        //if all different we have a valid sequence
                        set<ll> s = {a,b,c,d,e};
                        if(s.size()==5){
                            max_so_far=max(max_so_far,calculate_happiness(a,b,c,d,e, arr));
                        }
                    }
                }
            }
        }
    }
    print(max_so_far);



}