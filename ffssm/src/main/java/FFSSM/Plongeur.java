package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne {
	public GroupeSanguin groupe;
        public int niveau;
        private List<Licence> licencesDuPlongeur = new LinkedList<>();

        public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        }
        public void ajouteLicence(Licence l) {
            licencesDuPlongeur.add(l);
        }
        public Licence dernierelicence(){
            if (! licencesDuPlongeur.isEmpty()){
                int size = licencesDuPlongeur.size();
                return licencesDuPlongeur.get(size - 1);
            }
            else{
                return null;
            }
        }
        
	public GroupeSanguin getGroupe() {
		return groupe;
        }
        public void setGroupe(GroupeSanguin groupe) {
            this.groupe = groupe;
	}
        public int getNiveau() {
            return niveau;
	}
        public void setNiveau(int niveau) {
            this.niveau = niveau;
	}
        
}
