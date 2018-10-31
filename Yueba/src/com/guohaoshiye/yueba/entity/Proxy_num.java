package com.guohaoshiye.yueba.entity;

public class Proxy_num {
  private Integer id;
  private Integer yiji;
  private Integer erji;
  private Integer sanji;

  public Integer getId() { return this.id; }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getYiji() {
    return this.yiji;
  }

  public void setYiji(Integer yiji) {
    this.yiji = yiji;
  }

  public Integer getErji() {
    return this.erji;
  }

  public void setErji(Integer erji) {
    this.erji = erji;
  }

  public Integer getSanji() {
    return this.sanji;
  }

  public void setSanji(Integer sanji) {
    this.sanji = sanji;
  }

  public Proxy_num(Integer id, Integer yiji, Integer erji, Integer snaji) {
    this.id = id;
    this.yiji = yiji;
    this.erji = erji;
    this.sanji = snaji;
  }

  public Proxy_num() { this.id = this.id;
    this.yiji = this.yiji;
    this.erji = this.erji;
    this.sanji = this.sanji;
  }

  public Proxy_num(Integer yiji, Integer erji, Integer snaji) { this.id = this.id;
    this.yiji = yiji;
    this.erji = erji;
    this.sanji = snaji;
  }
}

