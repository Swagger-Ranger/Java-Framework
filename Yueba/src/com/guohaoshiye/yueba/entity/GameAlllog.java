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
/*     */ 
/*     */ public class GameAlllog
/*     */   implements Serializable
/*     */ {
/*     */   private Integer id;
/*     */   private Integer roomNumber;
/*     */   private Integer playtype;
/*     */   private Integer gamechang;
/*     */   private Integer bankerid;
/*     */   private String alluserid;
/*     */   private String player;
/*     */   private String playback;
/*     */   private String cards;
/*     */   private Timestamp creattime;
/*     */   private String haomiao;
/*     */   
/*     */   public GameAlllog() {}
/*     */   
/*     */   public GameAlllog(Integer roomNumber, Integer playtype, Integer gamechang, Integer bankerid, String alluserid)
/*     */   {
/*  35 */     this.roomNumber = roomNumber;
/*  36 */     this.playtype = playtype;
/*  37 */     this.gamechang = gamechang;
/*  38 */     this.bankerid = bankerid;
/*  39 */     this.alluserid = alluserid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public GameAlllog(Integer roomNumber, Integer playtype, Integer gamechang, Integer bankerid, String alluserid, String player, String playback, String cards, Timestamp creattime, String haomiao)
/*     */   {
/*  46 */     this.roomNumber = roomNumber;
/*  47 */     this.playtype = playtype;
/*  48 */     this.gamechang = gamechang;
/*  49 */     this.bankerid = bankerid;
/*  50 */     this.alluserid = alluserid;
/*  51 */     this.player = player;
/*  52 */     this.playback = playback;
/*  53 */     this.cards = cards;
/*  54 */     this.creattime = creattime;
/*  55 */     this.haomiao = haomiao;
/*     */   }
/*     */   
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  61 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Integer id) {
/*  65 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Integer getRoomNumber() {
/*  69 */     return this.roomNumber;
/*     */   }
/*     */   
/*     */   public void setRoomNumber(Integer roomNumber) {
/*  73 */     this.roomNumber = roomNumber;
/*     */   }
/*     */   
/*     */   public Integer getPlaytype() {
/*  77 */     return this.playtype;
/*     */   }
/*     */   
/*     */   public void setPlaytype(Integer playtype) {
/*  81 */     this.playtype = playtype;
/*     */   }
/*     */   
/*     */   public Integer getGamechang() {
/*  85 */     return this.gamechang;
/*     */   }
/*     */   
/*     */   public void setGamechang(Integer gamechang) {
/*  89 */     this.gamechang = gamechang;
/*     */   }
/*     */   
/*     */   public Integer getBankerid() {
/*  93 */     return this.bankerid;
/*     */   }
/*     */   
/*     */   public void setBankerid(Integer bankerid) {
/*  97 */     this.bankerid = bankerid;
/*     */   }
/*     */   
/*     */   public String getAlluserid() {
/* 101 */     return this.alluserid;
/*     */   }
/*     */   
/*     */   public void setAlluserid(String alluserid) {
/* 105 */     this.alluserid = alluserid;
/*     */   }
/*     */   
/*     */   public String getPlayer() {
/* 109 */     return this.player;
/*     */   }
/*     */   
/*     */   public void setPlayer(String player) {
/* 113 */     this.player = player;
/*     */   }
/*     */   
/*     */   public String getPlayback() {
/* 117 */     return this.playback;
/*     */   }
/*     */   
/*     */   public void setPlayback(String playback) {
/* 121 */     this.playback = playback;
/*     */   }
/*     */   
/*     */   public String getCards() {
/* 125 */     return this.cards;
/*     */   }
/*     */   
/*     */   public void setCards(String cards) {
/* 129 */     this.cards = cards;
/*     */   }
/*     */   
/*     */   public Timestamp getCreattime() {
/* 133 */     return this.creattime;
/*     */   }
/*     */   
/*     */   public void setCreattime(Timestamp creattime) {
/* 137 */     this.creattime = creattime;
/*     */   }
/*     */   
/*     */   public String getHaomiao() {
/* 141 */     return this.haomiao;
/*     */   }
/*     */   
/*     */   public void setHaomiao(String haomiao) {
/* 145 */     this.haomiao = haomiao;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 150 */     return "GameAlllog{id=" + this.id + ", roomNumber=" + this.roomNumber + ", playtype=" + this.playtype + ", gamechang=" + this.gamechang + ", bankerid=" + this.bankerid + ", alluserid='" + this.alluserid + '\'' + ", player='" + this.player + '\'' + ", playback='" + this.playback + '\'' + ", cards='" + this.cards + '\'' + ", creattime=" + this.creattime + ", haomiao='" + this.haomiao + '\'' + '}';
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\entity\GameAlllog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */