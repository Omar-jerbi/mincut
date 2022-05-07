package apaFritsch;

import java.util.Random;

public class MainMCMinCut {

	
	
	public static myGraph[] MCMinCut(myGraph g) {
		for(int i = g.NumNodes; i<2; i-- ) {
			//node random
			var rand = new Random();
			int rN = rand.nextInt(g.NumNodes);
			
			var arraySelez = g.NodesEdges.get(rN);
			
			//node raggiungibile random
			rand = new Random();
			int rN2 = 1 + rand.nextInt(arraySelez.size() - 1);
			var edge = arraySelez.get(rN2);
			
			//nuovo nodo
			String newTag = arraySelez.get(0).tag; 
			g.newNode(newTag.concat(edge.tag));
							
			
			//punto 2
			
		}
		
		
		
		
		return null;
	}
	
	
	public static void main(String[] args) {
		myGraph fritsch = new myGraph('I');
		
		fritsch.addEdge('A', 'B');
		fritsch.addEdge('A', 'C');
		fritsch.addEdge('A', 'D');
		fritsch.addEdge('A', 'E');
		fritsch.addEdge('A', 'F');
		
		fritsch.addEdge('B', 'A');
		fritsch.addEdge('B', 'C');
		fritsch.addEdge('B', 'D');
		fritsch.addEdge('B', 'G');
		fritsch.addEdge('B', 'I');
		
		fritsch.addEdge('C', 'A');
		fritsch.addEdge('C', 'B');
		fritsch.addEdge('C', 'F');
		fritsch.addEdge('C', 'H');
		fritsch.addEdge('C', 'I');
		
		fritsch.addEdge('D', 'A');
		fritsch.addEdge('D', 'B');
		fritsch.addEdge('D', 'E');
		fritsch.addEdge('D', 'G');
		
		fritsch.addEdge('E', 'A');
		fritsch.addEdge('E', 'D');
		fritsch.addEdge('E', 'F');
		fritsch.addEdge('E', 'G');
		fritsch.addEdge('E', 'H');
		
		fritsch.addEdge('F', 'A');
		fritsch.addEdge('F', 'C');
		fritsch.addEdge('F', 'E');
		fritsch.addEdge('F', 'H');
		
		fritsch.addEdge('G', 'B');
		fritsch.addEdge('G', 'D');
		fritsch.addEdge('G', 'E');
		fritsch.addEdge('G', 'H');
		fritsch.addEdge('G', 'I');
		
		fritsch.addEdge('H', 'C');
		fritsch.addEdge('H', 'I');
		fritsch.addEdge('H', 'F');
		fritsch.addEdge('H', 'D');
		fritsch.addEdge('H', 'G');

		fritsch.addEdge('I', 'B');
		fritsch.addEdge('I', 'C');
		fritsch.addEdge('I', 'G');
		Node x = fritsch.addEdge('I', 'H');
		
		
//		var res = MCMinCut(fritsch);
		
		fritsch.displayGraph();
		fritsch.removeNode(x);
		System.out.println();
		fritsch.displayGraph();
		
		
	}

}
