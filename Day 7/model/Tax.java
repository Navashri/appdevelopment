package com.nextax.nextax.model;

import jakarta.persistence.*;

@Entity
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double grossIncome;
    private Double allowances;
    private Double bonuses;
    private Double commissions;
    private Double otherIncome;
    private Double lifeInsurance;
    private Double ppf;
    private Double taxSavingFD;
    private Double housingLoanPrincipal;
    private Double elss;
    private Double selfFamily;
    private Double preventiveCheckup;
    private Double parentsBelow60;
    private Double parentsAbove60;
    private Double hra;
    private Double nps;
    private Double donation;
    private Double savingInterest;
    private String filingStatus;
    private Double childTaxCredits;
    private Double earnedIncomeCredits;
    private Double educationCredits;

    @OneToOne(mappedBy = "tax", cascade = CascadeType.ALL)
    private UserData userData;

    @Transient
    private Double total;
    @Transient
    private Double tax;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Double getAllowances() {
        return allowances;
    }

    public void setAllowances(Double allowances) {
        this.allowances = allowances;
    }

    public Double getBonuses() {
        return bonuses;
    }

    public void setBonuses(Double bonuses) {
        this.bonuses = bonuses;
    }

    public Double getCommissions() {
        return commissions;
    }

    public void setCommissions(Double commissions) {
        this.commissions = commissions;
    }

    public Double getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(Double otherIncome) {
        this.otherIncome = otherIncome;
    }

    public Double getLifeInsurance() {
        return lifeInsurance;
    }

    public void setLifeInsurance(Double lifeInsurance) {
        this.lifeInsurance = lifeInsurance;
    }

    public Double getPpf() {
        return ppf;
    }

    public void setPpf(Double ppf) {
        this.ppf = ppf;
    }

    public Double getTaxSavingFD() {
        return taxSavingFD;
    }

    public void setTaxSavingFD(Double taxSavingFD) {
        this.taxSavingFD = taxSavingFD;
    }

    public Double getHousingLoanPrincipal() {
        return housingLoanPrincipal;
    }

    public void setHousingLoanPrincipal(Double housingLoanPrincipal) {
        this.housingLoanPrincipal = housingLoanPrincipal;
    }

    public Double getElss() {
        return elss;
    }

    public void setElss(Double elss) {
        this.elss = elss;
    }

    public Double getSelfFamily() {
        return selfFamily;
    }

    public void setSelfFamily(Double selfFamily) {
        this.selfFamily = selfFamily;
    }

    public Double getPreventiveCheckup() {
        return preventiveCheckup;
    }

    public void setPreventiveCheckup(Double preventiveCheckup) {
        this.preventiveCheckup = preventiveCheckup;
    }

    public Double getParentsBelow60() {
        return parentsBelow60;
    }

    public void setParentsBelow60(Double parentsBelow60) {
        this.parentsBelow60 = parentsBelow60;
    }

    public Double getParentsAbove60() {
        return parentsAbove60;
    }

    public void setParentsAbove60(Double parentsAbove60) {
        this.parentsAbove60 = parentsAbove60;
    }

    public Double getHra() {
        return hra;
    }

    public void setHra(Double hra) {
        this.hra = hra;
    }

    public Double getNps() {
        return nps;
    }

    public void setNps(Double nps) {
        this.nps = nps;
    }

    public Double getDonation() {
        return donation;
    }

    public void setDonation(Double donation) {
        this.donation = donation;
    }

    public Double getSavingInterest() {
        return savingInterest;
    }

    public void setSavingInterest(Double savingInterest) {
        this.savingInterest = savingInterest;
    }

    public String getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(String filingStatus) {
        this.filingStatus = filingStatus;
    }

    public Double getChildTaxCredits() {
        return childTaxCredits;
    }

    public void setChildTaxCredits(Double childTaxCredits) {
        this.childTaxCredits = childTaxCredits;
    }

    public Double getEarnedIncomeCredits() {
        return earnedIncomeCredits;
    }

    public void setEarnedIncomeCredits(Double earnedIncomeCredits) {
        this.earnedIncomeCredits = earnedIncomeCredits;
    }

    public Double getEducationCredits() {
        return educationCredits;
    }

    public void setEducationCredits(Double educationCredits) {
        this.educationCredits = educationCredits;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @Transient
    public Double getTotal() {
        return (grossIncome + allowances + bonuses + commissions + otherIncome)
                - (lifeInsurance + ppf + taxSavingFD + housingLoanPrincipal + elss + selfFamily 
                + preventiveCheckup + parentsBelow60 + parentsAbove60 + hra + nps + donation 
                + savingInterest + childTaxCredits + earnedIncomeCredits + educationCredits);
    }

    @Transient
    public Double getTax() {
        Double total = getTotal();
        if (total < 300000) {
            return 0.0;
        } else if (total <= 700000) {
            return total * 0.05;
        } else if (total <= 1000000) {
            return total * 0.10;
        } else if (total <= 1200000) {
            return total * 0.15;
        } else if (total <= 1500000) {
            return total * 0.20;
        } else {
            return total * 0.30;
        }
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}