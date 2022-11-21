package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.LigneCmd;

public interface LigneCmdRepository {
	List<LigneCmd> listLigneCmds();

	LigneCmd trouverById(Long numLigne);

	void addLigneCmd(LigneCmd ligneCmd);

	void updateLigneCmd(LigneCmd ligneCmd);

	void deleteLigneCmd(LigneCmd ligneCmd);
}
