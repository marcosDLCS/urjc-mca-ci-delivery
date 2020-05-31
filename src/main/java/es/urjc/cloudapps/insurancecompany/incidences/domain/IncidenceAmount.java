package es.urjc.cloudapps.insurancecompany.incidences.domain;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.math.BigDecimal;

public class IncidenceAmount {

    private final BigDecimal amount;

    private final CurrencyUnit currency;

    public IncidenceAmount(BigDecimal amount, CurrencyUnit currency) {

        Assert.isTrue(amount != null, "Amount must not be null");
        Assert.isTrue(amount.compareTo(BigDecimal.ZERO) > 0, "Amount must be positive");
        Assert.isTrue(currency != null, "Currency must not be null");

        this.amount = amount;
        this.currency = currency;
    }

    public IncidenceAmount(BigDecimal amount, String currency) {

        Assert.isTrue(amount != null, "Amount must not be null");
        Assert.isTrue(amount.compareTo(BigDecimal.ZERO) > 0, "Amount must be positive");
        Assert.isTrue(!StringUtils.isEmpty(currency), "Currency string must not be null");
        Assert.isTrue(Monetary.getCurrency(currency) != null, "Currency must be valid");

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
}
