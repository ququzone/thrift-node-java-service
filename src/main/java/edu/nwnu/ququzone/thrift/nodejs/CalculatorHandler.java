package edu.nwnu.ququzone.thrift.nodejs;

import org.apache.thrift.TException;

/**
 * Service handler.
 * 
 * @author Yang XuePing
 */
public class CalculatorHandler implements Calculator.Iface {

  @Override
  public Work add(Work work) throws TException {
    work.setNum1(work.getNum1() + 1);
    work.setNum2(100);
    work.setComment("yes, changed!");
    return work;
  }
}
