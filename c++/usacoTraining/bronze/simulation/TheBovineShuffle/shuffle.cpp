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
typedef vector<double> vd;
typedef vector<long long int> vii;
typedef vector<long double> vdd;
int main(){
    freopen("shuffle.in", "r", stdin);
	freopen("shuffle.out", "w", stdout);
    //take input
    int n;
    cin>>n;
    vi pos(n,0);
    vector<int> currSeq(n);
    lp(i,0,n){
        cin>>pos[i];
    }
    lp(i,0,n){
        cin>>currSeq[i];
    }
    //track back three steps
    lp(i,0,3){
        vector<int> lastSeq(n);
        lp(j,0,n)
        {
            //find the prev index for this Jth element
            lastSeq[j] = currSeq[pos[j]-1];
        }
        //this will become my new curr 
        currSeq = lastSeq;
    }
    for(auto val: currSeq)
    {
        cout<<val<<endl;
    }


    
}