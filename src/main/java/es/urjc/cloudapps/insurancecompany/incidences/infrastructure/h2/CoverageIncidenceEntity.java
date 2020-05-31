package es.urjc.cloudapps.insurancecompany.incidences.infrastructure.h2;

import es.urjc.cloudapps.insurancecompany.insurances.infrastructure.h2.CoverageEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
