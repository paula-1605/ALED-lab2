package es.upm.aled.lab2.kinematics;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {

	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	// Public method: returns the root of the position tree
	public static Node computePositions(Segment root, double originX, double originY) {
		// TODO: Implemente este método
		return computePositions(root, originX, originY,0.0); //el ángulo acumulado inicial es nulo
	}

	// Private helper method that implements the recursive algorithm
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) {
		// TODO: Implemente este método
		long startTime=System.nanoTime();
		accumulatedAngle+=link.getAngle(); //sumo al ángulo acumulado que tengo el ángulo del nuevo segmento
		double x= baseX + link.getLength()*Math.cos(accumulatedAngle); //calculo la coordenada x a partir de la fórmula dada
		double y= baseY + link.getLength()*Math.sin(accumulatedAngle); //calculo la coordenada y a partir de la fórmula dada
		Node node = new Node(x,y); //genero el nuevo nodo al que llego con las coordenadas calculadas previamente
		
		if(link.getChildren().isEmpty()) { //caso base, si el nodo creado no tiene hijos devuelvo el nodo
			long runningTime = System.nanoTime()- startTime;
			System.out.println("Tiempo de computePositions para un segmento con "
			+ link.getChildren().size() + " hijos: "
			+ runningTime + " nanosegundos");
			return node;
		}
		
		for(Segment child: link.getChildren()) //si tiene hijos, recorro todos los segmentos hijos 
			node.addChild(computePositions(child , x, y, accumulatedAngle)); //creo el nuevo nodo con sus caracterisitcas obtenidas tras la invocación del propio método y lo añado a la lsita de hijos
		
		long runningTime = System.nanoTime()- startTime;
		System.out.println("Tiempo de computePositions para un segmento con "
		+ link.getChildren().size() + " hijos: "
		+ runningTime + " nanosegundos");
		return node;
	}
	// este método genera una lista de nodos que leugo se representarán
}