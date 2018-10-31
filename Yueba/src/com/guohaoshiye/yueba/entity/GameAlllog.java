 package com.guohaoshiye.yueba.entity;

 import java.io.Serializable;
 import java.sql.Timestamp;











 public class GameAlllog
   implements Serializable
 {
   private Integer id;
   private Integer roomNumber;
   private Integer playtype;
   private Integer gamechang;
   private Integer bankerid;
   private String alluserid;
   private String player;
   private String playback;
   private String cards;
   private Timestamp creattime;
   private String haomiao;

   public GameAlllog() {}

   public GameAlllog(Integer roomNumber, Integer playtype, Integer gamechang, Integer bankerid, String alluserid)
   {
     this.roomNumber = roomNumber;
     this.playtype = playtype;
     this.gamechang = gamechang;
     this.bankerid = bankerid;
     this.alluserid = alluserid;
   }



   public GameAlllog(Integer roomNumber, Integer playtype, Integer gamechang, Integer bankerid, String alluserid, String player, String playback, String cards, Timestamp creattime, String haomiao)
   {
     this.roomNumber = roomNumber;
     this.playtype = playtype;
     this.gamechang = gamechang;
     this.bankerid = bankerid;
     this.alluserid = alluserid;
     this.player = player;
     this.playback = playback;
     this.cards = cards;
     this.creattime = creattime;
     this.haomiao = haomiao;
   }


   public Integer getId()
   {
     return this.id;
   }

   public void setId(Integer id) {
     this.id = id;
   }

   public Integer getRoomNumber() {
     return this.roomNumber;
   }

   public void setRoomNumber(Integer roomNumber) {
     this.roomNumber = roomNumber;
   }

   public Integer getPlaytype() {
     return this.playtype;
   }

   public void setPlaytype(Integer playtype) {
     this.playtype = playtype;
   }

   public Integer getGamechang() {
     return this.gamechang;
   }

   public void setGamechang(Integer gamechang) {
     this.gamechang = gamechang;
   }

   public Integer getBankerid() {
     return this.bankerid;
   }

   public void setBankerid(Integer bankerid) {
     this.bankerid = bankerid;
   }

   public String getAlluserid() {
     return this.alluserid;
   }

   public void setAlluserid(String alluserid) {
     this.alluserid = alluserid;
   }

   public String getPlayer() {
     return this.player;
   }

   public void setPlayer(String player) {
     this.player = player;
   }

   public String getPlayback() {
     return this.playback;
   }

   public void setPlayback(String playback) {
     this.playback = playback;
   }

   public String getCards() {
     return this.cards;
   }

   public void setCards(String cards) {
     this.cards = cards;
   }

   public Timestamp getCreattime() {
     return this.creattime;
   }

   public void setCreattime(Timestamp creattime) {
     this.creattime = creattime;
   }

   public String getHaomiao() {
     return this.haomiao;
   }

   public void setHaomiao(String haomiao) {
     this.haomiao = haomiao;
   }

   public String toString()
   {
     return "GameAlllog{id=" + this.id + ", roomNumber=" + this.roomNumber + ", playtype=" + this.playtype + ", gamechang=" + this.gamechang + ", bankerid=" + this.bankerid + ", alluserid='" + this.alluserid + '\'' + ", player='" + this.player + '\'' + ", playback='" + this.playback + '\'' + ", cards='" + this.cards + '\'' + ", creattime=" + this.creattime + ", haomiao='" + this.haomiao + '\'' + '}';
   }
 }

