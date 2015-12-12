package study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.spring.entity.CalculateData;

public interface ICalculateJpaRepository 
extends JpaRepository<CalculateData, String>{

}
