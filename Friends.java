package friends;

import structures.Queue;
import structures.Stack;

import java.util.*;

public class Friends {

	/**
	 * Finds the shortest chain of people from p1 to p2.
	 * Chain is returned as a sequence of names starting with p1,
	 * and ending with p2. Each pair (n1,n2) of consecutive names in
	 * the returned chain is an edge in the graph.
	 * 
	 * @param g Graph for which shortest chain is to be found.
	 * @param p1 Person with whom the chain originates
	 * @param p2 Person at whom the chain terminates
	 * @return The shortest chain from p1 to p2. Null if there is no
	 *         path from p1 to p2
	 */
	public static ArrayList<String> shortestChain(Graph g, String p1, String p2) {

		Person first = g.members[g.map.get(p1)];
		Person last = g.members[g.map.get(p2)];


		ArrayList<String> chain = new ArrayList<String>();
		Queue<Person> q = new Queue<>();
		boolean [] visited = new boolean [g.members.length];
		int [] prevVisit = new int [g.members.length];



		//initializing 
		for(int i = 0; i < visited.length; i++) {
			prevVisit[i] = -1;
		}


		q.enqueue(first);
		while(!q.isEmpty()) {
			Person current = q.dequeue();
			int idx = g.map.get(current.name);

			if(current==last) {
				break;
			}

			else {
				visited[idx]=true;
				Friend ptr = g.members[idx].first;

				//BFS search
				while(ptr!=null) {
					if(prevVisit[ptr.fnum]==-1) {
						prevVisit[ptr.fnum]=idx;
						q.enqueue(g.members[ptr.fnum]);
					}
					ptr=ptr.next;

				}
			}
		}


		Stack<String> stack = new Stack<>();
		stack.push(last.name);
		int finalIdx = g.map.get(last.name);
		int prevIdx = prevVisit[finalIdx];
		stack.push(last.name);

		while(prevIdx!=-1) {
			stack.push(g.members[prevIdx].name);
			prevIdx = prevVisit[prevIdx];
		}

		ArrayList<String> finalArr = new ArrayList<>();
		while(!stack.isEmpty()) {
			finalArr.add(stack.pop());
		}

		return finalArr;



	}


	/**
	 * Finds all cliques of students in a given school.
	 * 
	 * Returns an array list of array lists - each constituent array list contains
	 * the names of all students in a clique.
	 * 
	 * @param g Graph for which cliques are to be found.
	 * @param school Name of school
	 * @return Array list of clique array lists. Null if there is no student in the
	 *         given school
	 */
	public static ArrayList<ArrayList<String>> cliques(Graph g, String school) {

		boolean [] visited = new boolean [g.members.length];
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();

		for(int i=0; i<g.members.length; i++) {
			ArrayList<String> temp = new ArrayList<String>();
			Person curr = g.members[i];
			int currIdx = g.map.get(curr.name);
			if(!visited[currIdx]) {
				if(curr.school.equals(school)) {
					dfsClique(g, school, curr, visited, temp);
					arr.add(temp);
				}
			}
		}
		return arr;
	}

	private static void dfsClique(Graph g, String school, Person p, boolean [] visited, ArrayList<String> a) {
		

	}




	/**
	 * Finds and returns all connectors in the graph.
	 * 
	 * @param g Graph for which connectors needs to be found.
	 * @return Names of all connectors. Null if there are no connectors.
	 */
	public static ArrayList<String> connectors(Graph g) {

		/** COMPLETE THIS METHOD **/

		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE COMPILER HAPPY
		// CHANGE AS REQUIRED FOR YOUR IMPLEMENTATION
		return null;

	}

	private void dfsConnectors(int v, boolean[] visited) {
		visited[v] = true;


	}

}

