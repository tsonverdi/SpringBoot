package com.tpe.repository;

import com.tpe.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {//En onemli farklilik Spring Boottaki. Hic hibernate session factory filan yapmadan direkt methodlar geliyor.
    boolean existsByEmail(String email);//bunu kendimiz olusturduk.Turetilebilir method
}
