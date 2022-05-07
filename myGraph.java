package apaFritsch;

import java.util.ArrayList;

public class myGraph {
	
	public int NumNodes = 0;
	public int NumEdges = 0;
	
	public ArrayList<ArrayList<Node>> NodesEdges = null;
	
	public myGraph() {
		NodesEdges = new ArrayList<ArrayList<Node>>();
	}
	
	public myGraph(char fine) {
		NodesEdges = new ArrayList<ArrayList<Node>>();
		
		for(char c = 'A'; c <= fine ; c++ ) {
			var auxE = new ArrayList<Node>();
			auxE.add(new Node(String.valueOf(c)));
			
			NumNodes++;
			NodesEdges.add(auxE);
		}
	}
	
	public Node addEdge(char from, char to) {
		var LNfrom = NodesEdges.get(from - 65);
		var LNto = NodesEdges.get(to - 65);
		
		LNto.get(0).inEdges++;
		
		NumEdges++;
		
		LNfrom.add(LNto.get(0));
		return LNto.get(0);
		
	}
	
	public void displayGraph() {
		for(var lN : NodesEdges) {
			for(var E : lN) {
				System.out.print(E.tag + " ");
			}
			System.out.println();
		}
	}
	
	
	public void newNode(String tag) {
		var auxE = new ArrayList<Node>();
		auxE.add(new Node(tag));
		
		NumNodes++;
		NodesEdges.add(auxE);
	}
	
	
	
	public void removeNode(Node n) {
		for(var Ln : NodesEdges) {
			if(!Ln.get(0).tag.equals(n.tag)) {
				for(int i = 1; i<Ln.size(); i++) {
					if(Ln.get(i).tag.equals(n.tag)) {
						Ln.remove(i);
						NumEdges--;
					}
				}
			}
		}
		
		for(var Ln : NodesEdges) {
			if(Ln.get(0).tag.equals(n.tag)) {
				NodesEdges.remove(Ln);
			}
		}
		
		NumEdges--;
	}
}