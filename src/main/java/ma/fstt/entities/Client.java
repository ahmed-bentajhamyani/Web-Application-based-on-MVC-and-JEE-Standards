package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

public class Client {
	private Long codeCli;
	private String nomCli;
	private String prenomCli;
	private String teleCli;
	private String adresseCli;

	public Client() {
		super();
	}

	public Client(Long codeCli, String nomCli, String prenomCli, String teleCli, String adresseCli) {
		super();
		this.codeCli = codeCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.teleCli = teleCli;
		this.adresseCli = adresseCli;
	}

	public Client(String nomCli, String prenomCli, String teleCli, String adresseCli) {
		super();
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.teleCli = teleCli;
		this.adresseCli = adresseCli;
	}

	public Long getCodeCli() {
		return codeCli;
	}

	public void setCodeCli(Long codeCli) {
		this.codeCli = codeCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getPrenomCli() {
		return prenomCli;
	}

	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}

	public String getTeleCli() {
		return teleCli;
	}

	public void setTeleCli(String teleCli) {
		this.teleCli = teleCli;
	}

	public String getAdresseCli() {
		return adresseCli;
	}

	public void setAdresseCli(String adresseCli) {
		this.adresseCli = adresseCli;
	}

}
