// #pragma GCC optimize("O3,unroll-loops")

#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>

using namespace std;
using namespace chrono;
using namespace __gnu_pbds;

#define fastio() ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define MOD 1000000007
#define MOD1 998244353
#define INF 1e18
#define nline "\n"
#define pb push_back
#define ppb pop_back
#define mp make_pair
#define ff first
#define ss second
#define PI 3.141592653589793238462
#define set_bits __builtin_popcountll
#define sz(x) ((int)(x).size())
#define print(x) cout<<x<<endl;
#define lp(i,a,b) for (long long int i = (a); i < (b); ++i)
#define all(x) x.begin(),x.end()
#ifndef ONLINE_JUDGE
#define debug(x) cerr << #x<<" "; _print(x); cerr << endl;
#else
#define debug(x);
#endif

typedef long long ll;
typedef unsigned long long ull;
typedef long double lld;
typedef __int128 ell;
typedef tree<pair<ll, ll>, null_type, less<pair<ll, ll>>, rb_tree_tag, tree_order_statistics_node_update > pbds; // find_by_order, order_of_key

void _print(ll t) {cerr << t;}
void _print(int t) {cerr << t;}
void _print(string t) {cerr << t;}
void _print(char t) {cerr << t;}
void _print(lld t) {cerr << t;}
void _print(double t) {cerr << t;}
void _print(ull t) {cerr << t;}

template <class T, class V> void _print(pair <T, V> p);
template <class T> void _print(vector <T> v);
template <class T> void _print(set <T> v);
template <class T, class V> void _print(map <T, V> v);
template <class T> void _print(multiset <T> v);
template <class T, class V> void _print(pair <T, V> p) {cerr << "{"; _print(p.ff); cerr << ","; _print(p.ss); cerr << "}";}
template <class T> void _print(vector <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(set <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T> void _print(multiset <T> v) {cerr << "[ "; for (T i : v) {_print(i); cerr << " ";} cerr << "]";}
template <class T, class V> void _print(map <T, V> v) {cerr << "[ "; for (auto i : v) {_print(i); cerr << " ";} cerr << "]";}
void _print(pbds v) {cerr << "[ "; for (auto i : v) {_print(i); cerr << " ";} cerr << "]";}
template <typename T>void readArray(std::vector<T>& arr, int n) {arr.resize(n); for(int i = 0; i < n; ++i) {std::cin >> arr[i]; }}

mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
/*---------------------------------------------------------------------------------------------------------------------------*/
ll gcd(ll a, ll b) {if (b > a) {return gcd(b, a);} if (b == 0) {return a;} return gcd(b, a % b);}
ll expo(ll a, ll b, ll mod) {ll res = 1; while (b > 0) {if (b & 1)res = (res * a) % mod; a = (a * a) % mod; b = b >> 1;} return res;}
void extendgcd(ll a, ll b, ll*v) {if (b == 0) {v[0] = 1; v[1] = 0; v[2] = a; return ;} extendgcd(b, a % b, v); ll x = v[1]; v[1] = v[0] - v[1] * (a / b); v[0] = x; return;} //pass an arry of size1 3
ll mminv(ll a, ll b) {ll arr[3]; extendgcd(a, b, arr); return arr[0];} //for non prime b
ll mminvprime(ll a, ll b) {return expo(a, b - 2, b);}
bool revsort(ll a, ll b) {return a > b;}
ll combination(ll n, ll r, ll m, ll *fact, ll *ifact) {ll val1 = fact[n]; ll val2 = ifact[n - r]; ll val3 = ifact[r]; return (((val1 * val2) % m) * val3) % m;}
void google(int t) {cout << "Case #" << t << ": ";}
vector<ll> sieve(int n) {int*arr = new int[n + 1](); vector<ll> vect; for (int i = 2; i <= n; i++)if (arr[i] == 0) {vect.push_back(i); for (int j = 2 * i; j <= n; j += i)arr[j] = 1;} return vect;}
ll mod_add(ll a, ll b, ll m) {a = a % m; b = b % m; return (((a + b) % m) + m) % m;}
ll mod_mul(ll a, ll b, ll m) {a = a % m; b = b % m; return (((a * b) % m) + m) % m;}
ll mod_sub(ll a, ll b, ll m) {a = a % m; b = b % m; return (((a - b) % m) + m) % m;}
ll mod_div(ll a, ll b, ll m) {a = a % m; b = b % m; return (mod_mul(a, mminvprime(b, m), m) + m) % m;}  //only for prime m
ll phin(ll n) {ll number = n; if (n % 2 == 0) {number /= 2; while (n % 2 == 0) n /= 2;} for (ll i = 3; i <= sqrt(n); i += 2) {if (n % i == 0) {while (n % i == 0)n /= i; number = (number / i * (i - 1));}} if (n > 1)number = (number / n * (n - 1)) ; return number;} //O(sqrt(N))
ll getRandomNumber(ll l, ll r) {return uniform_int_distribution<ll>(l, r)(rng);}
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
unordered_set<ll> makeSet(vii& arr){
    unordered_set<ll> temp;
    for(auto val: arr){
        temp.insert(val);
    }
    return temp;
}
vii readLongVector(int n){
    vector<ll> arr(n);
    lp(i,0, n){
        cin>>arr[i];
    }
    return arr;
}
//////////////////////////////////////////////////////////////////////////////


/*--------------------------------------------------------------------------------------------------------------------------*/
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

bool check(int x, vector<int> &arr, int k) {
    int subarrays = 0;
    int n = arr.size();
    set<int> s;
    for (int i = 0; i < n; ++i) {
        if (arr[i] < x) {
            s.insert(arr[i]);
            if ((int)s.size() == x) {
                // We have all elements from 0 to x-1
                subarrays++;
                s.clear();
            }
        }
    }
    return subarrays >= k;
}

void solve() {
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    int start = 0;
    int end = *max_element(arr.begin(), arr.end()) + 1;
    int ans = 0;
    if(end==1 ) {
        print(1);
        return;
    }

    while (start <= end) {
        int mid = (start + end) / 2;
        if (check(mid, arr, k)) {
            ans = mid; // Update answer if current mid is valid
            start = mid + 1; // Try for a larger MEX
        } else {
            end = mid - 1; // Try for a smaller MEX
        }
    }

    cout << ans << endl;
}




int main() {
#ifndef ONLINE_JUDGE
    freopen("C:\\workspace\\Coding\\CodeForces-Solution\\Template\\error.txt", "w", stderr);
    freopen("C:\\workspace\\Coding\\CodeForces-Solution\\Template\\input.in", "r", stdin);
    freopen("C:\\workspace\\Coding\\CodeForces-Solution\\Template\\output.out", "w", stdout);
#endif
    fastio();
    auto start1 = high_resolution_clock::now();
    ll tc =1;
    cin>>tc;
    while(tc--){
        solve();
    } 
    auto stop1 = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop1 - start1);
#ifndef ONLINE_JUDGE
    cerr << "Time: " << duration . count() / 1000 << endl;
    cerr << "Time ms: " << duration . count() << endl;
#endif
}