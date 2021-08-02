package com.comicsm.comicsmanager.service.util.template;

import java.util.List;
import java.util.Objects;

public class Data {

    private List<Recover> recovers;

    public Data() {}

    public Data(List<Recover> recovers) {
        this.recovers = recovers;
    }

    public List<Recover> getResults() {
        return recovers;
    }

    public void setResults(List<Recover> recovers) {
        this.recovers = recovers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(recovers, data.recovers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recovers);
    }
}
