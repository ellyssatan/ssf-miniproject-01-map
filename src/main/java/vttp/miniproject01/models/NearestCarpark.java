package vttp.miniproject01.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class NearestCarpark {

    CarparkAvail a = new CarparkAvail();
    CarparkDetails d = new CarparkDetails();

    private String carparkNo;      // ppCode
    private String name;      // ppName
    private String lotsAvailable;
    private String lotType;
    private String weekdayMin;
    private String weekdayRate;
    private String parkingSystem;       // C - Coupon Parking System, B - Electronic Parking System
    private String vechicle;        // vehCat
    private String satdayMin;
    private String satdayRate;
    private String sunPHMin;
    private String sunPHRate;
    private String coordinates;
    private String startTime;
    private String endTime;

    public String getWeekdayMin() {     return weekdayMin;  }
    public void setWeekdayMin(String weekdayMin) {      this.weekdayMin = weekdayMin;   }

    public String getWeekdayRate() {    return weekdayRate;     }
    public void setWeekdayRate(String weekdayRate) {    this.weekdayRate = weekdayRate;     }

    public String getCarparkNo() {      return carparkNo;   }
    public void setCarparkNo(String carparkNo) {    this.carparkNo = carparkNo; }

    public String getName() {   return name;    }
    public void setName(String name) {  this.name = name;   }

    public String getParkingSystem() {  return parkingSystem;   }
    public void setParkingSystem(String parkingSystem) {    this.parkingSystem = parkingSystem;     }

    public String getVechicle() {   return vechicle;    }
    public void setVechicle(String vechicle) {      this.vechicle = vechicle;   }

    public String getSatdayMin() {
        return satdayMin;
    }
    public void setSatdayMin(String satdayMin) {
        this.satdayMin = satdayMin;
    }
    public String getSatdayRate() {
        return satdayRate;
    }
    public void setSatdayRate(String satdayRate) {
        this.satdayRate = satdayRate;
    }
    public String getSunPHMin() {
        return sunPHMin;
    }
    public void setSunPHMin(String sunPHMin) {
        this.sunPHMin = sunPHMin;
    }
    public String getSunPHRate() {
        return sunPHRate;
    }
    public void setSunPHRate(String sunPHRate) {
        this.sunPHRate = sunPHRate;
    }
    public String getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getLotsAvailable() {
        return lotsAvailable;
    }
    public void setLotsAvailable(String lotsAvailable) {
        this.lotsAvailable = lotsAvailable;
    }
    public String getLotType() {
        return lotType;
    }
    public void setLotType(String lotType) {
        this.lotType = lotType;
    }
    // Create Model
    public static NearestCarpark create(CarparkAvail a, CarparkDetails d) {
        NearestCarpark n = new NearestCarpark();
        n.setCarparkNo(a.getCarparkNo());
        n.setCoordinates(a.getCoordinates());
        n.setWeekdayMin(d.getWeekdayMin());
        n.setWeekdayRate(d.getWeekdayRate());
        n.setName(d.getName());
        n.setParkingSystem(d.getParkingSystem());
        n.setVechicle(d.getVechicle());
        n.setSatdayMin(d.getSatdayMin());
        n.setSatdayRate(d.getSatdayRate());
        n.setSunPHMin(d.getSunPHMin());
        n.setSunPHRate(d.getSunPHRate());
        n.setStartTime(d.getStartTime());
        n.setEndTime(d.getEndTime());
        n.setLotsAvailable(a.getLotsAvailable());
        n.setLotType(a.getLotType());
        return n;
    }

    // Convert model to JsonObject
    public JsonObject toJson(CarparkAvail a) {
        return Json.createObjectBuilder()
            .add("ppCode", carparkNo)
            .add("coordinates", coordinates)
            .add("weekdayMin", weekdayMin)
            .add("weekdayRate", weekdayRate)
            .add("ppName", name)
            .add("parkingSystem", parkingSystem)
            .add("vehCat", vechicle)
            .add("satdayMin", satdayMin)
            .add("satdayRate", satdayRate)
            .add("sunPHMin", sunPHMin)
            .add("sunPHRate", sunPHRate)
            .add("startTime", startTime)
            .add("endTime", endTime)
            .build();
    }


}
