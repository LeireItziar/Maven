package com.ipartek.formacion.leire.tipos;

public class Productos {
	private String nombre, descripcion, errores, id;
	//	private int id;
	private double precio;

	@Override
	public int hashCode() {
		int id2 = Integer.parseInt(id);
		return id2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		return true;
	}

	public Productos(String id, String nombre, String descripcion, double precio) {
		super();
		this.nombre = nombre;
		this.setDescripcion(descripcion);
		this.setId(id);
		this.setPrecio(precio);
	}

	@Override
	public String toString() {
		return "Producto [ID=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio= " + precio + "]";
	}

	public Productos() {
		super();

	}

	public String getErrores() {
		return errores;
	}

	public void setErrores(String errores) {
		this.errores = errores;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
