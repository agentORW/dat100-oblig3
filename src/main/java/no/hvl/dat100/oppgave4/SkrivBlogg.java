package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {
			FileWriter myWriter = new FileWriter(mappe+filnavn);
			myWriter.write(samling.toString());
			myWriter.close();  // must close manually
			System.out.println("Successfully wrote to the file.");
			return true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return false;
		}
	}
}
