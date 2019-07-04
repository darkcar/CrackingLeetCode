package leetcode.dfs;

import org.junit.jupiter.api.Test;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically.
 * 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * @author xwang
 *
 */
public class NumberOfIslands200 {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		
		for (int x = 0; x < m; x ++) {
			for (int y = 0; y < n; y ++) {
				if (grid[x][y] == '1') {
					helper(grid, x, y, m, n, count);
					count ++;
				}
			}
		}
		return count;
	}

	private void helper(char[][] grid, int i, int j, int m, int n, int count) {
		if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		helper(grid, i + 1, j, m, n, count);
		helper(grid, i - 1, j, m, n, count);
		helper(grid, i, j + 1, m, n, count);
		helper(grid, i, j - 1, m, n, count);
	}
	
	@Test
	public void test() {
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};
		int numIslands = numIslands(grid);
		System.out.println(numIslands);
	}
}
