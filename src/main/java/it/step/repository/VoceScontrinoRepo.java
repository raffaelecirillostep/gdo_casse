package it.step.repository;

import it.step.models.VoceScontrino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VoceScontrinoRepo extends JpaRepository<VoceScontrino, Integer> {
    @Query("SELECT v FROM VoceScontrino v WHERE v.scontrinoID IN (SELECT s.id FROM Scontrino s WHERE s.data = :dataScontrino)")
    List<VoceScontrino> findByDataScontrino(@Param("dataScontrino") Date dataScontrino);

    @Query("SELECT v FROM VoceScontrino v WHERE v.scontrinoID IN (SELECT s.id FROM Scontrino s WHERE extract(year FROM s.data)= :annoScontrino)")
    List<VoceScontrino> findByAnnoScontrino(@Param("annoScontrino") int annoScontrino);
}
