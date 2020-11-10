package ch.bbc.uek223.jeers.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
@NamedQueries({@NamedQuery(name = "Person.findAll", query = "select p from Person p order by p.name"),
        @NamedQuery(name = "Person.findByName", query = "select p from Person p where p.name = :name")})
public class Person extends AbstractBaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "VORNAME", nullable = false)
    private String vorname;

    @Column(name = "ADRESSE", nullable = false)
    private String adresse;

    @Column(name = "ORT", nullable = false)
    private String ort;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORT")
    private String passwort;

    // Rückbeziehung
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "person")
    private List<PersonRolle> personRolle = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PersonRolle> getPersonRolle() {
        return personRolle;
    }

    public void setPersonRolle(List<PersonRolle> personRolle) {
        this.personRolle = personRolle;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }


}
