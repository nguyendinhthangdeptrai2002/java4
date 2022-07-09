package bai1;

import javax.naming.spi.DirStateFactory.Result;
import javax.sound.midi.Soundbank;

import org.junit.runner.JUnitCore;

public class Mainfunc {

	 public static void main(String[] args)throws Exception{
		 JUnitCore runner = new JUnitCore();
		 org.junit.runner.Result result = runner.run(MathFuncTest.class);
		 System.out.println("run tests:" + result.getRunCount());
		 System.out.println("failed tests:"+ result.getFailureCount());
		 System.out.println("ignored tests :" + result.getIgnoreCount());
		 System.out.println("success :"+result.wasSuccessful());
	 }
}
