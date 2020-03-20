package com.itlize.korera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


//////////////////////////////////////////////////////////////////////////
                         // TEMPLATE TABLE ENTITY: TEMPLATE DATA , RELATIONSHIP-> TEMPLATE:PROJECT//
                        //////////////////////////////////////////////////////////////////////////

@Entity
@Table(name = "template_resource")
public class TemplateResource implements Comparable<TemplateResource> {

      ///////////////////////////////////////
     // FIELDS(ID,NAME,TEMPLATERESOURCE: TEMPLATERESOURCE) //
    ///////////////////////////////////////

    @Id
    @Column(name = "TemplateResourceId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TemplateResourceId;

    @Column(name = "TemplateResourceValue")
    private int TemplateResourceValue;

    @Column(name = "TemplateResourceText")
    private String TemplateResourceText;

    @ManyToOne(cascade = {
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "TemplateId")
    @JsonIgnore
    private Template template;

    @ManyToOne(cascade = {
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "ResourceId")
    @JsonIgnore
    private Resource resource;

      //////////////////////////////////////
     // CONSTRUCTORS(NAME,NONE,ID) ////////
    //////////////////////////////////////

    public TemplateResource() {
    }


    public TemplateResource(int TemplateResourceId) {
        this.TemplateResourceId = TemplateResourceId;
    }

    /////////////////////////////////////////
     // GETTERS AND SETTERS (ID,NAME,PR(S)) //
    /////////////////////////////////////////

    public int getTemplateResourceId() {
        return TemplateResourceId;
    }

    public void setTemplateResourceId(int templateResourceId) {
        TemplateResourceId = templateResourceId;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public int getTemplateResourceValue() {
        return TemplateResourceValue;
    }

    public void setTemplateResourceValue(int templateResourceValue) {
        TemplateResourceValue = templateResourceValue;
    }

    public String getTemplateResourceText() {
        return TemplateResourceText;
    }

    public void setTemplateResourceText(String templateResourceText) {
        TemplateResourceText = templateResourceText;
    }


    //////////////////////////////////////
     /////// TO-STRING (NAME,ID) //////////
    //////////////////////////////////////

    @Override
    public String toString() {
        return "TemplateResource{" +
                "TemplateResourceId=" + TemplateResourceId +
                ", template=" + template.toString() +
                ", resource=" + resource.toString() +
                '}';
    }


    //////////////////////////////////////
    /////// EQUALS              //////////
    //////////////////////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateResource)) return false;

        TemplateResource that = (TemplateResource) o;

        if (TemplateResourceId != that.TemplateResourceId) return false;
        if (template != null ? !template.equals(that.template) : that.template != null) return false;
        return resource != null ? resource.equals(that.resource) : that.resource == null;
    }

    //////////////////////////////////////
    /////// COMPARE              //////////
    //////////////////////////////////////

    @Override
    public int compareTo(TemplateResource o) {
        return this.getTemplateResourceId() - o.getTemplateResourceId();
    }

}
