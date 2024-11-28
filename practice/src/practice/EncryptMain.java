package practice;

import java.util.UUID;

public class EncryptMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
	  for(int i=0; i<10; i++) {		  
		  String uuid = UUID.randomUUID().toString();
		  System.out.println(uuid);
	  }
   }

}

