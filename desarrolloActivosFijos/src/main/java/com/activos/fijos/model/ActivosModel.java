package com.activos.fijos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "activos")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "fecha_compra", "fecha_baja" }, allowGetters = true)
public class ActivosModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long serial_activos;

	@Column(name = "nombre", nullable = false, length = 150)
	private String nombre;

	@Column(name = "descripcion", length = 200)
	private String descripcion;

	@Column(name = "tipo", length = 150)
	private String tipo;

	@Column(name = "numero_interno_inventario", nullable = false, length = 200)
	private String numero_interno_inventario;

	@Column(name = "peso")
	private float peso;

	@Column(name = "alto")
	private float alto;

	@Column(name = "ancho")
	private float ancho;

	@Column(name = "largo")
	private float largo;

	@Column(name = "valor_compra")
	private float valor_compra;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_compra")
	private Date fecha_compra;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_baja")
	private Date fecha_baja;

	@Column(name = "estado_actual", length = 50)
	private String estado_actual;

	@Column(name = "color",length = 100)
	private String color;

	@Column(name = "area",length = 150)
	private String area;

	/* Setters and Getters */
	public String getNombre() {
		return nombre;
	}

	public Long getSerial_activos() {
		return serial_activos;
	}

	public void setSerial_activos(Long serial_activos) {
		this.serial_activos = serial_activos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero_interno_inventario() {
		return numero_interno_inventario;
	}

	public void setNumero_interno_inventario(String numero_interno_inventario) {
		this.numero_interno_inventario = numero_interno_inventario;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAlto() {
		return alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public float getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(float valor_compra) {
		this.valor_compra = valor_compra;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public String getEstado_actual() {
		return estado_actual;
	}

	public void setEstado_actual(String estado_actual) {
		this.estado_actual = estado_actual;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ActivosModel [serial_activos=" + serial_activos + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", tipo=" + tipo + ", numero_interno_inventario=" + numero_interno_inventario + ", peso=" + peso
				+ ", alto=" + alto + ", ancho=" + ancho + ", largo=" + largo + ", valor_compra=" + valor_compra
				+ ", fecha_compra=" + fecha_compra + ", fecha_baja=" + fecha_baja + ", estado_actual=" + estado_actual
				+ ", color=" + color + ", area=" + area + "]";
	}

}
