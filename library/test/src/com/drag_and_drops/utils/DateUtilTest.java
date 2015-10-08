package src.com.drag_and_drops.utils;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.drag_and_drops.utils.DateUtil;

public class DateUtilTest {

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
	public void testGetDayOfWeek() {
		try {
			assertEquals("金", DateUtil.getDayOfWeek(DateUtil.parseDate("yyyy/mm/dd", "2016/01/01")));
			assertEquals("土", DateUtil.getDayOfWeek(DateUtil.parseDate("yyyy/mm/dd", "2016/01/02")));
			assertEquals("日", DateUtil.getDayOfWeek(DateUtil.parseDate("yyyy/mm/dd", "2016/01/03")));
			assertEquals("月", DateUtil.getDayOfWeek(DateUtil.parseDate("yyyy/mm/dd", "2016/01/04")));
			assertEquals("火", DateUtil.getDayOfWeek(DateUtil.parseDate("yyyy/mm/dd", "2016/01/05")));
			assertEquals("水", DateUtil.getDayOfWeek(DateUtil.parseDate("yyyy/mm/dd", "2016/01/06")));
			assertEquals("木", DateUtil.getDayOfWeek(DateUtil.parseDate("yyyy/mm/dd", "2016/01/07")));
			assertEquals("", DateUtil.getDayOfWeek(null));
		} catch (ParseException e) {
			fail();
		}
	}

}
