package io.github.butexbackend.model;

public enum FurgonetkaService {

    INPOST(10091112),
    DPD(10091106);

    public Integer id;

    FurgonetkaService(Integer id) {
        this.id = id;
    }
}
