/*
 * Given an undirected graph with v vertices(numbered from 1 to v) and e edges. Find the number of good components in the graph.
A component of the graph is good if and only if the component is fully connected.
Note: A fully connected component is a subgraph of a given graph such that there's an edge between every pair of vertices in the component, the given graph can be a disconnected graph. 

Example 1:

Input: 


e=3 
v=3
edges={{1, 2},{1, 3},{3, 2}}
Output: 
1
Explanation: 
We can see that there is only one component in the graph and in this component there is a edge between any two vertces.
Example 2:

Input:

e=5 
v=7
edges={{1, 2},{7, 2},{3, 5},{3, 4},{4, 5}}
Output: 
2
Explanation: 
We can see that there are 3 components in the graph. For 1-2-7 there is no edge between 1 to 7, so it is not a fully connected component. Rest 2 are individually fully connected component.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findNumberOfGoodComponent(), which takes an integer e and v and edges[][] as input parameters and returns an integer denoting the number of good components.

Expected Time Complexity: O(v+e)
Expected Auxiliary Space: O(depth of the graph)

Constraints:
1 <= edges[i][0], edges[i][1] <= v
1 ≤ v, e ≤ 104
All edges are unique
 */
class Solution {
    findNumberOfGoodComponent(e, v, edges) {
        
       //Create adjacency list
        let adj = {}
        for(let [i, j] of edges){
            if(!adj[i]) adj[i] = [j]
            else adj[i].push(j)
            if(!adj[j]) adj[j] = [i]
            else adj[j].push(i)
        }
        
        //BFS function
        const bfs = (adj, node, queue, visited) => {
            visited[node] = true
            queue.push(node)
            for(let n of queue){
                for(let e of adj[n]){
                    if(!visited[e]){
                        visited[e] = true
                        queue.push(e)
                    }
                }
            }
        }
        
        //to store the number of good components
        let good = 0
        
        let visited = new Array(v+1).fill(false)

       //checking all the vertices
        for(let i = 1; i <= v; i++){
            if(visited[i]) continue

            //edge case: if a node has no neighbours
            if(!adj[i]){
                good++
                continue
            }
            
            //find out number of vertices in current connected path
            let path = []
            bfs(adj, i, path, visited)
            let flag = 1

           //check if the current connected path has same number of neighbours as in all of its vertices(n-1, since vertex itself is also added in path)
            for(let e of path){
                if(adj[e].length !== path.length - 1){
                    flag = 0
                    break
                }
            }
            if(flag) good++
        }
        return good
    }
}