package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

// TODO: Implemente la clase
/**
 * La clase segment representa el segmento que une un nodo con otro 
 * conectando así las diferentes partes del exoesqueleto.
 */
public class Segment {
	private double length;
	private double angle;
	private List<Segment>children;
	
	/**
	 * Constructor de un segmento al que se le pasan dos atributos, la
	 * longitud y el ángulo. Dentro se inicializa la lista children
	 * @param length longitud del segmento
	 * @param angle ángulo del segmento
	 */
	public Segment (double length, double angle) {
		this.length=length;
		this.angle=angle;
		this.children=new ArrayList<Segment>();
	}
	/**
	 * Devuelve el ángulo del segmento
	 * @return devuelve el ángulo del segmento
	 */
	public double getAngle() {
		return angle;
	}
	/**
	 * modifica y establece el nuevo ángulo del segmento
	 * @param angle nuevo ángulo del segmento
	 */
	public void setAngle(double angle) {
		this.angle=angle;
	}
	/**
	 * devuelve la longitud del segmento
	 * @return longitud del segmento
	 */
	public double getLength() {
		return length;
	}
	/**
	 * devuelve la lista que contiene a los segmentos  hijos
	 * @return lista con los segmentos hijos
	 */
	public List<Segment> getChildren(){
		return children;
	}
	
	/**
	 * añade un hijo en la lista de segmentos si aún no está
	 * @param child segmento hijo que se añadirá o no a la lista
	 * de hijos
	 */
	public void addChild(Segment child) {
		if(!children.contains(child))
				children.add(child);
	}
	
}
