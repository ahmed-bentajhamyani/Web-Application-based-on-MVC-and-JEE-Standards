package ma.fstt.entities;

import java.sql.Date;
import javax.enterprise.context.ApplicationScoped;

public class Commande {
	private Long numCmd;
	private Date dateCmd;
	private Long codeCli;

	public Commande() {
		super();
	}

	public Commande(Long numCmd, Date dateCmd, Long codeCli) {
		super();
		this.numCmd = numCmd;
		this.dateCmd = dateCmd;
		this.codeCli = codeCli;
	}

	public Commande(Date date, Long codeCli) {
		super();
		this.dateCmd = date;
		this.codeCli = codeCli;
	}

	public Long getNumCmd() {
		return numCmd;
	}

	public void setNumCmd(Long numCmd) {
		this.numCmd = numCmd;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Long getCodeCli() {
		return codeCli;
	}

	public void setCodeCli(Long codeCli) {
		this.codeCli = codeCli;
	}

}
