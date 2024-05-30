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

int main(){
    #ifndef ONLINE_JUDGE 
        freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\input.in", "r", stdin);
	    freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\output.out", "w", stdout);
    #endif
    int n,sx, sy, ex,ey;
    string s;
    cin >>n>>sx>>sy>>ex>>ey>>s;
    int count = 0;
    map<char, pair<int,int>> move;
    move['N']= make_pair(0,1);
    move['S']= make_pair(0,-1);
    move['E']= make_pair(1,0);
    move['W']= make_pair(-1,0);
    //check the distance we need to move
    int move_x= ex-sx;
    int move_y = ey-sy;
    char preffered_x;
    char preffered_y;

    if(move_x>0){
        preffered_x='E';
    }
    else{
        preffered_x='W';
    }
    if(move_y>0){
        preffered_y='N';
    }
    else{
        preffered_y='S';
    }
    move_x = abs(move_x);
    move_y=abs(move_y);
    lp(i,0,n){
        if(s[i]==preffered_x){
            move_x--;
        }
        if(s[i]==preffered_y){
            move_y--;
        }
        count++;
        if(move_x<=0 && move_y<=0)
            break;
    }
    if(move_x<=0 && move_y<=0 && count<=n){
        print(count);
    }
    else{
        print("-1")
    }



}