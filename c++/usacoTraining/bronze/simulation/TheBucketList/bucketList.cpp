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

using namespace std;

typedef vector<int> vi;
typedef vector<pair<int,int>> vip;
typedef vector<double> vd;
typedef vector<long long int> vii;
typedef vector<long double> vdd;
int main(){
    freopen("blist.in", "r", stdin);
	freopen("blist.out", "w", stdout);
    //take in
    int n;
    cin>>n;
    vip ranges(n);
    vi bucketAtTime (10001);// use 1 indexing
    lp(i,0,n){
       int from, to, bucket;
       cin>>from>>to>>bucket;
       lp(i,from, to+1){
        bucketAtTime[i]+=bucket;
       }
    }
    cout<<*max_element(all(bucketAtTime))<<endl;

    
    
    
    
    
}