package es.urjc.cloudapps.insurancecompany.incidences.domain;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.math.BigDecimal;

public class IncidenceAmount {

    private final BigDecimal amount;

    private final CurrencyUnit currency;

    public IncidenceAmount(final BigDecimal amount, final String currency) {

        // TODO: Use non-framework utils to ensure domain properties

        Assert.isTrue(amount != null, "Amount must not be null");
        Assert.isTrue(amount.compareTo(BigDecimal.ZERO) > 0, "Amount must be positive");
        Assert.isTrue(!StringUtils.isEmpty(currency), "Currency string must not be null or empty");
        Assert.isTrue(ensureCurrencyIsValid(currency), "Currency must be valid");

        this.amount = amount;
        this.currency = Monetary.getCurrency(currency);
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

    private boolean ensureCurrencyIsValid(final String currency) {
        try {
            return Monetary.getCurrency(currency) != null;
        } catch (final Exception e) {
            return Boolean.FALSE;
        }
    }
}
