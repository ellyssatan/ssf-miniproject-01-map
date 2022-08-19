package vttp.miniproject01.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class CarparkAvail {
    
    private String carparkNo;
    private String coordinates;
    private String lotsAvailable;
    private String lotType;


    public String getCarparkNo() {  return carparkNo;   }
    public void setCarparkNo(String carparkNo) {    this.carparkNo = carparkNo;     }

    public String getCoordinates() {    return coordinates;     }
    public void setCoordinates(String coordinates) {    this.coordinates = coordinates;     }
    
    public String getLotsAvailable() {      return lotsAvailable;   }
    public void setLotsAvailable(String lotsAvailable) {    this.lotsAvailable = lotsAvailable;     }

    public String getLotType() {    return lotType;     }
    public void setLotType(String lotType) {    this.lotType = lotType;     }

    // Create Model from JsonObject
    public static CarparkAvail create(JsonObject jo, JsonObject coordinates) {
        CarparkAvail n = new CarparkAvail();
        n.setCarparkNo(jo.getString("carparkNo"));
        n.setCoordinates(coordinates.getString("coordinates"));
        n.setLotType(jo.getString("lotType"));
        n.setLotsAvailable(jo.getString("lotsAvailable"));
        // System.out.println("<<<<<coordinates>>>>>" + n.getCoordinates());
        // System.out.println("<<<<<OBJECT>>>>>" + n.toString());
        return n;

    }

    // Convert model to JsonObject
    public JsonObject toJson(CarparkAvail a) {
        return Json.createObjectBuilder()
            .add("carparkNo", carparkNo)
            .add("coordinates", coordinates)
            .add("lotType", lotType)
            .add("lotsAvailable", lotsAvailable)
            .build();
    }
    
    

}
