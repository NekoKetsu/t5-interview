package com.talentroc.t5.interview.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.tapestry5.beaneditor.NonVisual;

import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({@NamedQuery(name = Contact.RETRIEVE_ALL, query = "SELECT c FROM Contact c")})
public class Contact implements Serializable {
    public static final java.lang.String RETRIEVE_ALL = "Conctact.retrieveALl";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 10)
    private String telephone;

    public Contact() {
    }

    public Contact(final String firstName, final String lastName, final String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    @NonVisual
    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return Objects.hash(firstName, lastName, telephone);
        } else {
            return Objects.hashCode(id);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (id == null) {
            return Objects.equals(this.firstName, other.firstName)
                    && Objects.equals(this.lastName, other.lastName)
                    && Objects.equals(this.telephone, other.telephone);
        } else {
            return Objects.equals(this.id, other.id);
        }
    }
}
