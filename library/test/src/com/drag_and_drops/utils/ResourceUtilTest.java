package src.com.drag_and_drops.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.drag_and_drops.utils.ResourceUtil;

public class ResourceUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPropertyValueString() {
		// OK
		assertEquals("sun", ResourceUtil.getPropertyValue("sun"));

		// NG
		assertNull(ResourceUtil.getPropertyValue("xxx"));
	}

	@Test
	public void testGetPropertyValueStringString() {
		// OK
		assertEquals("sun", ResourceUtil.getPropertyValue("application.properties", "sun"));
	}

}
