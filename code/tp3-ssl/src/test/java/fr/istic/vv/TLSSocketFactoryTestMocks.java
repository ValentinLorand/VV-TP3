package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
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
    verify(mockedSocket, never()).setEnabledProtocols(new String[0]);
    //Utilisation du mock
    mockedSocket.setEnabledProtocols(new String[0]); //=> doit faire echouer le test
    f.prepareSocket(mockedSocket);
  }
  
  @Test
  public void typical()  {
    TLSSocketFactory f = new TLSSocketFactory();
    //Creation du mock
    SSLSocket mockedSocket = mock(SSLSocket.class);
    //Setup du mock
    when(mockedSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
    when(mockedSocket.getEnabledProtocols()).thenReturn(new String[]{"SSLv3", "TLSv1"});
    // String[] result = new String[0];
    // Mockito.doCallRealMethod(assertTrue(Arrays.equals(result, new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }))).when(mockedSocket).setEnabledProtocols(result);
    //Utilisation du mock
    f.prepareSocket(mockedSocket);
  }
  
  private String[] shuffle(String[] in) { 
    List<String> list = new ArrayList<String>(Arrays.asList(in));
    Collections.shuffle(list);
    return list.toArray(new String[0]);
  }
}