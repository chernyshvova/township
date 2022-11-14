package com.google.android.material.shape;

public class ShapePathModel {
    public static final CornerTreatment DEFAULT_CORNER_TREATMENT = new CornerTreatment();
    public static final EdgeTreatment DEFAULT_EDGE_TREATMENT = new EdgeTreatment();
    public EdgeTreatment bottomEdge;
    public CornerTreatment bottomLeftCorner;
    public CornerTreatment bottomRightCorner;
    public EdgeTreatment leftEdge;
    public EdgeTreatment rightEdge;
    public EdgeTreatment topEdge;
    public CornerTreatment topLeftCorner;
    public CornerTreatment topRightCorner;

    public ShapePathModel() {
        CornerTreatment cornerTreatment = DEFAULT_CORNER_TREATMENT;
        this.topLeftCorner = cornerTreatment;
        this.topRightCorner = cornerTreatment;
        this.bottomRightCorner = cornerTreatment;
        this.bottomLeftCorner = cornerTreatment;
        EdgeTreatment edgeTreatment = DEFAULT_EDGE_TREATMENT;
        this.topEdge = edgeTreatment;
        this.rightEdge = edgeTreatment;
        this.bottomEdge = edgeTreatment;
        this.leftEdge = edgeTreatment;
    }
}
