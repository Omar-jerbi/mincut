
import java.util.Random;

public class MainMCMinCut {

	//si presuppone che i nodi siano univocamente identificati tramite il campo Tag (Stringa di 1 o piu' caratteri)
	
	//il grafo è implementato tramite una linked list di linked list dove l'elemento 0 di ogni linked list è il nodo vertice, gli elementi successivi sodo i nodi ad esso collegati
	
	
	public static myGraph MCMinCut(myGraph g) {
		for(int i = g.getNumNodes(); i>2; i-- ) {
			//vertice U random
			var rand = new Random();
			int rN = rand.nextInt(g.getNumNodes());
			var arraySelez = g.NodesEdges.get(rN);
			var U = arraySelez.get(0);
			
			//node raggiungibile da U random  => ottengo cosi l'arco U,V
			rand = new Random();
			int rN2 = 1 + rand.nextInt(arraySelez.size() - 1);
			var V = arraySelez.get(rN2);
			
			
			//nuovo vertice UV
			String newTag = (U.tag).concat(V.tag); 
			g.newNode(newTag);
							
			
			//aggiungo ad UV gli archi di U
			for(var arco : arraySelez) {
				if(!arco.tag.equals(U.tag) && !arco.tag.equals(V.tag)) {//salto lo 0  e il nodo V
					g.addEdge(newTag, arco.tag);
				}
			}
			
			
			//aggiungo ad UV gli archi di V
			for(var nodoL : g.NodesEdges) {
				if(nodoL.get(0).tag.equals(V.tag)) {
					for(int j = 1; j<nodoL.size(); j++) {
						if(!nodoL.get(j).tag.equals(U.tag)) {//non aggiungo U alla lista di nodi collegati ad UV
							g.addEdge(newTag, nodoL.get(j).tag);							
						}
					}
				}
			}

			
			//punto 2
			//rimozione vertici u e v (removeNode(nodo) rimuove anche tutti gli archi del nodo selezionato)
			g.removeNode(U);
			g.removeNode(V);
			

//			System.out.println("---------------------------");
//			System.out.println(newTag);
//			System.out.println(g.getNumNodes());
//			System.out.println(g.getNumEdges());
//			System.out.println("***");
//			g.displayGraph();
//			System.out.println("***");
//			System.out.println("---------------------------");
		}
		

		return g;
	}
	
	
	public static void main(String[] args) {
		
		int N = 100;
		
		int[] RESULTS = new int[N];
		
		for(int i = 0; i<N; i++) {	
			myGraph fritsch = new myGraph('I');//da "A" ad "i (maiusc)"
	
			//////////////////////////////////////////////////////////////////////////////////////////////////////////
			fritsch.addEdge("A", "B");
			fritsch.addEdge("A", "C");
			fritsch.addEdge("A", "D");
			fritsch.addEdge("A", "E");
			fritsch.addEdge("A", "F");
	
			fritsch.addEdge("B", "C");
			fritsch.addEdge("B", "D");
			fritsch.addEdge("B", "G");
			fritsch.addEdge("B", "I");
	
			fritsch.addEdge("C", "F");
			fritsch.addEdge("C", "H");
			fritsch.addEdge("C", "I");
	
			fritsch.addEdge("D", "E");
			fritsch.addEdge("D", "G");
	
			fritsch.addEdge("E", "F");
			fritsch.addEdge("E", "G");
			fritsch.addEdge("E", "H");
	
			fritsch.addEdge("F", "H");
			
			fritsch.addEdge("G", "H");
			fritsch.addEdge("G", "I");
	
			fritsch.addEdge("H", "I");
	
			//		fritsch.displayGraph();
			//		System.out.println();
			//		System.out.println();
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////
			
	
			
			var res =MCMinCut(fritsch);
	//		res.displayGraph();
	//		System.out.println(res.getNumEdges());
			
			RESULTS[i] = res.getNumEdges();
		}

		for(var x : RESULTS) {
			System.out.print(x + " ");
		}
		
		
	}//main

}
