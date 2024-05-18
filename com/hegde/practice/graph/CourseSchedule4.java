package com.hegde.practice.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/course-schedule-iv/">
 * 1462. Course Schedule IV</a>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course ai first if you want to take course bi.
 * For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
 * Prerequisites can also be indirect. If course a is a prerequisite of course b,
 * and course b is a prerequisite of course c, then course a is a prerequisite of course c.
 * You are also given an array queries where queries[j] = [uj, vj].
 * For the jth query, you should answer whether course uj is a prerequisite of course vj or not.
 * Return a boolean array answer, where answer[j] is the answer to the jth query.
 */
public class CourseSchedule4 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] graph = new boolean[numCourses][numCourses];

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = true;
        }

        //Floyd-Warshall Algorithm to check if the node is reachable or not.
        for (int k = 0; k < numCourses; ++k) {
            for (int i = 0; i < numCourses; ++i) {
                for (int j = 0; j < numCourses; ++j) {
                    if (graph[i][k] && graph[k][j])
                        graph[i][j] = true;
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] query : queries) {
            ans.add(graph[query[0]][query[1]]);
        }
        return ans;
    }
}
