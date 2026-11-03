class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        // build indegree count
        int[] indegree = new int[numCourses];
        for (int[] pre: prerequisites){
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        // build a queue
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.add (i);
            }
        }
        // traverse the queue to see if there is a circle
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res.add(cur);
            for (int nei: adj.get(cur)){
                indegree[nei]--;
                if (indegree[nei] == 0){
                    queue.add(nei);
                }

            }
        }
        if (res.size() == numCourses){
            int[] solution = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                solution[i] = res.get(i);
            }
            return solution;
        } else {
            return new int[]{};
        }
        
    }
    }

