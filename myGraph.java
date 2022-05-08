
import java.util.ArrayList;

public class myGraph {
	
	private int NumNodes = 0;
	
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
	
	
	
	public int getNumEdges() {
		int res = 0;
		for(var x : NodesEdges) {
			res = res + (x.size()-1);
		}
		return res/2;
	}
	
	public int getNumNodes() {
		return NumNodes;
	}
	
	public Node addEdge(char from, char to) { //restituisce il nodo to
		var LNfrom = NodesEdges.get(from - 65);
		var LNto = NodesEdges.get(to - 65);
		
		LNto.get(0).inEdges++;
		
		
		LNfrom.add(LNto.get(0));
		return LNto.get(0);
		
	}
	
	
	
	public void addEdge(String from, String to) { //aggiunge arco in entrambe le direzioni
		int indiceFrom = 0;
		for(var x : NodesEdges) {
			if(x.get(0).tag.equals(from)) {
				break;
			}
			indiceFrom++;
		}
		
		int indiceTo= 0;
		for(var x : NodesEdges) {
			if(x.get(0).tag.equals(to)) {
				break;
			}
			indiceTo++;
		}
	
	
		NodesEdges.get(indiceFrom).add(NodesEdges.get(indiceTo).get(0));
		NodesEdges.get(indiceTo).add(NodesEdges.get(indiceFrom).get(0));

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
						i--;
					}
				}
			}
		}
		
		int x = 0;
		for(var Ln : NodesEdges) {
			if(Ln.get(0).tag.equals(n.tag)) {
				break;
			}else {
				x++;
			}
			
		}
		NodesEdges.remove(x);
		NumNodes--;
	}
}