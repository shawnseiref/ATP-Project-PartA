package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {

    protected HashSet<AState> evaluatedNodes;
    protected int evaluatedNodesCount;
    protected ArrayList<AState> neighbors;
    protected Solution solution;

    /**
     * get the number of nodes that the searching algorithm has been in their state
     * @return evaluatedNodesCount - the counter of the evaluated nodes
     */
    public int getNumberOfNodesEvaluated() {
        return evaluatedNodesCount;
    }

    /**
     *
     * @return
     */
    public  String getName(){
        return this.getClass().getSimpleName();
    }


}
