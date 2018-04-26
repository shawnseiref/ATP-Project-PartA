package algorithms.search;

import java.util.*;

public class BreathFirstSearch extends ASearchingAlgorithm {

    public BreathFirstSearch() {
        evaluatedNodes = new HashSet<>();
        evaluatedNodesCount = 1;
        neighbors = new ArrayList<>();
        solution = new Solution();
    }

    /**
     * BFS Algorithm to find shortest math from start to goal
     *
     * @param s
     * @return sulution
     */
    Solution solve(ISearchable s) {
        PriorityQueue<AState> pQueue = new PriorityQueue<>(new Comparator<AState>() {
            @Override
            public int compare(AState state, AState t1) {
                return 0;
            }
        });
        pQueue.add(s.getStartingState());
        while (!pQueue.isEmpty()) {
            AState currState = pQueue.poll();
            evaluatedNodes.add(currState);
            if (currState.getState().equals(s.getEndingState())) { //check if the state is the GoalState
                solution.backTrace(currState);
                return solution;
            }
            neighbors = s.getAllPossibleStates(currState);
            for (AState state
                    : neighbors) {
                if (!pQueue.contains(state) && !evaluatedNodes.contains(state)){
                    state.setPrev(currState);
                    pQueue.add(state);
                    evaluatedNodesCount++;
                }
            }
        }
        return null; //No possible way to GoalState
    }
}
