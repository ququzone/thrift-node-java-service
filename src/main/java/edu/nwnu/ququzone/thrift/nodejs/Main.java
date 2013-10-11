package edu.nwnu.ququzone.thrift.nodejs;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Main service server.
 * 
 * @author Yang XuePing
 */
public class Main {

  public static void main(String[] args) {
    try {
      CalculatorHandler handler = new CalculatorHandler();
      Calculator.Processor<Calculator.Iface> processor = new Calculator.Processor<Calculator.Iface>(
          handler);
      TServerTransport serverTransport = new TServerSocket(9090);
      TServer server = new TSimpleServer(
          new Args(serverTransport).processor(processor));

      System.out.println("Starting the simple server...");
      server.serve();
    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }

}
