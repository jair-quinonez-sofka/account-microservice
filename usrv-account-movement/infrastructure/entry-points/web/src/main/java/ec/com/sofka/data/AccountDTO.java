package ec.com.sofka.data;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AccountDTO {
    @NotNull(message = "accountNumber cannot be null")
    private String accountNumber;
    @NotNull(message = "accountType cannot be null")
    private String accountType;
    @NotNull(message = "initialBalance cannot be null")
    private BigDecimal initialBalance;
    @NotNull(message = "clientIdentification cannot be null")
    private String clientIdentification;

    private boolean status;

    public AccountDTO(String accountNumber, String accountType, BigDecimal initialBalance, String clientIdentification, boolean status) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.clientIdentification = clientIdentification;
        this.status = status;
    }

    public String getClientIdentification() {
        return clientIdentification;
    }

    public void setClientIdentification(String clientIdentification) {
        this.clientIdentification = clientIdentification;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
