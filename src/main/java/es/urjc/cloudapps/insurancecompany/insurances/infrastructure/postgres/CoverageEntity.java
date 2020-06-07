package es.urjc.cloudapps.insurancecompany.insurances.infrastructure.postgres;

import es.urjc.cloudapps.insurancecompany.incidences.infrastructure.postgres.CoverageIncidenceEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "coverages")
public class CoverageEntity {

    @Id
    private String id;

    @ManyToMany
    @JoinTable(
            name = "coverages_and_incidences",
            joinColumns = @JoinColumn(name = "coverage_id"),
            inverseJoinColumns = @JoinColumn(name = "incidence_id")
    )
    private Set<CoverageIncidenceEntity> incidences;

    @ManyToMany(mappedBy = "coverages")
    private Set<InsuranceEntity> insurances;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<CoverageIncidenceEntity> getIncidences() {
        return incidences;
    }

    public void setIncidences(Set<CoverageIncidenceEntity> incidences) {
        this.incidences = incidences;
    }

    public Set<InsuranceEntity> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<InsuranceEntity> insurances) {
        this.insurances = insurances;
    }
}
