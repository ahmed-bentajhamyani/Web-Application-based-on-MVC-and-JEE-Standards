package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

public class LigneCmd {
	private Long numLigne;
	private int qteCmd;
	private Long numCmd;
	private Long codeArt;

	public LigneCmd(Long numLigne, int qteCmd, Long numCmd, Long codeArt) {
		super();
		this.numLigne = numLigne;
		this.qteCmd = qteCmd;
		this.numCmd = numCmd;
		this.codeArt = codeArt;
	}

	public LigneCmd() {
		super();
	}

	public LigneCmd(int qteCmd, Long numCmd, Long codeArt) {
		super();
		this.qteCmd = qteCmd;
		this.numCmd = numCmd;
		this.codeArt = codeArt;
	}

	public Long getNumLigne() {
		return numLigne;
	}

	public void setNumLigne(Long numLigne) {
		this.numLigne = numLigne;
	}

	public int getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Long getNumCmd() {
		return numCmd;
	}

	public void setNumCmd(Long numCmd) {
		this.numCmd = numCmd;
	}

	public Long getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(Long codeArt) {
		this.codeArt = codeArt;
	}

}
