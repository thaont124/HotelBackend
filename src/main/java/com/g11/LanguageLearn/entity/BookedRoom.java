package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBookedRoom;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "idRoom")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "idBill")
    private Bill bill;
    private String statusPayment;

    public BookedRoom(Integer idBookedRoom, Room room, Bill bill, String statusPayment) {
        this.idBookedRoom = idBookedRoom;
        this.room = room;
        this.bill = bill;
        this.statusPayment = statusPayment;
    }

    public Integer getIdBookedRoom() {
        return idBookedRoom;
    }

    public void setIdBookedRoom(Integer idBookedRoom) {
        this.idBookedRoom = idBookedRoom;
    }

    public BookedRoom(){

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }
}
