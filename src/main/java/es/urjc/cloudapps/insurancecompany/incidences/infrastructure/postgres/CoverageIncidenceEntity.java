package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.postgres;

import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres.CoverageEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "coverage_incidences")
public class CoverageIncidenceEntity {

    @Id
    private String id;

    @ManyToMany(mappedBy = "incidences")
    private Set<CoverageEntity> coverages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<CoverageEntity> getCoverages() {
        return coverages;
    }

    public void setCoverages(Set<CoverageEntity> coverages) {
        this.coverages = coverages;
    }
}
