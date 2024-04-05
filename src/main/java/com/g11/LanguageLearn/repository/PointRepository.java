package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PointRepository extends JpaRepository<Point,Integer> {
    @Query("select p from Point p where p.user.idUser = :id order by p.idPoint DESC limit 1")
    Point getLastPoint(@Param("id") Integer id);

    @Query("select p from Point p where p.user.idUser = :id order by p.idPoint DESC")
    List<Point> getHistoryPoint(@Param("id") Integer id);

}
