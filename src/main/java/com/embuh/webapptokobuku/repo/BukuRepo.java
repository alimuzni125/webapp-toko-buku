/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embuh.webapptokobuku.repo;

/**
 *
 * @author Muzni
 */
import com.embuh.webapptokobuku.entity.data_buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BukuRepo

	extends JpaRepository<data_buku,String> {}