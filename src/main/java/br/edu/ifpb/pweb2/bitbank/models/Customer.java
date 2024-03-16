package br.edu.ifpb.pweb2.bitbank.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String email;

    private String password;

    private boolean admin;
}