package test.mock;

//import com.sun.java.util.jar.pack.ConstantPool;
import file.CreateCSV;
import file.CreateCSV2;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.handler.MockHandlerFactory;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;

public class MockTest {
	public CreateCSV2 csv;

	@Before
	public void before(){
		csv = mock(CreateCSV2.class);
	}

	@Test
	public void testVF(){
		String s = "1.0";
		Integer integer = Integer.valueOf(s.substring(0, s.indexOf(".")));
		System.out.println(integer);
	}

	@Test
	public void testMock(){
		try {
			when(csv.createCSV()).thenReturn(true);
			assertEquals(true,csv.createCSV());
			assertEquals(false,csv.createCSV());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
