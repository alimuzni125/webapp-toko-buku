package com.embuh.webapptokobuku.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author user
 */


@Entity
public class data_buku {
    
    @Id @Getter @Setter
    private String id;

    @Column @Getter @Setter
    private String judul_buku;
    
    @Column @Getter @Setter
    private String harga;

    
    
}