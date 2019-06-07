package com.unrule;


import javax.persistence.*;

@Entity
@Table(name="t_requestinfo")
public class UnruleRequest {
    /*@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;*/
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", length = 36)
    public String id;

    @Column(name = "email", length = 50)
    public String email;

    @Column(name = "car_number", length = 50)
    public String car_number;

    @Column(name = "unrule_record", length = 50)
    public String unrule_record;

    @Column(name = "content", length = 50)
    public String content;

    @Column(name = "approval",length = 1)
    public int approval;

    @Column(name = "money",length = 5)
    public double money;

    @Column(name = "pointdec",length = 5)
    public int pointdec;
}
