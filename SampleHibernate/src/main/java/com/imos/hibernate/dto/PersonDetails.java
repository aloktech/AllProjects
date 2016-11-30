/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author Alok
 */
@Entity
@NamedQueries(value = {
    @NamedQuery(name = "PersonDetails.getAll", query = "from PersonDetails pd"),
    @NamedQuery(name = "PersonDetails.getByName", query = "from PersonDetails pd where pd.userName =:name")})
@Getter
@Setter
@ToString(exclude = {"communityCenters"})
public class PersonDetails extends BaseObject {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "USER_ID")
//    private int id;
    @Column(name = "NAME")
    private String userName;

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(
            name = "USER_ADDRESSES",
            joinColumns = @JoinColumn(name = "USER_ID"))
    @GenericGenerator(
            name = "sequence-gen",
            strategy = "sequence")
    @CollectionId(
            columns = {
                @Column(name = "ADDRESS_ID")},
            generator = "sequence-gen",
            type = @Type(type = "long"))
    private Collection<Address> addresses;

//    @OneToOne(cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Collection<Vehicle> vehicles;

    @ManyToMany(fetch = FetchType.LAZY)
//    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_CC",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CC_ID"))
    private Collection<CommunityCenter> communityCenters;

    public PersonDetails() {
        addresses = new ArrayList<>();
        vehicles = new ArrayList<>();
        communityCenters = new ArrayList<>();
    }
}
