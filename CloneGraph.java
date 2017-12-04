package brian;

import java.util.*;

/**
 * Created by brian on 11/30/17.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class CloneGraph {
    public UndirectedGraphNode cloneGraphByBFS(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        while (!queue.isEmpty()) {
            UndirectedGraphNode currentNode = queue.poll();
            for (UndirectedGraphNode neighbor : currentNode.neighbors) {
                UndirectedGraphNode currentNodeCopy = map.get(currentNode);
                if (map.containsKey(neighbor)) {
                    UndirectedGraphNode neighborCopy = map.get(neighbor);
                    currentNodeCopy.neighbors.add(neighborCopy);
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    currentNodeCopy.neighbors.add(neighborCopy);
                    map.put(neighbor, neighborCopy);
                    queue.add(neighbor);
                }
            }
        }
        return nodeCopy;
    }

    public UndirectedGraphNode cloneGraphByDFS(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return DFS(node, map);
    }
    
    private UndirectedGraphNode DFS(UndirectedGraphNode node,
                                    Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            nodeCopy.neighbors.add(DFS(neighbor, map));
        }
        return nodeCopy;
    }
}
