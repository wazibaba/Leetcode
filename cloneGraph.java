
leetcode.com
http://fisherlei.blogspot.com/

http://www.cnblogs.com/springfor/p/3874591.html


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 * 
 * 
 * 
 *     1                  1
      / \
     /   \
    0 --- 2         2          0
         / \        |
         \_/        2
         
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // level order travelsal; using a stack so that mirror in each level;
        // using a HashMap to keep mirror of the node whether or not have been copie;
        // how abou the neighborhood relationship; just reverse adding to the mirrored node;
        if(node == null) return null;
        Queue queue = new LinkedList(); 
        HashMap<UndirectedGraphNode, UndirectedGraphNode> node_mapping = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode node_clone = new UndirectedGraphNode(node.label);
        node_mapping.put(node, node_clone);
        while(queue.size() > 0) {
            UndirectedGraphNode top = (UndirectedGraphNode)queue.poll();
            for(int i = 0; i < top.neighbors.size(); i++)
            {
                UndirectedGraphNode tmp = (UndirectedGraphNode)top.neighbors.get(i);

                if(node_mapping.containsKey(tmp)) {
                    node_mapping.get(top).neighbors.add(node_mapping.get(tmp));
                }
                else {
                    UndirectedGraphNode tmp_clone = new UndirectedGraphNode(tmp.label);
                    node_mapping.put(tmp, tmp_clone);
                    node_mapping.get(top).neighbors.add(tmp_clone);
                    queue.add(tmp);
                }
                
            }
        }
        
        return node_clone;
    }
}



//for above BFS, change queue to Stack -> DFS visit graph;


//following are DFS using recursion:
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
            
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        
        DFS(hm, node);//DFS
        return head;
    }

    
    public void DFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hm, UndirectedGraphNode node){
        if(node == null)
            return;
            
        for(UndirectedGraphNode aneighbor: node.neighbors){ 
            if(!hm.containsKey(aneighbor)){
                UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
                hm.put(aneighbor, newneighbor);
                DFS(hm, aneighbor);//DFS
            }
            hm.get(node).neighbors.add(hm.get(aneighbor));
        }
    }





