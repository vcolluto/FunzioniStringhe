import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// .trim()					: rimuove gli spazi in eccesso all'inizio e alla fine
		// .toLowerCase()			: converte in minuscolo
		// .toUpperCase()			: converte in maiuscolo
		// .startsWith("x")			: restituisce vero se la stringa inizia per "x" 
		// .equalsIgnoreCase(s1)	: restituisce vero se la stringa è uguale alla stringa s1 (ignorando maiuscole/minuscole)
		// .contains(s1)			: restituisce vero se la stringa contiene s1
		// .charAt(pos)				: restituisce il singolo carattere nella posizione pos
		// .subString(pos)			: restituisce la sottostringa a partire dalla posizione pos
		// .subString(pos1,pos2)	: restituisce la sottostringa a partire dalla posizione pos1 fino alla pos2 (esclusa)
		// .indexOf(s1)				: restituisce la prima posizione della string s1 all'interno della stringa (se esiste), altrimenti -1		
		// .lastIndexOf(s1)			: restituisce l'ultima posizione della string s1 all'interno della stringa (se esiste), altrimenti -1		
		// .repeat(N)				: restituisce la stringa ripetuta N volte
		// .split(c)				: costruisce un array di stringhe dividendo la stringa originale in pezzi ogni volta che si incontra il carattere c
		Scanner sc=new Scanner(System.in);
		String scelta, risposta;
		HashMap<String,Integer> Candidati=new HashMap<>() {
			{
				put("Mario Rossi",0);
				put("Franco Gialli",0);
				put("Pino Verdi",0);
				put("Gino Marroni",0);
				put("Lino Bianchi",0);
		}};
		String r="abc";
		
		System.out.println(r.repeat(30));
		String messaggio="Grazie e arrivederci";
	    
		System.out.println("MESSAGGIO ORIGINALE:");
		System.out.println(messaggio);
		
		System.out.println("\nDALLA POSIZIONE 9:");	//arrivederci
		System.out.println(messaggio.substring(9));
		
		System.out.println("\nDALLA POSIZIONE 9 ALLA 12:");	//arr
		System.out.println(messaggio.substring(9,12));
		
		System.out.println("\nSOLO POSIZIONI PARI:");
		for(int i=0;i<messaggio.length();i++)
			if (i%2==0)
				System.out.print(messaggio.charAt(i));	
		
		System.out.println("\nSOSTITUISCO e CON o:");
		System.out.println(messaggio.replace("e", "o"));
					
		System.out.println("SPLIT");
		String[] parole=messaggio.split(" ");
		for(String p:parole)
			System.out.println(p);
		String inverted="";
		System.out.println("\n\nINVERTED:");
		//inverto la stringa messaggio
		for(int i=0;i<messaggio.length();i++)			//per ogni carattere della stringa messaggio
			inverted+=messaggio.charAt(messaggio.length()-1-i);	
		System.out.println(inverted);
		
		System.out.print("\nCosa vuoi cercare all'interno del messaggio?");
		String cerca=sc.nextLine();
		int pos=messaggio.lastIndexOf(cerca);
		if(pos>=0)		//esiste all'interno della stringa
			System.out.println("Trovato in posizione "+pos);
		else
			System.out.println("Non trovato! pos="+pos);
		
		
		System.out.print("Inserisci il tuo nome: ");
		String nome=sc.nextLine();
		/*nome=	(nome.charAt(0)+"").toUpperCase()	//prende il primo carattere (nome.charAt(0)) e lo converte in stringa (+"")
				+nome.substring(1);					//aggiunge la sottostringa a partire dalla posizione 1
		*/
		nome=nome.substring(0,1).toUpperCase()+nome.substring(1);
		
		System.out.println("Benvenuto "+nome+ ". I candidati sono:");
		
		System.out.println("Inserisci una chiave di ricerca per i candidati");
		String ricerca=sc.nextLine();
		for (String v:Candidati.keySet())
			if (v.contains(ricerca))
				System.out.println(v);
		do {
			System.out.println("Quale candidato scegli?");
			scelta=sc.nextLine().trim();	//elimina gli spazi in eccesso all'inizio e alla fine della stringa	
			if (Candidati.containsKey(scelta))    // se il nome inserito viene verificato, viene aggiunto all'HashMap
				Candidati.put(scelta, Candidati.get(scelta)+1);
			else 
				System.out.println("Il candidato non esiste");
			System.out.println("vuoi inserire un altro voto (s/n)?");
			risposta=sc.nextLine();
				
			} while (risposta.equalsIgnoreCase("s") || risposta.equalsIgnoreCase("sì") );		//risposta.toLowerCase().equals("s")
	
		System.out.println("Risultato votazioni: ");
		for (String v:Candidati.keySet())
			System.out.println(v+"- "+Candidati.get(v));
		
		
		
		
		

	}

}
