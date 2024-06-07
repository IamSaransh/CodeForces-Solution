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

vii readLongVector(int n){
    vector<ll> arr(n);
    lp(i,0, n){
        cin>>arr[i];
    }
    return arr;
}
unordered_set<ll> makeSet(vii& arr){
    unordered_set<ll> temp;
    for(auto val: arr){
        temp.insert(val);
    }
    return temp;
}

int longest_common_subsegment_length(int x, int y) {
    int z = x ^ y;
    int trailing_zeros = 0;
    
    // Count the number of trailing zeros in z
    while (z > 0 && (z & 1) == 0) {
        trailing_zeros++;
        z >>= 1;
    }
    
    return 1 << trailing_zeros;
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
        int n;
        cin>>n;
        vi k = readVector(n);
        vii  x(n);
        x[0] = 1;
        // Calculate the product of all multipliers
        long long product = 1;
        for (int i = 0; i < n; ++i) {
            product *= k[i];
        }
        
        for (int i = 1; i < n; ++i) {
            x[i] = x[i - 1] * product;
        }
        
        for (int i = 0; i < n; ++i) {
            cout << x[i] << " ";
        }
        cout << "\n";
    }



}