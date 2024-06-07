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
void printvector(vector<int>& arr){
    for(int i: arr){
        cout<<i<<" ";
    }
    cout<<endl;
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
    int n;
    cin>>n;
    vi arr =readVector(n);
    map<int,int> m;
    vector<vector<int>> ans;
    for(int x: arr){
        m[x]++;
    }
    while(true){
        if(m[1]>0 && m[2]>0 && m[4]>0){
            m[1]--;m[2]--;m[4]--;
            vector<int> temp = {1,2,4};
            ans.push_back(temp);
        }
        else if(m[1]>0 && m[2]>0 && m[6]>0){
            m[1]--;m[2]--;m[6]--;
            vector<int> temp = {1,2,6};
            ans.push_back(temp);
        }
        else if(m[1]>0 && m[3]>0 && m[6]>0){
            m[1]--;m[3]--;m[6]--;
            vector<int> temp = {1,3,6};
            ans.push_back(temp);
        }
        else{
            break;
        }
    }
    if(m[1]!=0 || m[2]!=0 ||m[3]!=0 ||m[4]!=0 ||m[5]!=0 ||m[6]!=0 || m[7]!=0 ){
        print("-1");
    }
    else{
        for(vector<int> partition: ans){
            printvector(partition);
        }
    }




}