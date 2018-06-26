package com.byhovsky.fixr.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME")
    private String firtsName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private char[] password;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for property 'firtsName'.
     *
     * @return Value for property 'firtsName'.
     */
    public String getFirtsName() {
        return firtsName;
    }

    /**
     * Setter for property 'firtsName'.
     *
     * @param firtsName Value to set for property 'firtsName'.
     */
    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    /**
     * Getter for property 'lastName'.
     *
     * @return Value for property 'lastName'.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for property 'lastName'.
     *
     * @param lastName Value to set for property 'lastName'.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for property 'login'.
     *
     * @return Value for property 'login'.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter for property 'login'.
     *
     * @param login Value to set for property 'login'.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter for property 'password'.
     *
     * @return Value for property 'password'.
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * Setter for property 'password'.
     *
     * @param password Value to set for property 'password'.
     */
    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (firtsName != null ? !firtsName.equals(account.firtsName) : account.firtsName != null) return false;
        if (lastName != null ? !lastName.equals(account.lastName) : account.lastName != null) return false;
        if (login != null ? !login.equals(account.login) : account.login != null) return false;
        return Arrays.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firtsName != null ? firtsName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firtsName='" + firtsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
