package com.ieoli.entity;

public class ResultEntity {
    private Integer resultid;

    private Integer textid;

    private Integer modelid;

    private Boolean isstricttrue;

    private Boolean iseasytrue;

    private Integer userid;

    private Boolean useful;

    private String label;

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public Integer getTextid() {
        return textid;
    }

    public void setTextid(Integer textid) {
        this.textid = textid;
    }

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

    public Boolean getIsstricttrue() {
        return isstricttrue;
    }

    public void setIsstricttrue(Boolean isstricttrue) {
        this.isstricttrue = isstricttrue;
    }

    public Boolean getIseasytrue() {
        return iseasytrue;
    }

    public void setIseasytrue(Boolean iseasytrue) {
        this.iseasytrue = iseasytrue;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getUseful() {
        return useful;
    }

    public void setUseful(Boolean useful) {
        this.useful = useful;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}