class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create a list of list to build the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        // create a int[] to store numbers of incoming edges for a course
        int[] indegree = new int[numCourses];
        // traverse through prerequisites
        for (int[] pre: prerequisites){
            // edge ++
            indegree[pre[0]]++;
            // store the dependency
            adj.get(pre[1]).add(pre[0]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // build the solution queue
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while( !queue.isEmpty()){
            int cur = queue.poll();
            count++;
            for (int nei: adj.get(cur)){
                // remove dependency after visit
                indegree[nei]--;
                if (indegree[nei] == 0){
                    queue.add(nei);
                }
            }
        }
        return numCourses == count;
    }
}
