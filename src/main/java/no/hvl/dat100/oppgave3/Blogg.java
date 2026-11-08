package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Tekst;

public class Blogg {

	// TODO: objektvariable
	Innlegg[] inleggtabell;
	int nesteledig;

	public Blogg() {
		this.inleggtabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.inleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return this.nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return this.inleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (Innlegg min_inlegg : this.inleggtabell) {
			if (min_inlegg.erLik(innlegg)) {
				return min_inlegg.getId();
			}
		}

		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (this.nesteledig == 0) {
			return true;
		}
		for (Innlegg min_inlegg : this.inleggtabell) {
			if (min_inlegg.erLik(innlegg)) {
				return true;
			}
		}

		return false;
	}

	public boolean ledigPlass() {
		return this.nesteledig < this.inleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			this.inleggtabell[this.nesteledig] = innlegg;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String result = "";
		result += this.nesteledig + "\n";
		for (Innlegg innlegg : this.inleggtabell) {
			result += innlegg.toString();
		}

		return result;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyListe = new Innlegg[this.inleggtabell.length*2];
		for (int i = 0; i < this.inleggtabell.length; i++) {
			nyListe[i] = this.inleggtabell[i];
		}

		this.inleggtabell = nyListe;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!ledigPlass()) {
			utvid();
		}
		if (!finnes(innlegg)) {
			leggTil(innlegg);
		}

		return true;
	}
	
	public boolean slett(Innlegg innlegg) {

		int i = 0;
		for (; i < this.inleggtabell.length; i++) {
			if (innlegg.erLik(this.inleggtabell[i])) {
				this.inleggtabell[i] = null;
				break;
			}
		}

		// Vi har lyst til å skifte alle elementene i resten av listen en til venstre
		for (; i < this.inleggtabell.length; i++) {
			this.inleggtabell[i] = this.inleggtabell[i+1];
		}

		this.nesteledig--;

		return true;
	}
	
	public int[] search(String keyword) {

		int[] result = new int[this.nesteledig];
		int i = 0;
		for (Innlegg innlegg : this.inleggtabell) {
			if (innlegg.getBruker().contains(keyword)) {
				result[i] = innlegg.getId();
			}
			else if (innlegg instanceof Tekst && ((Tekst) innlegg).getTekst().contains(keyword)) {
				result[i] = innlegg.getId();
			}
		}

		return result;
	}
}