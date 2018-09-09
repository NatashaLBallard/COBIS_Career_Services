package com.cobis_career_services.demo.forms;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Resume {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    //General
    @NotNull
    @Size(min=4)
    private String name;

    @NotNull
    @Size(min=3)
    private String email;

    @NotNull
    @Size(min=5)
    private String linkedin;

    @NotNull
    @Size(min=5)
    private String github;

    @NotNull
    @Size(min=5)
    private String twitter;





    //GETTERS / SETTERS -----------------------------------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }


}