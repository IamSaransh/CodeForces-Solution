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

vii readLLVector(int n){
    vector<ll> arr(n);
    lp(i,0, n){
        cin>>arr[i];
    }
    return arr;
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

pair<bool,vector<ll>> check(map<ll,ll>& a, map<ll,ll>& b ){
    //a is my diff what was different
    //b is what is given to me 
    vii left;
    bool checked = true;
    for(auto entry: b){
        int key = entry.first;
        int how_much_in_avail = entry.second;
        int how_much_in_diff = a[key];
        if(how_much_in_diff==how_much_in_avail){
            continue;
        }
        else if(how_much_in_diff< how_much_in_avail){
            return mp(false, left);
        }
        else{
            //we have extra available
            left.push_back(key);
        }
    }
    return mp(true, left);
}

unordered_set<ll> makeSet(vii& arr){
    unordered_set<ll> temp;
    for(auto val: arr){
        temp.insert(val);
    }
    return temp;
}
void addToSet(unordered_set<ll> s, vii& arr){
    for(auto val: arr){
        s.insert(val);
    }
}
int main(){
    #ifndef ONLINE_JUDGE 
        freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\input.in", "r", stdin);
	    freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\output.out", "w", stdout);
    #endif
    int T; cin>>T;
    while(T--)
    {
        int n; cin>>n;
        vii orig = readLLVector(n);
        vii changed = readLLVector(n);
        int m; cin>>m;
        vii modif = readLLVector(m);

        //sol
        map<ll, ll> diff;

        lp(i,0,n){
            if(orig[i]!=changed[i])
                diff[orig[i]]++;
        } 
        map<ll,ll> avail;
        lp(i,0,m){
            avail[modif[i]]++;
        }

        pair <bool, vii> ans =  check(diff, avail);
        if(!ans.first)
            print("NO")
        else 
            {
                bool boolean = true;
                unordered_set<ll> s = makeSet(orig);
                addToSet(s, changed);
                vii left = ans.second;
                for(ll val: left){
                    if(s.find(val)==s.end()){
                        boolean = false;
                    }
                }
                if(boolean) print("YES")
                else print("NO");
            }

    }




}