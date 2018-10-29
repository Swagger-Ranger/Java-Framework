/*     */ package com.aiwan.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.sql.Timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PumpLog
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Integer uid;
/*     */   private Integer tableid;
/*     */   private Integer tabletype;
/*     */   private Integer gamechang;
/*     */   private Integer isbanker;
/*     */   private String allpump;
/*     */   private String pingtaipump;
/*     */   private Integer oneproxyid;
/*     */   private String oneproxypump;
/*     */   private String pingtaione;
/*     */   private Integer twoproxyid;
/*     */   private String twoproxypump;
/*     */   private String pingtaitwo;
/*     */   private Integer threeproxyid;
/*     */   private String threeproxypump;
/*     */   private String pingtaithree;
/*     */   private Timestamp createtime;
/*     */   private String haomiao;
/*     */   
/*     */   public PumpLog() {}
/*     */   
/*     */   public PumpLog(Integer uid, String allpump, String pingtaipump)
/*     */   {
/*  42 */     this.uid = uid;
/*  43 */     this.allpump = allpump;
/*  44 */     this.pingtaipump = pingtaipump;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PumpLog(Integer uid, Integer tableid, Integer tabletype, Integer gamechang, Integer isbanker, String allpump, String pingtaipump, Integer oneproxyid, String oneproxypump, String pingtaione, Integer twoproxyid, String twoproxypump, String pingtaitwo, Integer threeproxyid, String threeproxypump, String pingtaithree, Timestamp createtime, String haomiao)
/*     */   {
/*  54 */     this.uid = uid;
/*  55 */     this.tableid = tableid;
/*  56 */     this.tabletype = tabletype;
/*  57 */     this.gamechang = gamechang;
/*  58 */     this.isbanker = isbanker;
/*  59 */     this.allpump = allpump;
/*  60 */     this.pingtaipump = pingtaipump;
/*  61 */     this.oneproxyid = oneproxyid;
/*  62 */     this.oneproxypump = oneproxypump;
/*  63 */     this.pingtaione = pingtaione;
/*  64 */     this.twoproxyid = twoproxyid;
/*  65 */     this.twoproxypump = twoproxypump;
/*  66 */     this.pingtaitwo = pingtaitwo;
/*  67 */     this.threeproxyid = threeproxyid;
/*  68 */     this.threeproxypump = threeproxypump;
/*  69 */     this.pingtaithree = pingtaithree;
/*  70 */     this.createtime = createtime;
/*  71 */     this.haomiao = haomiao;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  77 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  81 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getUid() {
/*  85 */     return this.uid;
/*     */   }
/*     */   
/*     */   public void setUid(Integer uid) {
/*  89 */     this.uid = uid;
/*     */   }
/*     */   
/*     */   public Integer getTableid() {
/*  93 */     return this.tableid;
/*     */   }
/*     */   
/*     */   public void setTableid(Integer tableid) {
/*  97 */     this.tableid = tableid;
/*     */   }
/*     */   
/*     */   public Integer getTabletype() {
/* 101 */     return this.tabletype;
/*     */   }
/*     */   
/*     */   public void setTabletype(Integer tabletype) {
/* 105 */     this.tabletype = tabletype;
/*     */   }
/*     */   
/*     */   public Integer getGamechang() {
/* 109 */     return this.gamechang;
/*     */   }
/*     */   
/*     */   public void setGamechang(Integer gamechang) {
/* 113 */     this.gamechang = gamechang;
/*     */   }
/*     */   
/*     */   public Integer getIsbanker() {
/* 117 */     return this.isbanker;
/*     */   }
/*     */   
/*     */   public void setIsbanker(Integer isbanker) {
/* 121 */     this.isbanker = isbanker;
/*     */   }
/*     */   
/*     */   public String getAllpump() {
/* 125 */     return this.allpump;
/*     */   }
/*     */   
/*     */   public void setAllpump(String allpump) {
/* 129 */     this.allpump = allpump;
/*     */   }
/*     */   
/*     */   public String getPingtaipump() {
/* 133 */     return this.pingtaipump;
/*     */   }
/*     */   
/*     */   public void setPingtaipump(String pingtaipump) {
/* 137 */     this.pingtaipump = pingtaipump;
/*     */   }
/*     */   
/*     */   public Integer getOneproxyid() {
/* 141 */     return this.oneproxyid;
/*     */   }
/*     */   
/*     */   public void setOneproxyid(Integer oneproxyid) {
/* 145 */     this.oneproxyid = oneproxyid;
/*     */   }
/*     */   
/*     */   public String getOneproxypump() {
/* 149 */     return this.oneproxypump;
/*     */   }
/*     */   
/*     */   public void setOneproxypump(String oneproxypump) {
/* 153 */     this.oneproxypump = oneproxypump;
/*     */   }
/*     */   
/*     */   public String getPingtaione() {
/* 157 */     return this.pingtaione;
/*     */   }
/*     */   
/*     */   public void setPingtaione(String pingtaione) {
/* 161 */     this.pingtaione = pingtaione;
/*     */   }
/*     */   
/*     */   public Integer getTwoproxyid() {
/* 165 */     return this.twoproxyid;
/*     */   }
/*     */   
/*     */   public void setTwoproxyid(Integer twoproxyid) {
/* 169 */     this.twoproxyid = twoproxyid;
/*     */   }
/*     */   
/*     */   public String getTwoproxypump() {
/* 173 */     return this.twoproxypump;
/*     */   }
/*     */   
/*     */   public void setTwoproxypump(String twoproxypump) {
/* 177 */     this.twoproxypump = twoproxypump;
/*     */   }
/*     */   
/*     */   public String getPingtaitwo() {
/* 181 */     return this.pingtaitwo;
/*     */   }
/*     */   
/*     */   public void setPingtaitwo(String pingtaitwo) {
/* 185 */     this.pingtaitwo = pingtaitwo;
/*     */   }
/*     */   
/*     */   public Integer getThreeproxyid() {
/* 189 */     return this.threeproxyid;
/*     */   }
/*     */   
/*     */   public void setThreeproxyid(Integer threeproxyid) {
/* 193 */     this.threeproxyid = threeproxyid;
/*     */   }
/*     */   
/*     */   public String getThreeproxypump() {
/* 197 */     return this.threeproxypump;
/*     */   }
/*     */   
/*     */   public void setThreeproxypump(String threeproxypump) {
/* 201 */     this.threeproxypump = threeproxypump;
/*     */   }
/*     */   
/*     */   public String getPingtaithree() {
/* 205 */     return this.pingtaithree;
/*     */   }
/*     */   
/*     */   public void setPingtaithree(String pingtaithree) {
/* 209 */     this.pingtaithree = pingtaithree;
/*     */   }
/*     */   
/*     */   public Timestamp getCreatetime() {
/* 213 */     return this.createtime;
/*     */   }
/*     */   
/*     */   public void setCreatetime(Timestamp createtime) {
/* 217 */     this.createtime = createtime;
/*     */   }
/*     */   
/*     */   public String getHaomiao() {
/* 221 */     return this.haomiao;
/*     */   }
/*     */   
/*     */   public void setHaomiao(String haomiao) {
/* 225 */     this.haomiao = haomiao;
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\PumpLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */