#include<bits/stdc++.h>
using namespace std;

int main() {
#ifndef ONLINE_JUDGE
	freopen("shell.in", "r", stdin);
	freopen("shell.out", "w", stdout);
#endif
	int n;
    cin>>n;
    vector<int>shell_at_pos(3);
    // Place the shells down arbitrarily
	for (int i = 0; i < 3;i++) {
		shell_at_pos[i] = i;
	}
    vector<int> counter(3);
    for(int i=0;i<n;i++){
        int a,b,g;
        cin>>a>>b>>g;
        a--;b--;g--; // zero based indexing
        //swap the place
        std::swap(shell_at_pos[a], shell_at_pos[b]);
        // Count the number of times Elsie guesses each particular shell
		counter[shell_at_pos[g]]++;
    }
    printf("%d\n", std::max({counter[0], counter[1], counter[2]}));



}