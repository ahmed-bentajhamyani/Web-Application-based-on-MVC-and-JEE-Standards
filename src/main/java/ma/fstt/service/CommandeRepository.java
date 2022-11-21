package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.Commande;

public interface CommandeRepository {

	List<Commande> listCommandes();

	Commande trouverById(Long numCmd);

	void addCommande(Commande commande);

	void updateCommande(Commande commande);

	void deleteCommande(Commande commande);
}
