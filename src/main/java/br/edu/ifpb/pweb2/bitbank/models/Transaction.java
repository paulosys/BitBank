package br.edu.ifpb.pweb2.bitbank.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String description;

    private BigDecimal value;

    private Date date;

    private Customer customer;
}
