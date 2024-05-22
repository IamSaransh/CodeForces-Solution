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

int main() {
    freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\input.in", "r", stdin);
	freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\output.out", "w", stdout);
    int n;
    cin>>n;
    vector<string> ops(n);
    lp(i,0,n)
    {
        cin>>ops[i];
    }
    int ans = 0;
    for(string val: ops)
    {
        if(val == "++X" || val == "X++")
            ans++;
        else
            ans--;
        
    }
    
    cout<<ans<<endl;



  
}
