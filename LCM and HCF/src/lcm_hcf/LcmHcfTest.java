package lcm_hcf;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Test;
import org.junit.Test;

public class LcmHcfTest {

	@Test
	public void testLCM() {

		int lcm = LcmHcf.lcm(2, 4);
		assertEquals(4, lcm);
	}

	@Test
	public void testHCF() {

		int hcf = LcmHcf.gcd(2, 4);
		assertEquals(2, hcf);
	}

}