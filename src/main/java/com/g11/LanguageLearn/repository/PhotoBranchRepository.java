package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Branch;
import com.g11.LanguageLearn.entity.Photo;
import com.g11.LanguageLearn.entity.PhotoBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoBranchRepository extends JpaRepository<PhotoBranch, Integer> {
    @Query("SELECT p FROM PhotoBranch p WHERE p.branch.idBranch = :idBranch")
    List<Photo> getPhotoByIdHotel(@Param("idBranch") Integer idBranch);

    List<PhotoBranch> findPhotoBranchByBranch(Branch branch);
}
