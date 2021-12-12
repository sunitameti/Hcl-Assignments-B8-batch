package com.xworkz.mobile.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "mobile_table")
@NamedQuery(name = "readAll", query = "from MobileEntity")
@NamedQuery(name = "readPriceByName", query = "select price from MobileEntity where name=:Name")
@NamedQuery(name = "readMaxPrice", query = "select max(price) from MobileEntity")
@NamedQuery(name = "readMinPrice", query = "select min(price) from MobileEntity")
@NamedQuery(name = "readTotalPrice", query = "select sum(price) from MobileEntity ")
@NamedQuery(name = "updatePriceByName", query = "update MobileEntity mobile set mobile.price=:Price where mobile.name=:Name")
public class MobileEntity implements Serializable {

	@Column(name = "m_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "m_name")
	private String name;
	@Column(name = "m_color")
	private String color;
	@Column(name = "m_isAndroid")
	private boolean android;
	@Column(name = "m_price")
	private double price;

	public MobileEntity() {
		// TODO Auto-generated constructor stub
	}

	public MobileEntity(String name, String color, boolean android, double price) {
		super();
		this.name = name;
		this.color = color;
		this.android = android;
		this.price = price;
	}

	@Override
	public String toString() {
		return "MobileEntity [id=" + id + ", name=" + name + ", color=" + color + ", android=" + android + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MobileEntity other = (MobileEntity) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isAndroid() {
		return android;
	}

	public void setAndroid(boolean android) {
		this.android = android;
	}

	public double getprice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
