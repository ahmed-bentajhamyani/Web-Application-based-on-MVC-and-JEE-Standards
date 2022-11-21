package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;


public class Article {
	private Long codeArt;
	private String nomArt;
	private String description;
	private float prixUnitaire;
	private int qteArt;

	public Article() {
		super();
	}

	public Article(Long codeArt, String nomArt, String description, float prixUnitaire, int qteArt) {
		super();
		this.codeArt = codeArt;
		this.nomArt = nomArt;
		this.description = description;
		this.prixUnitaire = prixUnitaire;
		this.qteArt = qteArt;
	}

	public Article(String nomArt, String description, float prixUnitaire, int qteArt) {
		super();
		this.nomArt = nomArt;
		this.description = description;
		this.prixUnitaire = prixUnitaire;
		this.qteArt = qteArt;
	}

	public Long getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(Long codeArt) {
		this.codeArt = codeArt;
	}

	public String getNomArt() {
		return nomArt;
	}

	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQteArt() {
		return qteArt;
	}

	public void setQteArt(int qteArt) {
		this.qteArt = qteArt;
	}
}
