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

void read2DArray(vector<vector<int>> arr){
            int row = arr.size();
            int col = arr[0].size();
            for(int i=0; i< row; i++){
                for(int j=0; j< col;j++){
                     cin>>arr[i][j];
                }
            }
        }

int main(){
    #ifndef ONLINE_JUDGE 
    // freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\input.in", "r", stdin);
	// freopen("C:\\Workspace\\CodeForces-Solution\\c++\\StriversCpSheep\\Implementation\\output.out", "w", stdout);
    #else
// online submission
    #endif
    long long int n;
    cin>>n;
    string input = to_string(n);
    string output = "";
    lp(i,0,input.length())
    {
        char c = input[i];
        if(i==0 && c=='9'){
            output+=c;
            continue;
        }
        //greedly chnage all number greater than 5 to their counterpart
        if(c-'0' >=5)
            output +=to_string('9' - c);
        else
            output+=c;

    } 
    cout<<output<<endl;
}