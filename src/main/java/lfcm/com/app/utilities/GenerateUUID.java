package lfcm.com.app.utilities;


import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class GenerateUUID {
  
  public UUID getUUID(){
    //generate random UUIDs
    return UUID.randomUUID();
    
  }
  
} 
