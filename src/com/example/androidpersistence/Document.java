package com.example.androidpersistence;

public class Document {

	
	public Document() {
		
	}
	private int id;
	private String nom;
	private byte[] image;
	private double positionx;
	private double positiony;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public double getPositionx() {
		return positionx;
	}
	public void setPositionx(double positionx) {
		this.positionx = positionx;
	}
	public double getPositiony() {
		return positiony;
	}
	public void setPositiony(double positiony) {
		this.positiony = positiony;
	}
	

}
