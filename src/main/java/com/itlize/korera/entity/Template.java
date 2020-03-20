package com.itlize.korera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


//////////////////////////////////////////////////////////////////////////
// TEMPLATE TABLE ENTITY: TEMPLATE DATA , RELATIONSHIP-> TEMPLATE:PROJECT//
//////////////////////////////////////////////////////////////////////////

@Entity
@Table(name = "templates")
public class Template {

      ///////////////////////////////////////
     // FIELDS(ID,NAME,TEMPLATE:PROJECT) //
    ///////////////////////////////////////

    @Id
    @Column(name = "TemplateId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TemplateId;

    @Column(name = "TemplateName", nullable = false)
    private String TemplateName;

    @Column(name = "TemplateType", nullable = false)
    private String TemplateType;

    @Column(name = "TemplateFormula")
    private String TemplateFormula;

    @ManyToOne(cascade = {
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "ProjectId")
    @JsonIgnore
    private Project project;

    @OneToMany(mappedBy = "template", cascade = {
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<TemplateResource> templateResources;

      //////////////////////////////////////
     // CONSTRUCTORS(NAME,NONE,ID) ////////
    //////////////////////////////////////

    public Template() {
    }

    public Template(int TemplateId) {
        this.TemplateId = TemplateId;
    }

    public Template(String templateName, String templateType, String templateFormula) {
        TemplateName = templateName;
        TemplateType = templateType;
        TemplateFormula = templateFormula;
    }

    /////////////////////////////////////////
     // GETTERS AND SETTERS (ID,NAME,PR(S)) //
    /////////////////////////////////////////

    public int getTemplateId() {
        return TemplateId;
    }

    public void setTemplateId(int templateId) {
        TemplateId = templateId;
    }

    public String getTemplateName() {
        return TemplateName;
    }

    public void setTemplateName(String templateName) {
        TemplateName = templateName;
    }

    public String getTemplateType() {
        return TemplateType;
    }

    public void setTemplateType(String templateType) {
        TemplateType = templateType;
    }

    public String getTemplateFormula() {
        return TemplateFormula;
    }

    public void setTemplateFormula(String templateFormula) {
        TemplateFormula = templateFormula;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    //////////////////////////////////////
     /////// TO-STRING (NAME,ID) //////////
    //////////////////////////////////////

    @Override
    public String toString() {
        return "Template{" +
                "TemplateId=" + TemplateId +
                ", TemplateName='" + TemplateName + '\'' +
                ", TemplateType='" + TemplateType + '\'' +
                ", TemplateFormula='" + TemplateFormula + '\'' +
                ", project=" + project.toString() +
                '}';
    }


    //////////////////////////////////////
    /////// EQUALS  //////////
    //////////////////////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Template)) return false;

        Template template = (Template) o;

        if (TemplateId != template.TemplateId) return false;
        if (TemplateName != null ? !TemplateName.equals(template.TemplateName) : template.TemplateName != null)
            return false;
        if (TemplateType != null ? !TemplateType.equals(template.TemplateType) : template.TemplateType != null)
            return false;
        if (TemplateFormula != null ? !TemplateFormula.equals(template.TemplateFormula) : template.TemplateFormula != null)
            return false;
        return project != null ? project.equals(template.project) : template.project == null;
    }

}
