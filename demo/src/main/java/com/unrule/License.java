package com.unrule;


import javax.persistence.*;

@Entity
@Table(name="t_licensescore")
public class License {
    /*@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;*/
    /*@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", length = 36)
    public String id;*/
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", length = 36)
    public String id;

    @Column(name = "name", length = 50)
    public String name;

    @Column(name = "id_card", length = 50)
    public String id_card;

    @Column(name = "licensenumber", length = 50)
    public String  licensenumber;

    @Column(name = "score", length = 50)
    public String score;

    @Column(name = "remarks",length = 5)
    public String remarks;
}
