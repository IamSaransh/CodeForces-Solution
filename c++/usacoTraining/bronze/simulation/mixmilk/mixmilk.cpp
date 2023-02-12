#include<bits/stdc++.h>
using namespace std;
void moveToBuket(vector<pair<int,int>>& bucket_and_milk, int from, int to){
   
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("mixmilk.in", "r", stdin);
	freopen("mixmilk.out", "w", stdout);
#endif
	vector<pair<int,int>> bucket_and_milk(3);
    for(int i=0;i<3; i++){
        cin>>bucket_and_milk[i].first;
        cin>>bucket_and_milk[i].second;
    }
    int from = 0;
    int to  =1;
    for(int i=0;i<100;i++)
    {
        pair<int,int> fromValue = bucket_and_milk[from];
        pair<int,int> toValue = bucket_and_milk[to];
        int remInNextBucket = toValue.first - toValue.second;
        int amt = min(fromValue.second, remInNextBucket);
        bucket_and_milk[from].second-=amt;
        bucket_and_milk[to].second+=amt;
        from = (from+1)%3;
        to = (to+1)%3;
    }
    for(int i=0;i<3; i++){
        cout<<bucket_and_milk[i].second<<endl;
    }
    

}