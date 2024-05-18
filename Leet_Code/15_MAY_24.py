"""
2812. Find the Safest Path in a Grid

You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:

A cell containing a thief if grid[r][c] = 1
An empty cell if grid[r][c] = 0
You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, including cells containing thieves.

The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the path to any thief in the grid.

Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).

An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.

The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the absolute value of val.

 

Example 1:


Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
Output: 0
Explanation: All paths from (0, 0) to (n - 1, n - 1) go through the thieves in cells (0, 0) and (n - 1, n - 1).
Example 2:


Input: grid = [[0,0,1],[0,0,0],[0,0,0]]
Output: 2
Explanation: The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 2) is cell (0, 0). The distance between them is | 0 - 0 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.
Example 3:


Input: grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
Output: 2
Explanation: The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). The distance between them is | 0 - 1 | + | 3 - 2 | = 2.
- The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). The distance between them is | 3 - 3 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.
 

Constraints:

1 <= grid.length == n <= 400
grid[i].length == n
grid[i][j] is either 0 or 1.
There is at least one thief in the grid.
"""
#Solution
class Solution:
    def valid(self, i: int, j: int, n: int) -> bool:
        return 0 <= i < n and 0 <= j < n

    def compute_distance_grid(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        dist_grid = [[float('inf')] * n for _ in range(n)]
        q = deque()

        # Initialize the queue and distance for '0' cells
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    q.append((i, j))
                    dist_grid[i][j] = 0

        # Directions: up, down, left, right
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        # BFS to compute minimum distances
        while q:
            x, y = q.popleft()
            for dx, dy in directions:
                new_x, new_y = x + dx, y + dy
                if self.valid(new_x, new_y, n) and dist_grid[new_x][new_y] == float('inf'):
                    dist_grid[new_x][new_y] = dist_grid[x][y] + 1
                    q.append((new_x, new_y))

        return dist_grid

    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if grid[n - 1][n - 1] == 1 or grid[0][0] == 1:
            return 0

        dist = self.compute_distance_grid(grid)
        pq = []
        vis = [[0] * n for _ in range(n)]

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        heapq.heappush(pq, (-dist[0][0], 0, 0))
        vis[0][0] = 1

        while pq:
            ds, i, j = heapq.heappop(pq)
            ds = -ds

            if i == n - 1 and j == n - 1:
                return ds

            for dx, dy in directions:
                new_row, new_col = i + dx, j + dy
                if self.valid(new_row, new_col, n) and grid[new_row][new_col] != 1 and not vis[new_row][new_col]:
                    vis[new_row][new_col] = 1
                    new_ds = dist[new_row][new_col]
                    heapq.heappush(pq, (-min(ds, new_ds), new_row, new_col))

        return 0