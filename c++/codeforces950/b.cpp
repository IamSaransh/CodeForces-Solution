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
int getStartIndex(vector<int>& arr, int val){
    int i=0;
    lp(i,0,arr.size()){
        if(arr[i]==val)
            return i;
    }
    return -1;

}
int getEndIndex(vector<int>& arr, int val){
    int i=0;
    for(int i=arr.size()-1; i>=0;i--){
        if(arr[i]==val)
            return i;
    }
    return -1;
}

int main(){
    #ifndef ONLINE_JUDGE 
        freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\input.in", "r", stdin);
	    freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\output.out", "w", stdout);
    #endif
    int t;
    cin>>t;
    while(t--)
    {
        int n,f,k;
        cin>>n>>f>>k;
        vi arr = readVector(n);
        int fav = arr[f-1];
        sort(arr.begin(), arr.end(), std::greater<int>());
        int startIdz = getStartIndex(arr, fav);
        int endIdx = getEndIndex(arr, fav);
        k--;//0 based indexing 
        if(startIdz<=k && endIdx<=k){
            print("YES");
        }
        else if(startIdz>k && endIdx>k) {
            print("NO")
        } 
        else{
            print("MAYBE");
        }

    }



}