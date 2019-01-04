# Friends
Creates a friendship graph (e.g. Facebook)

A friendship graph is an undirected graph without any weights on the edges. It is a simple graph because there are no self loops (a self loop is an edge from a vertex to itself), or multiple edges (a multiple edge means more than edge between a pair of vertices).

The vertices in the graphs for this assignment represent two kinds of people: students and non-students. Each vertex will store the name of the person. If the person is a student, the name of the school will also be stored.

Here's a sample friendship graph:

     (sam,rutgers)---(jane,rutgers)-----(bob,rutgers)   (sergei,rutgers)
                          |                 |             |
                          |                 |             |
                     (kaitlin,rutgers)   (samir)----(aparna,rutgers)
 


                   (michele,cornell)----(rachel)     
                          | 
                          | 
     (rich,ucla)---(tom,ucla)
     
Note that the graph may not be connected, as seen in this example in which there are two "islands" or cliques that are not connected to each other by any edge. Also see that all the vertices represent students with names of schools, except for rachel and samir, who are not students.
