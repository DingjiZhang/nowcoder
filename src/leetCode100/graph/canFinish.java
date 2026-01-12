package leetCode100.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class canFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
         * 有向无环图的拓扑排序
         * 需要1.入度数组 2.邻接表：存储每门课的后续课程
         *1. 计算入度，构建邻接表
         *2.队列，储存入度为0
         *3.记录已完成课程数量
         *4.遍历队列，弹出课程，已完成课程+1，遍历该课程的后续课程，入度-1，若入度为0，加入队列
         * 5.已完成==总课程则true
         * */

        if (numCourses == 0 || prerequisites == null) return false;

        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // 计算入度，构建邻接表
        for (int[] p : prerequisites) {
            int course = p[0];
            int preCourse = p[1];
            inDegree[course]++;
            adjList.get(preCourse).add(course);
        }

        // 储存入度为0的课程队列
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        // 记录完成的课程数量
        int count = 0;
        while (!q.isEmpty()) {
            int selectedCourse = q.poll();
            count++;
            // 获取后续课程
            List<Integer> nextCourses = adjList.get(selectedCourse);
            for (int nextCourse : nextCourses) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) q.offer(nextCourse);
            }
        }
        return count == numCourses;
    }
}
