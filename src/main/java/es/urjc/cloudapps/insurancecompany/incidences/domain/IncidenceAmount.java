package es.urjc.cloudapps.insurancecompany.incidences.domain;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.math.BigDecimal;

public class IncidenceAmount {

    private final BigDecimal amount;

    private final CurrencyUnit currency;

    public IncidenceAmount(final BigDecimal amount, final String currency) {
        ensureAmountIsPresent(amount);
        ensureAmountIsPositive(amount);
        ensureCurrencyIsPresent(currency);
        ensureCurrencyIsValid(currency);

        this.amount   = amount;
        this.currency = Monetary.getCurrency(currency);
    }

    private static void ensureAmountIsPresent(final BigDecimal amount) {
        if (amount == null) throw new IllegalArgumentException("Amount must not be null");
    }

    private static void ensureAmountIsPositive(final BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 1) throw new IllegalArgumentException("Amount must be positive");
    }

    private static void ensureCurrencyIsPresent(final String cur) {
        if (cur == null || cur.isBlank())
            throw new IllegalArgumentException("Currency string must not be null or empty");
    }

    private static void ensureCurrencyIsValid(final String cur) {
        try {
            Monetary.getCurrency(cur);
        } catch (final Exception e) {
            throw new IllegalArgumentException("Currency must be valid");
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public CurrencyUnit getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "IncidenceAmount{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
