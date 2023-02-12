#include<bits/stdc++.h>
#include<iostream>
using namespace std;
void moveToBuket(vector<pair<int,int>>& bucket_and_milk, int from, int to){
   
}

int main() {
// #ifndef ONLINE_JUDGE
	freopen("cowsignal.in", "r", stdin);
	freopen("cowsignal.out", "w", stdout);
// #endif
    int row, col, k;
	cin>>row>>col>>k;
    //create a vector for input shape
    vector<vector<char>> grid(row, vector<char>(col, 0)) ;
    for(int i=0;i<row;i++){
        for(int j = 0; j<col; j++){
            cin>>grid[i][j];
        }
    }            
    for(int i=0;i<row;i++){
        for(int b=0;b<k;b++){   
            for(int j = 0; j<col; j++){
                for(int a=0;a<k;a++){
                    cout<<grid[i][j];    
                }
            }
            cout<<endl;
        }
        
    }
    

}