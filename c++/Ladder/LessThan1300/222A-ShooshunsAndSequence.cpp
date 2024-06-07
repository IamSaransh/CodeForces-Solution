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
    
    int n, k;
    cin>>n>>k;
    vi arr = readVector(n);

    //check whether the elements from k to n are all same. if not then print -1
    bool valid=true;
    lp(i,k-1,n-1){
        if(arr[i]!=arr[i+1])
            valid = false;
    }
    if(!valid){
        print("-1");
    }
    else{
        //jabtak aapko kth position se peeche same value milte jye minus krte jao iterator ko
        int itr = k-1;
        while(arr[itr]==arr[k-1]){
            itr--;
        }    
        //itr at the place where the condition fails
        //eg  1, 2, 3, 1, 1, 1k, 1111111111111111 itr will be at 3 wwhen stop
        //so answer dalo at itr+1 as 0 indexing and we need to return number of eelements removed
        print(itr+1);
    }


}