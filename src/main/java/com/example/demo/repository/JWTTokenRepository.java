package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.JWTToken;

public interface JWTTokenRepository extends JpaRepository<JWTToken, Integer> {
}
