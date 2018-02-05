package it.gualtierotesta.playwithjava;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ResultTest {


    @Test
    public void testSuccess() {
        // when
        Result<BigDecimal> res = Result.success(BigDecimal.TEN);
        // then
        assertTrue(res.isSuccess());
        assertEquals(10, res.successValue().intValue());
    }

    @Test(expected = IllegalStateException.class)
    public void testSuccess2() {
        // when
        Result<BigDecimal> res = Result.success(BigDecimal.TEN);
        // then
        assertEquals("no exception", res.errorMessage());
    }

    @Test
    public void testFailure() {
        // when
        Result<BigDecimal> res = Result.failure("failed");
        // then
        assertFalse(res.isSuccess());
        assertEquals("failed", res.errorMessage());
    }

    @Test(expected = IllegalStateException.class)
    public void testFailure2() {
        // when
        Result<BigDecimal> res = Result.failure("failed");
        // then
        assertEquals("no exception", res.successValue());
    }

    @Test
    public void testSerializable() {
        // when
        Result<ArrayList<String>> res = Result.success(new ArrayList<>(Arrays.asList("one", "due")));
        // then
        assertTrue(res.isSuccess());
        assertArrayEquals(new String[]{"one", "due"}, res.successValue().toArray());
    }
}