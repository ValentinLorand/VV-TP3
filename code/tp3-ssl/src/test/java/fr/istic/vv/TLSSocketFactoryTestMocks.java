package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TLSSocketFactoryTestMocks {
  
  @Test
  public void preparedSocket_NullProtocols()  {
    TLSSocketFactory f = new TLSSocketFactory();
    //Creation du mock
    SSLSocket mockedSocket = mock(SSLSocket.class);
    //Setup du mock
    when(mockedSocket.getSupportedProtocols()).thenReturn(null);
    when(mockedSocket.getEnabledProtocols()).thenReturn(null);
    
    //Utilisation du mock
    // mockedSocket.setEnabledProtocols(new String[0]); //=> fait echouer le test
    f.prepareSocket(mockedSocket);

    //Verifications
    Mockito.verify(mockedSocket, Mockito.times(0)).setEnabledProtocols(any(String[].class));
  }
  
  @Test
  public void typical()  {
    TLSSocketFactory f = new TLSSocketFactory();
    //Creation du mock
    SSLSocket mockedSocket = mock(SSLSocket.class);
    //Setup du mock
    when(mockedSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
    when(mockedSocket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));

    //Utilisation du mock
    f.prepareSocket(mockedSocket);

    //Verifications
    final ArgumentCaptor<String[]> captor = ArgumentCaptor.forClass(String[].class);
    Mockito.verify(mockedSocket, Mockito.times(1)).setEnabledProtocols(captor.capture());
    assertTrue(Arrays.equals(captor.getValue(), new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }));
  }
  
  private String[] shuffle(String[] in) { 
    List<String> list = new ArrayList<String>(Arrays.asList(in));
    Collections.shuffle(list);
    return list.toArray(new String[0]);
  }
}