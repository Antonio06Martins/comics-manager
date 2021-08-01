package com.comicsm.comicsmanager.service.util.model;

import java.util.List;

public class Data {

    private List<Recover> recovers;

    public List<Recover> getResults() {
        return recovers;
    }

    public void setResults(List<Recover> recovers) {
        this.recovers = recovers;
    }

    public Data(List<Recover> recovers) {
        super();
        this.recovers = recovers;
    }

    public Data() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((recovers == null) ? 0 : recovers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if (recovers == null) {
            if (other.recovers != null)
                return false;
        } else if (!recovers.equals(other.recovers))
            return false;
        return true;
    }
}
