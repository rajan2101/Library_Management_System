package com.lms.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @Column(name = "pub_id")
    private String pubId;
    private String name;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<book> books;

    // Constructors, Getters, Setters
    public Publisher() {}
    public String getPubId() { return pubId; }
    public void setPubId(String pubId) { this.pubId = pubId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}