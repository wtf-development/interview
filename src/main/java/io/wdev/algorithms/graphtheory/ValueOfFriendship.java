package io.wdev.algorithms.graphtheory;

import java.util.*;

public class ValueOfFriendship {

    static class Graph {
        private List<Set<Integer>> vertexGroups;

        public Graph() {
            vertexGroups = new ArrayList<>();
        }

        public void putEdge(int v0, int v1) {
            Set<Integer> mergeGroups = new HashSet<>();
            for (int i=0; i<vertexGroups.size(); i++) {
                Set<Integer> group = vertexGroups.get(i);
                if (group != null && (group.contains(v0) || group.contains(v1))) {
                    mergeGroups.add(i);
                }
            }
            if (mergeGroups.isEmpty() ) {
                vertexGroups.add(new HashSet<>(Arrays.asList(v0, v1)));
            } else if (mergeGroups.size() == 1) {
                vertexGroups.get(mergeGroups.iterator().next()).addAll(Arrays.asList(v0, v1));
            } else {
                Iterator<Integer> it = mergeGroups.iterator();
                int head = it.next();
                vertexGroups.get(head);
                while(it.hasNext()) {
                    int i = it.next();
                    vertexGroups.get(head).addAll(vertexGroups.get(i));
                    vertexGroups.remove(i);
                }
            }
        }

        private int getVertexPowerSum() {
            final int[] count = {0};
            vertexGroups.stream().forEach(e -> {
                int n = e.size();
                count[0] += n*(n-1);
            });
            return count[0];
        }
    }


    /*
     * Complete the valueOfFriendsship function below.
     */
    static int valueOfFriendsship(int n, int[][] friendships) {
        /*
         * Write your code here.
         */
        int sum = 0;
        Graph graph = new Graph();
        for(int[] arr: friendships) {
            graph.putEdge(arr[0], arr[1]);
            sum+=graph.getVertexPowerSum();
        }

        return sum;
    }
}
