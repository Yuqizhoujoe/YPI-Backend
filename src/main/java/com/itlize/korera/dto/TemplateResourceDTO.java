package com.itlize.korera.dto;

import java.util.*;
import java.util.stream.Collectors;

public class TemplateResourceDTO implements Comparable<TemplateResourceDTO> {

    //////////////////////////////////////
    // PRIVATE FIELDS             ////////
    //////////////////////////////////////

    private int TemplateResourceId;
    private int TemplateId;
    private String TemplateName;
    private String TemplateType;
    private int ResourceId;
    private int TemplateResourceValue;
    private String TemplateResourceText;

    //////////////////////////////////////
    // GETTER SETTER             ////////
    //////////////////////////////////////

    public int getTemplateResourceId() {
        return TemplateResourceId;
    }

    public void setTemplateResourceId(int templateResourceId) {
        TemplateResourceId = templateResourceId;
    }

    public int getTemplateId() {
        return TemplateId;
    }

    public void setTemplateId(int templateId) {
        TemplateId = templateId;
    }

    public int getResourceId() {
        return ResourceId;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
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

    //////////////////////////////////////
    // TO STRING                  ////////
    //////////////////////////////////////

    @Override
    public String toString() {
        return "TemplateResourceDTO{" +
                "TemplateResourceId=" + TemplateResourceId +
                ", TemplateId=" + TemplateId +
                ", TemplateName='" + TemplateName + '\'' +
                ", TemplateType='" + TemplateType + '\'' +
                ", ResourceId=" + ResourceId +
                ", TemplateResourceValue=" + TemplateResourceValue +
                ", TemplateResourceText='" + TemplateResourceText + '\'' +
                '}';
    }


    //////////////////////////////////////
    // COMPARE                    ////////
    //////////////////////////////////////

    @Override
    public int compareTo(TemplateResourceDTO o) {
        return this.getTemplateResourceId() - o.getTemplateResourceId(); // ASC
    }


}

