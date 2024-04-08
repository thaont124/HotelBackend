package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Utility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilityRepository extends JpaRepository<Utility, Integer> {

    @Query("SELECT u FROM Utility u join TypeRoomUtility tu ON tu.utility.idUtility = u.idUtility where tu.typeRoom.idTypeRoom=:idTypeRoom")
    List<Utility> getListByTypeRoomID(@Param("idTypeRoom") Integer idTypeRoom);
}
