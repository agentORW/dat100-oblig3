package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

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
		throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}