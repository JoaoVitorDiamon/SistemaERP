package com.system.SystemERP.Entity.Size;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
@Data
public class Size {

    private double Weight;
    private double Length;
    private double Height;
    private double Width;
    private double Volume;
    private double Area;

    public Size() {
    }

    public Size(double weight, double length, double height, double width, double volume, double area) {
        Weight = weight;
        Length = length;
        Height = height;
        Width = width;
        Volume = volume;
        Area = area;
    }

}
