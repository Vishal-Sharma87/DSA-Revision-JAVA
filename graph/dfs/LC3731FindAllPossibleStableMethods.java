package graph.dfs;

// Created at: 06-August-2026
// Last revised at: 06-August-2026
// Link: https://leetcode.com/problems/find-missing-elements/description/

/*
Problem Description:
--------------------
Statement:
There are n methods represented as a directed graph where each invocation
[u, v] indicates that method u invokes method v.

Method k is identified as suspicious. Every method reachable from k also
becomes suspicious.

A suspicious group can only be removed if no non-suspicious method invokes
any suspicious method.

Return all remaining methods after the removal. If removal is impossible,
return every method.

Example:
Input:
n = ...
k = ...
invocations = ...

Output:
Remaining methods after applying the removal rule.

Constraints:
- Directed graph
- 0 <= method < n
- Graph may be disconnected
*/

/*
Approach 1: Brute Force

Idea:
For every method, repeatedly perform graph traversals to determine whether
it reaches the suspicious component.

Time Complexity:
O(V × (V + E))

Space Complexity:
O(V)

Drawbacks:
Repeated traversals make the solution inefficient for large graphs.
*/

/*
Approach 2: DFS on Reachability (Optimal)

Idea:
1. Run DFS from k to mark every suspicious method.
2. Traverse every remaining connected component.
3. If any edge enters the suspicious set, removal is invalid.
4. Otherwise, all visited non-suspicious methods form the answer.

Time Complexity:
O(V + E)

Space Complexity:
O(V)

Key Insight:
Instead of checking every suspicious node individually, verify whether any
safe component has an outgoing edge into the suspicious component.
*/

import java.util.*;

/*
Method to Solve:
----------------
1. Build the directed graph.
2. Mark every method reachable from k as suspicious.
3. Traverse every non-suspicious component.
4. If any component reaches a suspicious node, return all methods.
5. Otherwise return only the remaining non-suspicious methods.
*/

class LC3731FindAllPossibleStableMethods {

    private static final List<Integer> EMPTY = Collections.emptyList();

    /**
     * Marks every suspicious method.
     *
     * @param node       current method
     * @param suspicious suspicious marker array
     * @param graph      invocation graph
     * @return nothing
     */
    private void markSuspicious(int node,
            boolean[] suspicious,
            Map<Integer, List<Integer>> graph) {

        suspicious[node] = true;

        for (int next : graph.getOrDefault(node, EMPTY)) {
            if (!suspicious[next]) {
                markSuspicious(next, suspicious, graph);
            }
        }
    }

    /**
     * Traverses a safe component and checks whether it invokes a suspicious
     * method.
     *
     * @param node       current method
     * @param suspicious suspicious marker array
     * @param visited    visited array
     * @param graph      invocation graph
     * @param remaining  collected remaining methods
     * @return true if removal is impossible
     */
    private boolean exploreComponent(int node,
            boolean[] suspicious,
            boolean[] visited,
            Map<Integer, List<Integer>> graph,
            List<Integer> remaining) {

        visited[node] = true;
        remaining.add(node);

        for (int next : graph.getOrDefault(node, EMPTY)) {

            // safe method invokes suspicious method
            if (suspicious[next]) {
                return true;
            }

            if (!visited[next]) {
                if (exploreComponent(next, suspicious, visited, graph, remaining)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns the remaining methods after removing the suspicious component.
     *
     * @param n           number of methods
     * @param k           suspicious method
     * @param invocations directed edges
     * @return remaining methods
     */
    public List<Integer> remainingMethods(int n,
            int k,
            int[][] invocations) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        // build graph
        for (int[] edge : invocations) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>())
                    .add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];

        // mark suspicious methods
        markSuspicious(k, suspicious, graph);

        List<Integer> remaining = new ArrayList<>();
        boolean[] visited = new boolean[n];

        // explore every safe component
        for (int i = 0; i < n; i++) {

            if (!suspicious[i] && !visited[i]) {

                if (exploreComponent(i, suspicious, visited, graph, remaining)) {

                    remaining.clear();

                    for (int j = 0; j < n; j++) {
                        remaining.add(j);
                    }

                    return remaining;
                }
            }
        }

        return remaining;
    }
}

// Time Complexity: O(V + E)
// Space Complexity: O(V)