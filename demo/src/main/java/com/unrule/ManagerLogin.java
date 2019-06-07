package com.unrule;


import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name="t_managerlogin")
public class ManagerLogin {
    /*@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;*/
    /*@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", length = 36)
    public String id;*/
    @Id
    @Column(name = "login_name", length = 50)
    public String login_name;

    @Column(name = "login_pwd", length = 50)
    public String login_pwd;
}
