package com.serveeasy.model.product;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * User: cristian.popovici
 * Date: Nov 9, 2010
 * Time: 2:48:17 PM
 */

public class AmmountTest extends TestCase {

    private Currency currency = Currency.getInstance(Locale.UK);

    @Test
    public void testAddAmmount() {

        Amount actualAmount = Amount.newAmount(currency, 12.2);
        actualAmount.add(BigDecimal.valueOf(10));

        Amount expectedAmount = Amount.newAmount(currency, 22.2);

        assertEquals(actualAmount, expectedAmount);
    }

    @Test
    public void testSubstrcatAmmount() {
        Amount actualAmount = Amount.newAmount(currency, 12.2);
        actualAmount.substract(BigDecimal.valueOf(10));

        Amount expectedAmount = Amount.newAmount(currency, 2.2);

        assertEquals(actualAmount, expectedAmount);
    }

    @Test
    public void tesAddAmountWithDifferentCurrencies() {

    }

}
