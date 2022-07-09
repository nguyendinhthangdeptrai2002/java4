package test;

import static org.junit.Assert.assertEquals;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.omg.CORBA.PUBLIC_MEMBER;

public class TestJunit {
@Test
public void testsetup() {
	String string ="xin chao anh thang";
	assertEquals("xin chao anh thang", string);
}

}
