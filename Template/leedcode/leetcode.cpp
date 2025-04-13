// #pragma GCC optimize("O3,unroll-loops")

#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>

using namespace std;

    class Solution {
    public:
    long long maximumTripletValue(vector<int>& nums) {
        int n = nums.size();
        if(n<3) return 0;
        // we have an array greater than 3
        int ni = nums[0], nj = nums[1], nk = nums[2];
        for(int i=3;i<n;++i){
            int curr = nums[i];
            //the curr can be used for the value nk only, 
            //check if it makes sense to update the nk, we want to maximize it
            int prev=0;
            if(curr>=nk){
                prev = nk;
                nk = curr;
            }
            if(prev==0) 
                prev = INT_MAX;
            //check if the prev could be the new nj, which we want to minimize?
            if(nj>=prev){
                int prev_nj = nj;
                nj = prev;
                prev = prev_nj;
            }
            //now check if the ni can be maximized?
            //what values can be used for ni? either prev1 or prev2?
            if(prev>=ni){
                ni = prev;
            }

        }
        long long ans =  1LL * (ni-nj)* nk;
        cout<<ni<<" "<<nj<<" "<<nk<<endl;
        if(ans >=0) return ans; else return 0;
    }
    };
    
int main()
{
    Solution s ;
    vector<int> nums = {5,7,8,4};
    int ans  = s.maximumTripletValue(nums);
}