// #pragma GCC optimize("O3,unroll-loops")

#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>

using namespace std;
class TrieNode {
    public:
        unordered_map<char, TrieNode*> children;
        int count;  // Number of words passing through this node
    
        TrieNode() : count(0) {}
    };
    
    class Trie {
    public:
        TrieNode* root;
    
        Trie() {
            root = new TrieNode();
        }
    
        // Insert a word into the Trie
        void insert(const string& word) {
            TrieNode* node = root;
            node->count++;  // Update root count
            for (char c : word) {
                if (!node->children.count(c)) {
                    node->children[c] = new TrieNode();
                }
                node = node->children[c];
                node->count++;  // Increase count for each character node
            }
        }
    
        // Remove a word from the Trie
        void remove(const string& word) {
            TrieNode* node = root;
            node->count--;  // Decrease root count
            for (char c : word) {
                if (node->children.count(c)) {
                    node = node->children[c];
                    node->count--;  // Decrease count for each character node
                }
            }
        }
    
        int getLCP(int k) {
            TrieNode* node = root;
            int length = 0;
        
            while (node) {  
                if (node->count < k) break;  // Ensure at least `k` words pass through
                
                TrieNode* nextNode = nullptr;
                for (auto& [ch, child] : node->children) {  
                    if (child->count >= k) {  // Choose the child where at least `k` words pass
                        nextNode = child;
                        length++;  // Increase LCP length
                        break;     // Continue down this path
                    }
                }
        
                if (!nextNode) break;  // Stop if no valid child is found
                node = nextNode;
            }
            
            return length;
        }
    };
    
    class Solution {
    public:
        vector<int> longestCommonPrefix(vector<string>& words, int k) {
            int n = words.size();
            vector<int> result(n, 0);
            if (k > n) return result;  // If k > n, no valid LCP possible
    
            Trie trie;
    
            // Insert all words into the Trie
            for (const string& word : words) {
                trie.insert(word);
            }
    
            // Process each word removal and compute LCP
            for (int i = 0; i < n; ++i) {
                trie.remove(words[i]);  // Remove current word
                if (n - 1 >= k) {  // Ensure we still have at least k words
                    result[i] = trie.getLCP(k);
                }
                trie.insert(words[i]);  // Re-insert the word back
            }
    
            return result;
        }
    };
    
int main()
{
    Solution s ;
    vector<string> words = {"jump","run","run","jump","run"};
    vector<int> ans  = s.longestCommonPrefix(words, 2);
    for(auto a: ans) cout<<a<<" ";
}