package pkg_set;

import java.util.HashSet;
import java.util.Set;

public class Run {
	public static void main(String[] args) {
		
		Set<Song> songSet1 = new HashSet<Song>();
		songSet1.add(new Song("SPOT!","지코"));
		songSet1.add(new Song("Magnetic","아일릿"));
		songSet1.add(new Song("밤양갱","비비"));
		Set<Song> songSet2 = new HashSet<Song>();
		songSet2.add(new Song("Magnetic","아일릿"));
		songSet2.add(new Song("고민중독","OWER"));
		songSet2.add(new Song("고민중독","OWER"));
		
		System.out.println(songSet1);
		System.out.println(songSet2);
	}
}
