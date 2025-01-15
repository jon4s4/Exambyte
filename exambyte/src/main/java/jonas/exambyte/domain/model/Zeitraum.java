package jonas.exambyte.domain.model;

import java.sql.Date;

public class Zeitraum {
    Date anfangsDatum;
    Date endDatum;

    public Zeitraum(Date anfangsDatum, Date endDatum) {
        this.anfangsDatum = anfangsDatum;
        this.endDatum = endDatum;
    }
}
