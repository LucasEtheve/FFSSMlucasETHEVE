
import FFSSM.Club;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import org.junit.Before;
import java.util.Calendar;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author letheve
 */
public class FFSSM_test {
    Plongeur p1;
    Plongeur p2;
    Moniteur m;
    Club c;
    Site s;
    
    @Before
    public void setUp() {
	p1 = new Plongeur("12 23 56 05", "Etheve", "Lucas", null, null, null);
        p2 = new Plongeur("12 23 56 05", "Durand", "Paul", null, null, null);
        m = new Moniteur("12 23 56 05", "Dupont", "Lucas", null, null, null,10);
        c = new Club(m, "Reunion", null);
        s = new Site("Reunion","Ermitage");
    }
    @Test
    public void testlicence_estValide(){
	Calendar delivrance = Calendar.getInstance();
	Licence l = new Licence(p1, "10", delivrance, 0, c);
 	assertTrue( l.estValide(delivrance) );
	Calendar DateNonValide = (Calendar) delivrance.clone();
        DateNonValide.add(Calendar.YEAR, 1);
        DateNonValide.add(Calendar.DAY_OF_YEAR, 1);           
	assertFalse( l.estValide(DateNonValide) );
    }
    @Test
    public void testPlongeeConforme(){
        Calendar delivrance1 = Calendar.getInstance();
        Calendar delivrance2 = Calendar.getInstance();
        delivrance2.add(Calendar.YEAR, -2);
        Licence l1 = new Licence(p1, "11", delivrance1, 0, c);
        Licence l2 = new Licence(p2, "12", delivrance2, 0, c);
        Plongee pl = new Plongee(s, m, delivrance1, 30, 3);
        p1.ajouteLicence(l1);
        p2.ajouteLicence(l2);
        pl.ajouteParticipant(p1);
        assertTrue(pl.estConforme());
        pl.ajouteParticipant(p2);
        assertFalse(pl.estConforme());
        c.organisePlongee(pl);
        assertFalse(c.plongeesNonConformes().contains(p2));
    }
    
}
