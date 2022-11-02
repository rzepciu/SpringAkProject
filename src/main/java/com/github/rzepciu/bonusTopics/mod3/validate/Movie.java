package com.github.rzepciu.bonusTopics.mod3.validate;

import javax.validation.constraints.*;

public class Movie {

    @NotNull(message = "Dawaj Imie kurwo")
    @Size(min = 2)
    private String name;

    @NotNull
    @Email
    private String reportersMail;

    @NotNull
    @Min(2000)
    @Max(2020)
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReportersMail() {
        return reportersMail;
    }

    public void setReportersMail(String reportersMail) {
        this.reportersMail = reportersMail;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
