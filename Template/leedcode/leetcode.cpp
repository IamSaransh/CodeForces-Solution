// #pragma GCC optimize("O3,unroll-loops")

#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>

using namespace std;
class Solution {
public:
    #include<bits/stdc++.h>
#include<string.h>

bool rotateString(string s, string goal) {
        bool ans = false;
        int m = s.length(); int n = goal.length();
        if(m!=n) return false;
        int  i, j =0;
        int count = 0;
        while(j<2*n && i<n){
            bool same  = (s[i] == goal[j]) ? true: false;
            if(same){
                i++;
                j = (j+1)%n;
                count ++;
                if(count == n-1) return true;
            } else {
                //no match
                j = (j+1)%n;
                count = 0;
            }
        }
        return false;
    }
};
    
int main()
{
    Solution s ;
    s.rotateString("abcde", "cdeab");
}