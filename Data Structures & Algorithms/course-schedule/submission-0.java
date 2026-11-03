class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indgrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites ){
            indgrees[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indgrees[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while( !queue.isEmpty()){
            int cur = queue.poll();
            count++;
            for (int nei: adj.get(cur)){
                indgrees[nei]--;
                if(indgrees[nei] == 0){
                    queue.add(nei);
                }

            }
        }
        return count == numCourses;
        
    }
}
